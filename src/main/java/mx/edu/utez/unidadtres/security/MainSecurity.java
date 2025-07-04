package mx.edu.utez.unidadtres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class MainSecurity {
    //ROLES: ADMIN, EMPLOYEE, CUSTOMER, ETC.
    //roles en otros archivos: ROLE_ADMIN, ROLE_EMPLOYEE, ROLE_CUSTOMER
    @Bean
    public SecurityFilterChain doFilterInternal(HttpSecurity http) throws Exception{
        http.csrf(c -> c.disable())
            .cors(c -> c.configurationSource(corsRegistry()))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/client/**").hasRole("ADMIN")
                    .requestMatchers("/api/cede/**").hasRole("EMPLOYEE")
                    .requestMatchers("/swagger-ui.html",
                                     "/swagger-ui/**",
                                     "/v3/api-docs/**",
                                     "/v3/api-docs.yaml",
                                     "/swagger-resources/**",
                                     "/webjars/**")
            .hasRole("DEV").anyRequest().authenticated()).httpBasic(Customizer.withDefaults());

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

    @Bean
    public UserDetailsService generateUsers(){
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456789"))
                .roles("ADMIN").build();

        UserDetails employee = User.builder()
                .username("employee")
                .password(passwordEncoder().encode("123456789"))
                .roles("ADMIN").build();

        UserDetails swaggerAdmin = User.builder()
                .username("swaggerAdmin")
                .password(passwordEncoder().encode("123456789"))
                .roles("DEV").build();

        return new InMemoryUserDetailsManager(admin,employee,swaggerAdmin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
