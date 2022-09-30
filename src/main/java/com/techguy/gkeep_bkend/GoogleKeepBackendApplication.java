package com.techguy.gkeep_bkend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Google Keep clone API",
		contact = @Contact(name = "devteam-Gkeep",email = "developer@gkeep.com"),
		description = "App to serve for the Gkeep application request",
		version = "1.0",termsOfService = "Not for commercial or personal use. Privately owned")
)
public class GoogleKeepBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleKeepBackendApplication.class, args);
	}

}
