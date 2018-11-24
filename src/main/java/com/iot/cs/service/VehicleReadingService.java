
package com.iot.cs.service;


import com.iot.cs.DAO.VehicleReadingDAO;
import com.iot.cs.model.VehicleReading;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanjaybadlani
 */
@Service
public class VehicleReadingService {
private static VehicleReadingService instance = null;
    
    private VehicleReadingDAO VehicleReadingDAO;
    
    private VehicleReadingService (){
        VehicleReadingDAO = VehicleReadingDAO.instance();
    }
    
    public static VehicleReadingService instance(){
        if(instance == null ){
            instance = new VehicleReadingService();
        }
        return instance ;
    }
    
    public void save(VehicleReading VehicleReading){
        VehicleReadingDAO.save(VehicleReading);
    }
    
    
}
