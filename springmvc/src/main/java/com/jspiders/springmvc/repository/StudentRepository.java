package com.jspiders.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc.pojo.StudentPojo;

@Repository
public class StudentRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	static Query query;
	String jpql;

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("student");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void closeConnection() {
		if (factory != null) {
			factory.close();
		}

		if (manager != null) {
			manager.close();
		}

		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public StudentPojo add(String name, String email, long contact, String city, String username, String password) {
		openConnection();
		transaction.begin();
		StudentPojo pojo = new StudentPojo();
		pojo.setName(name);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setCity(city);
		pojo.setUserName(username);
		pojo.setPassword(password);
		manager.persist(pojo);
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public StudentPojo login(String username, String password) {
		openConnection();
		transaction.begin();
		jpql = "from StudentPojo where username = '" + username + "' and password = '" + password + "'";
		query = manager.createQuery(jpql);
		List<StudentPojo> resultList = query.getResultList();
		for (StudentPojo student : resultList) {
			if (student != null) {
				transaction.commit();
				closeConnection();
				return student;
			}
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public StudentPojo search(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
		if (student != null) {
			transaction.commit();
			closeConnection();
			return student;
		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public StudentPojo remove(int id) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
		if (student != null) {
			manager.remove(student);
		}
		transaction.commit();
		closeConnection();
		return student;
	}

	public List<StudentPojo> searchAll() {
		openConnection();
		transaction.begin();
		String jpql = "from StudentPojo";
		query = manager.createQuery(jpql);
		List<StudentPojo> students = query.getResultList();
		transaction.commit();
		closeConnection();
		return students;
	}

	public StudentPojo update(int id, String name, String email, long contact, String city, String username,
			String password) {
		openConnection();
		transaction.begin();
		StudentPojo student = manager.find(StudentPojo.class, id);
			if (student != null) {
				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setContact(contact);
				student.setCity(city);
				student.setUserName(username);
				student.setPassword(password);
				
				transaction.commit();
				closeConnection();
				return student;
			}
			transaction.commit();
			closeConnection();
			return null;
	}

}
