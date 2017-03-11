package org.egen.clearsky.api;

import org.egen.clearsky.api.config.SwaggerConfig;
import org.egen.clearsky.api.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Import({SwaggerConfig.class, WebConfig.class})
@EnableMongoRepositories
public class Application 
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
