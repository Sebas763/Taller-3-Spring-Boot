package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // Configuración de CORS
        CorsConfiguration config = new CorsConfiguration();

        // Permitir orígenes específicos
        config.setAllowedOrigins(List.of("http://localhost:5173", "http://localhost:3000"));

        // Permitir métodos HTTP específicos
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

        // Permitir cualquier encabezado
        config.setAllowedHeaders(List.of("*"));

        // Permitir envío de credenciales (cookies, headers de autenticación, etc.)
        config.setAllowCredentials(true);

        // Fuente de configuración basada en URL para aplicar la configuración a todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Registrar la configuración para todas las rutas ("**")
        source.registerCorsConfiguration("/**", config);

        // Retorna un filtro CORS con la configuración establecida
        return new CorsFilter(source);
    }
}
