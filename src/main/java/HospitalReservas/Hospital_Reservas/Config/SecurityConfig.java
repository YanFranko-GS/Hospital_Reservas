package HospitalReservas.Hospital_Reservas.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, 
                         JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth

        /* 
        ////////////
            .requestMatchers("/", "/index.html", "/login.html", "/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
            .requestMatchers("/register.html").permitAll()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/paciente.html").hasRole("PACIENTE")
            .requestMatchers("/admin.html").hasRole("ADMIN")
        */
        ///////////
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/v1/citas/mis-citas").hasRole("PACIENTE")
            .requestMatchers(HttpMethod.POST, "/api/v1/citas").hasRole("PACIENTE")
            .requestMatchers(HttpMethod.GET, "/api/v1/horarios").hasRole("PACIENTE")
            .requestMatchers(HttpMethod.GET, "/api/v1/medicos").hasRole("PACIENTE")
            .requestMatchers(HttpMethod.GET, "/api/v1/notificaciones").hasRole("PACIENTE")
            .requestMatchers("/api/v1/citas/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/historiales/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/pacientes/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/pagos/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/servicios/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/medicos/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/horarios/**").hasRole("ADMIN")
            .requestMatchers("/api/v1/notificaciones/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        );

    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) 
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}