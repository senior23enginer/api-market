package com.apimarket.market.adapters.configuration;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class DataSourceConfig {

    @Value("${database.host}")
    private String dbHost;

    @Value("${database.port}")
    private String dbPort;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPassword;

    @Value("${database.name}")
    private String dbName;

    @Value("${database.schema}")
    private String schema;

    @Value("${database.ssl}")
    private Boolean dbSSL;

    @Value("${database.server-ca}")
    private String serverCA;

    @Value("${database.client-cert}")
    private String clientCERT;

    @Value("${database.client-key}")
    private String clientKEY;

    private final String FILE_SERVER_CA = "/tmp/server-ca.pem";

    private final String FILE_CLIENT_CERT = "/tmp/client-cert.pem";

    private final String FILE_CLIENT_KEY = "/tmp/client-key.pk8";

    @Bean
    public HikariDataSource getDataSource () throws IOException {

        if(dbSSL) loadCertificate();
        String jdbcUrl = dbSSL ? getJdbcUrlSSL() : getJdbcUrl();
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.addDataSourceProperty("url", jdbcUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);
    }

    private String getJdbcUrl() {
        String MASK_JDBC_URL = "jdbc:postgresql://%s:%s/%s?currentSchema=%s";
        return String.format(MASK_JDBC_URL, dbHost, dbPort, dbName, schema);
    }

    private String getJdbcUrlSSL() {
        String MASK_JDBC_URL = "jdbc:postgresql://%s:%s/%s?currentSchema=%s&sslmode=require&sslrootcert=%s&sslcert=%s&sslkey=%s";
        return String.format(MASK_JDBC_URL, dbHost, dbPort, dbName, schema, FILE_SERVER_CA, FILE_CLIENT_CERT, FILE_CLIENT_KEY);
    }

    private void loadCertificate() throws IOException {
        FileUtils.writeStringToFile(new File(FILE_SERVER_CA), serverCA, StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File(FILE_CLIENT_CERT), clientCERT, StandardCharsets.UTF_8);
        FileUtils.writeByteArrayToFile(new File(FILE_CLIENT_KEY), Base64.getDecoder().decode(clientKEY));
    }
}
