package lektion1;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.h2.tools.Server;
import org.junit.jupiter.api.Test;

class HibernateTest {

	@Test
	void testHibernate() throws SQLException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("testdb");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		Person person = new Person();
		person.setNachname("Trutz");
		entityManager.persist(person);

		transaction.commit();

		Server webServer = Server.createWebServer();
		webServer.start();
		webServer.shutdown();
	}

}
