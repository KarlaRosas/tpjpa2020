package jpa;
import domain.Department;
import domain.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();*/
		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);


		EntityTransaction tx = manager.getTransaction();


		tx.begin();
		try {
			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listEmployees();

		manager.close();
		System.out.println(".. done");
		EntityManagerHelper.closeEntityManagerFactory();
	}

	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			Department department = new Department("dep1");
			Department department2 = new Department("dep2");
			manager.persist(department);
			manager.persist(department2);

			manager.persist(new Employee("Jakab Gipsz",department));
			manager.persist(new Employee("Captain Nemo",department));
			manager.persist(new Employee("Bon Toronja",department2));
			manager.persist(new Employee("Bebecito bebeLean",department2));

		}
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
}


