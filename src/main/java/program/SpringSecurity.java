package program;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //nie je prihlasený
                .antMatchers("/lostpassword").anonymous()
                .antMatchers("/register").anonymous()
                .antMatchers("/login").anonymous()

                //prihlaseny
                .antMatchers("/profile").fullyAuthenticated()
                .antMatchers("/profile/edit").fullyAuthenticated()

                //admin
                .antMatchers("/users").hasAuthority("Admin")
                .antMatchers("/user/**").hasAuthority("Admin")
                .antMatchers("/article/add").hasRole("Admin")
                .antMatchers("/article/edit").hasRole("Admin")

                .and()
                //kde je login stranka a kam presmerovat po prihlaseni
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/profile?login_succes")
                                .permitAll())
                //kde je logout stranka
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .clearAuthentication(true)
                                .permitAll()
                )
                .rememberMe().tokenValiditySeconds(7200)
                .and()
                .sessionManagement().maximumSessions(1).expiredUrl("/login?expired");
        return http.build();
    }
}
