package hello;

import org.springframework.context.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.context.support.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import hello.Ingredient;
public class MainApp {
private static SessionFactory factory;
private static ServiceRegistry serviceRegistry;
  public static void main(String[] args) {
  
    ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

    try{
		Configuration configuration = new Configuration();

		configuration.configure();

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		factory = configuration.buildSessionFactory(serviceRegistry);



	}catch(Throwable ex){
		System.err.println("Failed to create sessionFactory object" + ex);
		throw new ExceptionInInitializerError(ex);
	}
	MainApp ME = new MainApp();

	ME.addRecipe();
	StandardServiceRegistryBuilder.destroy(serviceRegistry);
  }
  public void addRecipe(){
	  Ingredient in = new Ingredient("chocolat", 1);
	  Aile ai = Aile.BOISSON;
	  in.setAile(ai);
	  List<Ingredient> lol = new ArrayList<Ingredient>();
	  Recette rec = new Recette("Blue");


	  rec.addIngredient(in);
	  
	  Session session = factory.openSession();
	  Transaction tx = null;
	  Integer recID = null;
	  try{
		  tx = session.beginTransaction();
		  recID = (Integer) session.save(rec);
		  tx.commit();
	  }catch(HibernateException e){
		  if(tx != null) tx.rollback();
		  e.printStackTrace();
	  }finally{
		  session.close();
	  }
  }
  
}