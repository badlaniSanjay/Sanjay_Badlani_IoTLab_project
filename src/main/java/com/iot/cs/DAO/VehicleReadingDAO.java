
package com.iot.cs.DAO;

import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleReading;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author sanjaybadlani
 */
public class VehicleReadingDAO {
      private static VehicleReadingDAO instance = null;
    HibernateUtil hibernateUtil;
    SessionFactory factory;

    private VehicleReadingDAO() {
        hibernateUtil = new HibernateUtil();
        factory = hibernateUtil.getSessionFactory();
    }

    public static VehicleReadingDAO instance() {
        if (instance == null) {
            instance = new VehicleReadingDAO();
        }
        return instance;
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
