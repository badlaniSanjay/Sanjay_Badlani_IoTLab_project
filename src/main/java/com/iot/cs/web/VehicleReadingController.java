
package com.iot.cs.web;


import com.iot.cs.misc.AlertPriority;
import com.iot.cs.misc.CarSensorConstants;
import com.iot.cs.model.VehicleAlert;
import com.iot.cs.model.VehicleDetail;
import com.iot.cs.model.VehicleReading;
import com.iot.cs.service.VehicleAlertService;
import com.iot.cs.service.VehicleDetailService;
import com.iot.cs.service.VehicleReadingService;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanjaybadlani
 */
@RestController
@RequestMapping(path = "/vehicleReading/")
public class VehicleReadingController {
    
    VehicleReadingService vehicleReadingService;
    VehicleDetailService vehicleDetailService;
    VehicleAlertService vehicleAlertService;

    public VehicleReadingController(VehicleReadingService vehicleReadingService, VehicleDetailService vehicleDetailService, VehicleAlertService vehicleAlertService) {
        this.vehicleReadingService = vehicleReadingService;
        this.vehicleDetailService = vehicleDetailService;
        this.vehicleAlertService = vehicleAlertService;
    }

    
    
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVehicleDetail( @RequestBody VehicleReading vehicleReading) {
        
        checkIfAnyAlertNeedsToBeGenerated(vehicleReading);
        vehicleReadingService.save(vehicleReading);      
        
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/getAllHighAlerts")
    public List<VehicleAlert> getAllHighAlerts() {
        Timestamp twoHoursBack = new Timestamp(System.currentTimeMillis() - 7200000);
        return vehicleAlertService.findAlertsWithTimeGreaterAndPriority(twoHoursBack, AlertPriority.HIGH);
        
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/getAllAlerts/{vin}")
    public List<VehicleAlert> getAllAlertsForVehicle(@PathVariable(value = "vin") String vin) {
        
        return vehicleAlertService.findVehicleAlertByVin(vin);
        
    }
    
    

    private void checkIfAnyAlertNeedsToBeGenerated(VehicleReading vehicleReading) {
        VehicleDetail currentVehicleDetail = vehicleDetailService.findVehicleDetailByVin(vehicleReading.getVin());
        if(vehicleReading.getEngineRpm() > currentVehicleDetail.getredlineRpm()){
            createAlert(vehicleReading.getVin(), CarSensorConstants.ALERT_MESSAGE_ENGINE_RPM, AlertPriority.HIGH);
        }
        
        if(currentVehicleDetail.getMaxFuelVolume()  > vehicleReading.getFuelVolume() * 10){
            createAlert(vehicleReading.getVin(), CarSensorConstants.ALERT_MESSAGE_FUEL_VOLUME, AlertPriority.MEDIUM);
    }
    }

    private void createAlert(String vin, String alertMessage, AlertPriority alertPriority) {
        VehicleAlert alert = new VehicleAlert(vin, alertMessage
                , alertPriority
                , new Timestamp(System.currentTimeMillis()));
        vehicleAlertService.save(alert);
    }
    
    
}
