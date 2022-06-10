package com.superluminar.tutorials;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Map;

@Configuration
public class JpaConfig {
    @Bean
    @Profile("aws")
    public DataSource getDataSource() throws IOException {
        var datasourceConfig = datasourceFromJson();

        return DataSourceBuilder.create().
                driverClassName("org.postgresql.Driver").
                url(String.format("jdbc:postgresql://%s:%s/%s",
                        datasourceConfig.get("host"),
                        datasourceConfig.get("port"),
                        datasourceConfig.get("dbname"))).
                username(datasourceConfig.get("username")).
                password(datasourceConfig.get("password")).
                build();
    }

    private Map<String, String> datasourceFromJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = System.getenv("TUTORIALSCLUSTER_SECRET");

        return mapper.readValue(json, new TypeReference<Map<String, String>>() {
        });
    }
}

