package com.iot.cs.DAO;

import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleReading;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanjaybadlani This class is used to implement CRUD operations on
 * Vehicle Reading model.
 */
@Repository
@Scope( BeanDefinition.SCOPE_SINGLETON )
public class VehicleReadingDAO {

    @Autowired
    HibernateUtil hibernateUtil;
    
    SessionFactory factory;

    public VehicleReadingDAO() {
        
        factory = hibernateUtil.getSessionFactory();
    }

    
    public void save(VehicleReading VehicleReading) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(VehicleReading);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }

        session.close();

    }
}
