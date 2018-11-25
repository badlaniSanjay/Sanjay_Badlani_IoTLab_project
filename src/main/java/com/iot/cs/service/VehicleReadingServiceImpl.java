package com.iot.cs.service;

import com.iot.cs.DAO.VehicleReadingDAO;
import com.iot.cs.DAO.VehicleReadingDAOImpl;
import com.iot.cs.model.VehicleReading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani This is service class used to access the DAO class to
 * process Vehicle Reading Requests
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VehicleReadingServiceImpl implements VehicleReadingService{

    private VehicleReadingDAO VehicleReadingDAO;

    public VehicleReadingServiceImpl() {

    }

    @Autowired
    public void setVehicleReadingDAO(VehicleReadingDAO VehicleReadingDAO) {
        this.VehicleReadingDAO = VehicleReadingDAO;
    }
    
    @Override
    public void save(VehicleReading VehicleReading) {
        VehicleReadingDAO.save(VehicleReading);
    }

}
