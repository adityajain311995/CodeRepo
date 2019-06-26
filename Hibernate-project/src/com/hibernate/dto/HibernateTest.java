package com.hibernate.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	public static void main(String[] args) {
//		Employee employee = new Employee();
//		employee.setName("Aditya Jain");
//		Address address1 = new Address("Nandi Sunrise", "Bangalore", "Karnataka", "560037");
//		Address address2 = new Address("Alpine Eco road", "Bangalore", "Karnataka", "560036");
//		employee.getAddresses().add(address1);
//		employee.getAddresses().add(address2);
		
		Customer customer = new Customer();
		customer.setName("Batman");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("BatMobile");
		vehicle.setCustomer(customer);
		
		customer.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		
		Employee empFetch = null;
		Session sessionNew = sessionFactory.openSession();
		sessionNew.beginTransaction();
		empFetch = sessionNew.get(Employee.class, 1);
		
		
		sessionNew.close();
		
		
		System.out.println(empFetch);
	}
}
