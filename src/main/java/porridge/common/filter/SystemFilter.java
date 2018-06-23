package porridge.common.filter;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class SystemFilter implements Filter{
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("System init ....");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Date beginDate = new Date();
        HttpServletRequest req = (HttpServletRequest)request;
        String url = req.getServletPath();

        chain.doFilter(request, response);
        StringBuffer stb = new StringBuffer();
        @SuppressWarnings("rawtypes")
        Enumeration enu=request.getParameterNames();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            String value = request.getParameter(key);
            stb.append(key + "=" + value + "&");
        }
        logger.info(String.format("%s %s URL: %s %sms params:%s", getClientIP(req), req.getMethod(), url, new Date().getTime() - beginDate.getTime(), stb.toString()));
    }

    public String getClientIP(HttpServletRequest httpservletrequest) {
        if (httpservletrequest == null)
            return null;
        String s = httpservletrequest.getHeader("X-Forwarded-For");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("WL-Proxy-Client-IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("HTTP_CLIENT_IP");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getHeader("HTTP_X_FORWARDED_FOR");
        if (s == null || s.length() == 0 || "unknown".equalsIgnoreCase(s))
            s = httpservletrequest.getRemoteAddr();
        return s;
    }

    @Override
    public void destroy() {
        logger.info("System destroy ....");
    }

}