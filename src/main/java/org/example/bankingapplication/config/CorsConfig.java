package org.example.bankingapplication.config;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


    @Configuration
    public class CorsConfig {

        @Bean
        public WebMvcConfigurer corsConfigurer() {

            return new WebMvcConfigurer() {

                @Override
                public void addCorsMappings(@NonNull CorsRegistry registry) {

                    registry.addMapping("/**")
                            .allowedOrigins(
                                    "http://localhost:3000",
                                    "https://secure-bank-a1zahjfw8-saiprahlads-projects.vercel.app",
                                    "https://secure-bank-8u26g2a7y-saiprahlads-projects.vercel.app",
                                    "https://secure-bank-git-main-saiprahlads-projects.vercel.app")
                                    .allowedMethods(
                                    "GET",
                                    "POST",
                                    "PUT",
                                    "PATCH",
                                    "DELETE",
                                    "OPTIONS"
                            )
                            .allowedHeaders("*");
                }
            };
        }
    }

