package com.moonhotels.MoonhotelsHUB.config;

import com.moonhotels.MoonhotelsHUB.domain.service.AggregationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
 @Bean
 public AggregationService aggregationService() {
     return new AggregationService();
 }
}
