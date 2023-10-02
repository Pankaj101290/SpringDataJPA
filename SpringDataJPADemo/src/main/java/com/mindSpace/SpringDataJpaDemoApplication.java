package com.mindSpace;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaDemoApplication.class, args);

		StudentDemo sd1 = new StudentDemo(8, "Raj", "Solapur");
		Demoservice bean1 = context.getBean(Demoservice.class);
		// System.out.println(bean1.insertStudent(sd1));

		// System.out.println(bean1.getStudent(sd1));

		// System.out.println(bean1.getStudent1(8));

		// System.out.println(bean1.updateStudent(sd1));

		// System.out.println(bean1.deleteStuudentById(8));

		// System.out.println(bean1.deleteStuudentEntity(7));

		// System.out.println(bean1.readAllStudent());

		// System.out.println(bean1.deleteAllStudents());

		Set<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(7);

		System.out.println(bean1.findManyStudents(set));
	}

}
