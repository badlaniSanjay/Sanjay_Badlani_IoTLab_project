package com.iot.cs.service;

import com.iot.cs.DAO.VehicleDetailDAO;
import com.iot.cs.misc.HibernateUtil;
import com.iot.cs.model.VehicleDetail;
import java.util.List;
import org.hibernate.SessionFactory;
//import com.iot.cs.repo.VehicleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani This is service class used to access the DAO class to
 * process Vehicle Detail Requests
 */
@Service
public class VehicleDetailService {

    private static VehicleDetailService instance = null;

    private VehicleDetailDAO vehicleDetailDAO;

    private VehicleDetailService() {
        vehicleDetailDAO = VehicleDetailDAO.instance();
    }

    public static VehicleDetailService instance() {
        if (instance == null) {
            instance = new VehicleDetailService();
        }
        return instance;
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
