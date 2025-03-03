package pt.aeropixel.challengeOpenApi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI myOpenApi() {
        return new OpenAPI()
                .info(new Info().title("My API for Contacts")
                        .description("My very own Contacts API open documentation")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("My ContactsAPI Wiki Documentation blablabla")
                        .url("https://localhost/someshithere"));
    }
}
