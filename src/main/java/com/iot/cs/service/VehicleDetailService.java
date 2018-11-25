package com.iot.cs.service;

import com.iot.cs.DAO.VehicleDetailDAO;
import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleDetail;
import java.util.List;
import org.hibernate.SessionFactory;
//import com.iot.cs.repo.VehicleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani This is service class used to access the DAO class to
 * process Vehicle Detail Requests
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VehicleDetailService {

    private VehicleDetailDAO vehicleDetailDAO;

    private VehicleDetailService() {

    }

    @Autowired
    public void setVehicleDetailDAO(VehicleDetailDAO vehicleDetailDAO) {
        this.vehicleDetailDAO = vehicleDetailDAO;
    }

    public void save(VehicleDetail vehicleDetail) {
        vehicleDetailDAO.save(vehicleDetail);
    }

    public VehicleDetail findVehicleDetailByVin(String vin) {
        return vehicleDetailDAO.findVehicleDetailByVin(vin);
    }

    public List<VehicleDetail> findAllVehicleDetail() {
        return vehicleDetailDAO.findAllVehicleDetails();
    }

}
