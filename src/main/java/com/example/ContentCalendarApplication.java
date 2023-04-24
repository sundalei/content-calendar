package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);

		final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";

		try (Connection conn = DriverManager.getConnection(jdbcURL, "postgres", "password")) {

			if (!conn.isValid(0)) {
				System.out.println("Unable to connect to database");
				System.exit(0);
			}

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Run");
			ResultSet rs = preparedStatement.executeQuery();

			
		} catch (SQLException exception) {

		}
	}

}
