package in.co.rays.inheri;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestInheritance {
	public static void main(String[] args) {
		Cheque cheque = new Cheque();
		
		cheque.setAmount(1500);
		cheque.setChequeno(452110);
		
		CreditCard creditcard = new CreditCard();
		
		creditcard.setAmount(3000);
		creditcard.setCctype("visa");		
		Cash cash = new Cash();
		
		
		cash.setAmount(5000);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Transaction tx= s.beginTransaction();
		
		s.save(creditcard);
		s.save(cheque);
		s.save(cash);
		tx.commit();
		s.close();
//		sessionFactory.close();
	}

	}

