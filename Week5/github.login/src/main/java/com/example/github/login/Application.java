package com.example.github.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
@RestController
public class Application {

	@GetMapping("/user")
	public OAuth2User user(@AuthenticationPrincipal OAuth2User principal) {
		System.out.println(principal.toString());
		System.out.println(Optional.ofNullable(principal.getAttribute("Name")));
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
