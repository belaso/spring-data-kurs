package lektion1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.Server;
import org.junit.jupiter.api.Test;

public class H2DatabaseTest {

	@Test
	public void testStartDatabaseInMemory() throws SQLException, IOException {

		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setUrl("jdbc:h2:mem:testdb");
		dataSource.setUser("sa");
		dataSource.setPassword("");

		Connection connection = dataSource.getConnection();
		connection.createStatement().execute("create table person(nachname varchar(100))");
		connection.createStatement().executeUpdate("insert into person(nachname) values('Trutz')");
		Server.startWebServer(connection);
		connection.close();

	}

}
