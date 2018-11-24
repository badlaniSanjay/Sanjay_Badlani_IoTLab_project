
package com.iot.cs.DAO;

import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.TestClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sanjaybadlani
 */
public class TestClassDAO {
    HibernateUtil hibernateUtil  = new HibernateUtil();
    SessionFactory factory = hibernateUtil.getSessionFactory();
    
    
    public void save (TestClass testClass){
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        //session.save(testClass);
        session.saveOrUpdate(testClass);
         t.commit();  
        //session.close();
    }
}
