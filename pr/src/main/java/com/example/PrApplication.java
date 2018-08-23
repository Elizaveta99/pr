package com.example;

import com.example.configuration.SecurityConfiguration; //???
import com.example.configuration.WebConfiguration; //???

import com.example.model.User;
import com.example.model.UserRole;
import com.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication/*(exclude = { SecurityAutoConfiguration.class })*/
@Import({ SecurityConfiguration.class, WebConfiguration.class })
public class PrApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(PrApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // ???
    @Bean
    CommandLineRunner bootstrap(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        return (args) -> {
            userRepository.save(
                    new User("eliz", passwordEncoder.encode("admin"), UserRole.ROLE_ADMIN)
            );

            userRepository.save(
                    new User("John", passwordEncoder.encode("password"), UserRole.ROLE_USER)
            );

            // userRepository.findAll().stream().map(User::toString).forEach(System.out::println);
        };
    }
}
