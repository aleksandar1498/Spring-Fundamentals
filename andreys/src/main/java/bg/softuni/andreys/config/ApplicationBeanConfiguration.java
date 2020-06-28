package bg.softuni.andreys.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
