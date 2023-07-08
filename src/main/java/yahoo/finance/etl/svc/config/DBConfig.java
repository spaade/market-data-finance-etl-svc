package yahoo.finance.etl.svc.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.net.URL;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories
@EnableConfigurationProperties
public class DBConfig extends AbstractR2dbcConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DBConfig.class);

    @Value("${spring.r2dbc.url}")
    private String dbUrl;
    @Value("${spring.r2dbc.username}")
    private String dbUsername;
    @Value("${spring.r2dbc.password}")
    private String dbPassword;

    @Bean
    @Primary
    public R2dbcProperties r2dbcProperties() {
        log.debug("Init R2dbcProperties");

        var properties = new R2dbcProperties();

        properties.setUrl(dbUrl);
        properties.setUsername(dbUsername);
        properties.setPassword(dbPassword);

        return properties;
    }

    @Override
    public ConnectionFactory connectionFactory() {
        log.debug("Init ConnectionFactory");

        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, "tuffi.db.elephantsql.com")
                .option(PORT, 5432)
                .option(USER, dbUsername)
                .option(PASSWORD, dbPassword)
                .option(DATABASE, dbUsername)
                .build();

        log.debug("ConnectionFactory: {}", options);
        return ConnectionFactories.get(options);
    }
}
