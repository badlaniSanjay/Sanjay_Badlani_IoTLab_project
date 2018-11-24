package com.iot.cs.DAO;

import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleDetail;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author sanjaybadlani
 */
public class VehicleDetailDAO {

    private static VehicleDetailDAO instance = null;
    private static String FIND_ALL = "FROM VehicleDetail";
    HibernateUtil hibernateUtil;
    SessionFactory factory;

    private VehicleDetailDAO() {
        hibernateUtil = new HibernateUtil();
        factory = hibernateUtil.getSessionFactory();
    }

    public static VehicleDetailDAO instance() {
        if (instance == null) {
            instance = new VehicleDetailDAO();
        }
        return instance;
    }

    public void save(VehicleDetail vehicleDetail) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(vehicleDetail);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }

        session.close();

    }

    public VehicleDetail findVehicleDetailByVin(String vin) {
        VehicleDetail temp;
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        temp = (VehicleDetail) session.get(VehicleDetail.class, vin);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        session.close();

        return temp;
    }
    
    public List<VehicleDetail> findAllVehicleDetails(){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List temp = session.createQuery(FIND_ALL).list();
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        session.close();
        return temp;
    }

}
