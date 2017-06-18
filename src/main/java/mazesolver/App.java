package mazesolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@EnableAsync
@SpringBootApplication
public class App extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        java.security.Security.setProperty("networkaddress.cache.ttl" , "60");
        SpringApplication.run(App.class, args);
    }

}