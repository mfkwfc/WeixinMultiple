package porridge.common.exception;

/**
 *
 *
 * @Title: InJapanException.java
 * @Package com.tensei.injapan.common.exception
 * @Description: TODO
 * @author porridge
 * @date  2016年4月28日 下午3:38:35
 * @version V1.0
 */
public class SystemException extends RuntimeException{
    private static final long serialVersionUID = -6434860015551743202L;
    protected int httpCode;
    protected int retCode;
    protected String msg;

    public SystemException(int httpCode, int retCode, String msg) {
        super(msg);
        this.httpCode = httpCode;
        this.retCode = retCode;
        this.msg = msg;
    }
    /**
     * 异常抛出接口
     * @param httpCode 返回http code 参考 HttpStatusCode
     * @param retCode  返回业务错误码
     * @param msg  返回错误信息
     * @param cause 错误或异常的超类
     * @param enableSuppression 是否静默
     * @param writableStackTrace 是否打印堆栈
     */
    public SystemException(int httpCode, int retCode, String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.httpCode = httpCode;
        this.retCode = retCode;
        this.msg = msg;
    }

    public SystemException(int httpCode, int retCode, String msg, Throwable cause) {
        super(msg, cause);
        this.httpCode = httpCode;
        this.retCode = retCode;
        this.msg = msg;
    }

    public int getHttpCode() {
        return httpCode;
    }
    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
    public int getRetCode() {
        return retCode;
    }
    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}