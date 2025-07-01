package mx.edu.utez.unidadtres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class MainSecurity {
    @Bean
    public SecurityFilterChain doFilterInternal(HttpSecurity http) throws Exception{
        http.csrf(c -> c.disable())
            .cors(c -> c.configurationSource(corsRegistry()))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/client/").permitAll()
                    .requestMatchers("/api/cede/").permitAll()
                    .requestMatchers("/swagger-ui.html",
                                     "/swagger-ui/**",
                                     "/v3/api-docs/**",
                                     "/v3/api-docs.yaml",
                                     "/swagger-resources/**",
                                     "/webjars/**")
            .permitAll().anyRequest().authenticated());

        return http.build();
    }

    private CorsConfigurationSource corsRegistry(){
        //que queremos configurar
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("POST", "PUT","PATCH","DELETE","GET","OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false);//cookies

        //en donde lo debemos aplicar
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }
}
