package com.iot.cs.DAO;

import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleDetail;
import java.util.List;
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
 * VehicleDetail model.
 */
@Repository
@Scope( BeanDefinition.SCOPE_SINGLETON )
public class VehicleDetailDAOImpl implements VehicleDetailDAO{

   
    private static String FIND_ALL = "FROM VehicleDetail";
    
    @Autowired
    HibernateUtil hibernateUtil;
    
    SessionFactory factory;

    public VehicleDetailDAOImpl() {
        
        factory = hibernateUtil.getSessionFactory();
    }

    
    @Override
    public void save(VehicleDetail vehicleDetail) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(vehicleDetail);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }

        session.close();

    }
    
    @Override
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
    
    @Override
    public List<VehicleDetail> findAllVehicleDetails() {
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
