package com.github.diegopacheco.sandbox.java.testcontainers.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import com.github.diegopacheco.sandbox.java.testcontainers.AppConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@SuppressWarnings({"rawtypes","unchecked"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestMysql {

	private static final Logger logger = LoggerFactory.getLogger(TestMysql.class);

	@Rule
	public MySQLContainer mysql = (MySQLContainer) new MySQLContainer("mysql:5.6").withLogConsumer(new Slf4jLogConsumer(logger));

	@Test
	public void testSimple() throws SQLException {
		mysql.start();
		try {
			ResultSet resultSet = performQuery(mysql, "SELECT 1");
			int resultSetInt = resultSet.getInt(1);
			Assert.assertEquals("A basic SELECT query succeeds", 1, resultSetInt);
		} finally {
			mysql.stop();
		}
	}
	
    protected ResultSet performQuery(MySQLContainer containerRule, String sql) throws SQLException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(containerRule.getJdbcUrl());
        hikariConfig.setUsername(containerRule.getUsername());
        hikariConfig.setPassword(containerRule.getPassword());

        HikariDataSource ds = new HikariDataSource(hikariConfig);
        Statement statement = ds.getConnection().createStatement();
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();

        resultSet.next();
        ResultSet rs = resultSet;
        ds.close();
        return rs;
    }

}
