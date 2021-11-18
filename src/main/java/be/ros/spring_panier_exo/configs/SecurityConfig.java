// package be.ros.spring_panier_exo.configs;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;

// import be.ros.spring_panier_exo.configs.jwt.JwtAuthFilter;
// import be.ros.spring_panier_exo.configs.jwt.JwtTokenProvider;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     private final JwtTokenProvider tokenProvider;

//     public SecurityConfig(JwtTokenProvider provider) {
//         this.tokenProvider = provider;
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {

//         http.cors().and().csrf().disable().authorizeRequests().antMatchers("/h2-console/**").permitAll()
//                 .antMatchers("/users/**").permitAll().antMatchers(HttpMethod.POST, "/users/**").permitAll().anyRequest()
//                 .authenticated().and().httpBasic();

//         http.addFilterBefore(new JwtAuthFilter(this.tokenProvider), UsernamePasswordAuthenticationFilter.class);
//         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         http.headers().frameOptions().disable();

//     }

//     @Bean
//     public CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration corsConfiguration = new CorsConfiguration();

//         corsConfiguration.addAllowedOrigin("http://localhost:4200/");
//         corsConfiguration.addAllowedMethod("*");
//         corsConfiguration.addAllowedHeader("*");
//         corsConfiguration.addExposedHeader("Authorization");
//         corsConfiguration.setAllowCredentials(true);

//         // LAMBDA Expressions
//         return request -> corsConfiguration;
//     }

//     // @Bean
//     // @Override
//     // protected AuthenticationManager authenticationManager() throws Exception
//     // {
//     // return super.authenticationManager();
//     // }

// }
