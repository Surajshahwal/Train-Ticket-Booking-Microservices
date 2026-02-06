package in.train.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient.
 * 
 * This class is used in the Consumer service to configure and provide
 * a WebClient.Builder bean, which is used to make HTTP calls to the Provider service.
 */
@Configuration
public class WebClientConfig {

	/**
	 * Creates and exposes a WebClient.Builder bean.
	 * 
	 * This builder can be injected anywhere in the application
	 * to build WebClient instances for calling external REST APIs.
	 * 
	 * @return WebClient.Builder instance
	 */
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}
}
