package bg.softuni.andreys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bg.softuni.andreys.utils.EnumToServiceConverter;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {
}

