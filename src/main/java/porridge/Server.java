package porridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;

@EnableAutoConfiguration
@ComponentScan("porridge")
@SpringBootApplication
public class Server {
	public static void main(String[] args) {
		SpringApplication.run (Server.class, args);
	}
}
