package com.zero.bill.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import javax.sql.DataSource;

/**
 * @author Zengzhx
 * @date 2020/4/4 3:19 PM
 */
@Configuration
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.druid.initialSize}")
    private int initialSize;
    @Value("${spring.druid.minIdle}")
    private int minIdle;
    @Value("${spring.druid.maxActive}")
    private int maxActive;
    @Value("${spring.druid.maxWait}")
    private long maxWait;
    @Value("${spring.druid.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.druid.minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.druid.validationQuery}")
    private String validationQuery;
    @Value("${spring.druid.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.druid.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.druid.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.druid.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;



    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);

        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public NamedParameterJdbcTemplate jdbcTemplate(@Qualifier(value = "druidDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
