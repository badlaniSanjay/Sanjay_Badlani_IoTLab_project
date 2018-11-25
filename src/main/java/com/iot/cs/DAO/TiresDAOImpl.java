
package com.iot.cs.DAO;

import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.Tires;
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
 * @author sanjaybadlani
 */
@Repository
@Scope( BeanDefinition.SCOPE_SINGLETON )
public class TiresDAOImpl implements TiresDAO{
    
    @Autowired
    HibernateUtil hibernateUtil;
    
    SessionFactory factory;

    public TiresDAOImpl() {
        factory = hibernateUtil.getSessionFactory();
    }
    
    
    @Override
    public void save(Tires tires) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(tires);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }

        session.close();
    }
    
}
