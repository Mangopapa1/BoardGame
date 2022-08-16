package BoardGame.BackEnd.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "http://54.180.58.142:8080",
                        "http://localhost:8080",
                        "https://localhost:3000",
                        "http://127.0.0.1:3000")
                .allowedMethods("GET")
                .allowedHeaders("*");
    }

}
