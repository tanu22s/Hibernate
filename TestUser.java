package in.co.rays.test;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.text.Bidi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import in.co.rays.association.Address;
import in.co.rays.association.Employee;
import in.co.rays.com.User;
import in.co.rays.inheri.Cash;
import in.co.rays.inheri.Cheque;
import in.co.rays.inheri.CreditCard;
import in.co.rays.mapping.AuctionItem;
import in.co.rays.mapping.bid;

public class TestUser {


	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testDelete();
		// testGet();
		// testLoad();
		// testList();
		// testCount();
		//testCritList();
		// authenticate("surj@gmail.com","1255");
		//testo2m();
		//testo1o();
		TESTTPCH();

	}


	public static void TESTTPCH() {
		
		Cheque cheque = new Cheque();
		cheque.setId(1);
		cheque.setAmount(1500);
		cheque.setChequeno(452110);
		
		CreditCard creditcard = new CreditCard();
		creditcard.setId(1);
		creditcard.setAmount(3000);
		creditcard.setCctype("visa");		
		Cash cash = new Cash();
		
		cash.setId(1);
		cash.setAmount(5000);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		
		s.save(creditcard);
		s.save(cheque);
		s.save(cash);
		s.close();
//		sessionFactory.close();
	}


	public static void testo1o() {
		
		Employee e = new Employee();
		e.setName("Ram");
		Address a = new Address();
		a.setAddress("ujjain");
		e.setAddress(a);
		a.setEmployee(e);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(e);
		tx.commit();
		s.close();
	}


	public static void testo2m() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		
		AuctionItem Item = new AuctionItem();
		Item.setDescription("pen");
		bid Bid1 = new bid();
		Bid1.setAmount(80);
		
		bid Bid2 = new bid();
		Bid2.setAmount(100);
		
		bid Bid3 = new bid();
		Bid3.setAmount(110);
		
		bid Bid4 = new bid();
		Bid4.setAmount(115);
		Set<bid> Set = new HashSet<bid>();
		Set.add(Bid1);
		Set.add(Bid2);
		Set.add(Bid3);
		Set.add(Bid4);
		Item.setBid(Set);
		s.save(Item);
		tx.commit();
		s.close();
		
		
	}


	public static User authenticate(String login, String pwd) throws Exception {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Query q = s.createQuery("from User where username =? and password =?");
		q.setString(0, login);
		q.setString(1, pwd);
		List list = q.list();
		User pojo;
		if (list.size() == 1) {
			
			pojo = (User)list.get(0);
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());
			
			
		} else {
			throw new 
			
			Exception("Login is invalid");
			
		}s.close();
		
		return pojo;
		
		// TODO Auto-generated method stub
		
	}

	public static void testCritList() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Query q = s.createQuery(" Select u.id, u.Fname from User u");
		Criteria crit = s.createCriteria(User.class);
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("id"));
		p.add(Projections.property("Fname"));
		crit.setProjection(p);

		// Query q = s.createQuery(" from User u where Fname like Rohit");
		/*
		 * crit.add(Restrictions.eq("id", 7)); crit.add(Restrictions.like("Fname",
		 * "Rohit")); // it will not run with query***
		 */

		List list = crit.list();
		
		Iterator it = list.iterator();
		Object[]array;
		
		while (it.hasNext()) {
			Object[] arr = (Object[]) it.next();
			
			System.out.println(arr[0]);
			System.out.println(arr[1]);

			/*
			 * System.out.println(u.getPassword()); System.out.println(u.getLname());
			 */
			// System.out.println(u.getFname());
		}

	}

	public static void testCount() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Query q = s.createQuery("Select count(*) from User");
		List rows = q.list();

		Integer row = (Integer) rows.get(0);
		s.close();
	}

	public static void testList() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		/*
		 * Query q = s.createQuery("from User");
		 * 
		 * List l = q.list(); Iterator it = l.iterator(); User pojo;
		 * while(it.hasNext()){
		 * 
		 * pojo = (User) it.next();
		 * 
		 * System.out.println(pojo.getId()); System.out.println(pojo.getFname());
		 */

		Query q = s.createQuery("select u.id, u.Fname from User u ");
		List rows = q.list();
		Iterator iter = rows.iterator();
		Object[] columns;
		System.out.println("id \t fname");

		while (iter.hasNext()) {
			columns = (Object[]) iter.next();
			Integer id = (Integer) columns[0];
			String Fname = (String) columns[1];
			System.out.println(id + "\t" + Fname);

		}
		s.close();
	}

	public static void testLoad() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		User pojo = (User) s.load(User.class, 2);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());
		System.out.println(pojo.getUsername());
		System.out.println(pojo.getPassword());
		s.close();
	}

	public static void testGet() {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		User pojo = (User) s.get(User.class, 5);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());
		System.out.println(pojo.getUsername());
		System.out.println(pojo.getPassword());
		s.close();
	}

	public static void testDelete() {
		// TODO Auto-generated method stub
		User pojo = new User();
		pojo.setId(4);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(pojo);
		tx.commit();
		s.close();
	}

	public static void testupdate() {
		// TODO Auto-generated method stub
		User pojo = new User();
		pojo.setId(1);
		pojo.setFname("Saar");
		pojo.setLname("roy");
		pojo.setUsername("sagarr@gmail.com");
		pojo.setPassword("122345");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.update(pojo);
		tx.commit();
		s.close();
	}

	public static void testadd() {
		// TODO Auto-generated method stub
		User pojo = new User();
		pojo.setFname("kesar");
		pojo.setLname("mishra");
		pojo.setUsername("keat@gmail.com");
		pojo.setPassword("188825");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(pojo);
		tx.commit();
		s.close();

	}
}
