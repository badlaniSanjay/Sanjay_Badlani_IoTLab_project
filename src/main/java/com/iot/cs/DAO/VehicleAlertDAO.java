package com.iot.cs.DAO;

import com.iot.cs.misc.AlertPriority;
import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleAlert;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanjaybadlani This class is used to do CRUD operations on
 * VehicleAlert Model
 */
@Repository
@Scope( BeanDefinition.SCOPE_SINGLETON )
public class VehicleAlertDAO {

   
    private static String GET_ALERTS_BY_VIN = "FROM VehicleAlert WHERE vin = :vin";
    private static String GET_ALERTS_BY_TIMESTAMP_AND_PRIORITY = "FROM VehicleAlert va where va.currentTimestampTs > "
            + " :givenTimestamp AND va.alertPriority = :givenPriority";
    
    @Autowired
    HibernateUtil hibernateUtil;
    
    SessionFactory factory;

    public VehicleAlertDAO() {
        
        factory = hibernateUtil.getSessionFactory();
    }



    public void save(VehicleAlert vehicleAlert) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(vehicleAlert);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }

        session.close();

    }

    public List<VehicleAlert> findVehicleAlertsByVin(String vin) {
        ArrayList<VehicleAlert> vehicleAlertList = new ArrayList<>();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(GET_ALERTS_BY_VIN);
        query.setParameter("vin", vin);
        List temp = query.list();
        vehicleAlertList.addAll(temp);
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        session.close();

        return vehicleAlertList;
    }

    public List<VehicleAlert> findAlertsWithTimeGreaterAndPriority(Timestamp twoHoursBack, AlertPriority alertPriority) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(GET_ALERTS_BY_TIMESTAMP_AND_PRIORITY);
        query.setParameter("givenTimestamp", twoHoursBack);
        query.setParameter("givenPriority", alertPriority);
        List results = query.list();
        if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
            tx.commit();
        }
        session.close();
        return results;
    }
}
