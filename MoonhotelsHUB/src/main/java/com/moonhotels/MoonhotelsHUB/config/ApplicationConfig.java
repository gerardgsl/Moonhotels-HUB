package com.moonhotels.MoonhotelsHUB.config;

import com.moonhotels.MoonhotelsHUB.domain.service.AggregationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {
	
 @Bean
 public AggregationService aggregationService() {
     return new AggregationService();
 }
}
