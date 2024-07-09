package com.techrevamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Le decimos a Spring Boot que vamos a utilizar una configuración personalizada
@Configuration
public class CorsConfig {
  // Los beans son instancias de clases gestionadas por el contenedor de Spring.
  @Bean
  // WebMvcConfigurer es una interfaz en Spring Framework que proporciona métodos de configuración para personalizar el comportamiento de Spring MVC
  // Permite configurar diversas características del sistema de manejo de peticiones HTTP y las vistas en una aplicación web basada en Spring.
  public WebMvcConfigurer corsConfigurer(){
    return new WebMvcConfigurer() {
      // CorsRegistry -> método se usa para agregar configuraciones de CORS.
      public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins("http://localhost:4000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
      }
    };
  }
}
