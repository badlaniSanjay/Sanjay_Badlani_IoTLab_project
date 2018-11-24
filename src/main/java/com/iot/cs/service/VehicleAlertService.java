
package com.iot.cs.service;

//import com.iot.cs.repo.VehicleAlertRepository;
import com.iot.cs.DAO.VehicleAlertDAO;
import com.iot.cs.misc.AlertPriority;
import com.iot.cs.model.VehicleAlert;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani
 */
@Service
public class VehicleAlertService {
private static VehicleAlertService instance = null;
    
    private VehicleAlertDAO vehicleAlertDAO;
    
    private VehicleAlertService (){
        vehicleAlertDAO = VehicleAlertDAO.instance();
    }
    
    public static VehicleAlertService instance(){
        if(instance == null ){
            instance = new VehicleAlertService();
        }
        return instance ;
    }
    
    public void save(VehicleAlert VehicleAlert){
        vehicleAlertDAO.save(VehicleAlert);
    }
    
    public List<VehicleAlert> findVehicleAlertByVin (String vin){
        return vehicleAlertDAO.findVehicleAlertsByVin(vin);
    }

    public List<VehicleAlert> findAlertsWithTimeGreaterAndPriority(Timestamp twoHoursBack, AlertPriority alertPriority) {
        return vehicleAlertDAO.findAlertsWithTimeGreaterAndPriority(twoHoursBack, alertPriority);
    }

   
    

   
    
}
