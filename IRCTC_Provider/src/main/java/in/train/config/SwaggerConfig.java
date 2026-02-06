package in.train.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger / OpenAPI configuration class.
 * 
 * This class configures the OpenAPI documentation for the
 * Train Ticket Booking (IRCTC Provider) microservice.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Custom OpenAPI configuration bean.
     * 
     * @return OpenAPI object with API metadata and server info
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Train Ticket Booking API - IRCTC Provider")
                        .version("1.0.0")
                        .description("Microservices-based RESTful API for train ticket booking system")
                        .contact(new Contact()
                                .name("Suraj Kumar Shah")
                                .email("shahsurajkumar769@gmail.com")
                                .url("https://github.com/Surajshahwal")
                        )
                )
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Development Server")
                ));
    }
}
