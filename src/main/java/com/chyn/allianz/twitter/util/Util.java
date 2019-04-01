package com.chyn.allianz.twitter.util;

import javax.annotation.PostConstruct;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Util implements AutoCloseable {

	@Value("${app.allianz.twitter.neo4j.url}")
	private String neo4jUrl;

	@Value("${app.allianz.twitter.neo4j.username}")
	private String username;

	@Value("${app.allianz.twitter.neo4j.password}")
	private String password;

	private Driver driver;

	@PostConstruct
	public void init() {
		driver = GraphDatabase.driver(neo4jUrl, AuthTokens.basic(username, password));
	}

	public Driver getDriver() {
		return driver;
	}

	@Override
	public void close() throws Exception {
		if (driver != null)
			driver.close();
	}
}
