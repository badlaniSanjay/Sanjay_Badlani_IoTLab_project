package com.iot.cs.service;

//import com.iot.cs.repo.VehicleAlertRepository;
import com.iot.cs.DAO.VehicleAlertDAO;
import com.iot.cs.misc.AlertPriority;
import com.iot.cs.model.VehicleAlert;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani This is service class used to access the DAO class to
 * process Vehicle Alert Requests
 */
@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class VehicleAlertService {

    private VehicleAlertDAO vehicleAlertDAO;

    private VehicleAlertService() {

    }

    @Autowired
    public void setVehicleAlertDAO(VehicleAlertDAO vehicleAlertDAO) {
        this.vehicleAlertDAO = vehicleAlertDAO;
    }

    public void save(VehicleAlert VehicleAlert) {
        vehicleAlertDAO.save(VehicleAlert);
    }

    public List<VehicleAlert> findVehicleAlertByVin(String vin) {
        return vehicleAlertDAO.findVehicleAlertsByVin(vin);
    }

    public List<VehicleAlert> findAlertsWithTimeGreaterAndPriority(Timestamp twoHoursBack, AlertPriority alertPriority) {
        return vehicleAlertDAO.findAlertsWithTimeGreaterAndPriority(twoHoursBack, alertPriority);
    }

}
