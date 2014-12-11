package hello;

import org.springframework.context.*;
import java.util.List;
import java.util.Iterator;
import org.springframework.context.support.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class MainApp {
private static SessionFactory factory;
private static ServiceRegistry serviceRegistry;
  public static void main(String[] args) {
  
    ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
    Greeter obj = (Greeter) context.getBean("greeter");
    obj.getMessage();
    obj.getMessage2();
    try{
		Configuration configuration = new Configuration();
		System.out.println("Configuration OK");
		configuration.configure();
		System.out.println("Confige OK");

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		System.out.println("serviceregistry OK");

		factory = configuration.buildSessionFactory(serviceRegistry);
		System.out.println("factory OK");


	}catch(Throwable ex){
		System.err.println("Failed to create sessionFactory object" + ex);
		throw new ExceptionInInitializerError(ex);
	}
	MainApp ME = new MainApp();

	Integer empID1 = ME.addEmployee("Zara");
	ME.listEmployees();
	StandardServiceRegistryBuilder.destroy(serviceRegistry);
  }
  public Integer addEmployee(String name){
	  Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			Employee employee = new Employee(name);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}

		return employeeID;
  }
  public void listEmployees(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM hello.Employee").list();
			for(Iterator iterator = employees.iterator(); iterator.hasNext();){
				Employee employee = (Employee) iterator.next();
				System.out.println("Name:"+employee.getName());
			}
			tx.commit();
		}catch(HibernateException e){
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}