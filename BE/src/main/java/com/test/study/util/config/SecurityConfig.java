package com.test.study.util.config;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    /* 혜지 : 예외 핸들링 필요 */
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic((basic) -> basic.disable())
//                .csrf((csrf)->csrf.disable())
//                .sessionManagement((sessionManagement)->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(
//                        (authorizeRequests)->authorizeRequests
//                        .requestMatchers("/all").permitAll()
//                        .requestMatchers("/main").permitAll()
//
//                        .anyRequest().authenticated()
//                );
//
//            return http.build();
//    }
}
