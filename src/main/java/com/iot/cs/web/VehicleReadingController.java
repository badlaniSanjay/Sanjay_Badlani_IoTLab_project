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
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanjaybadlani This Rest Controller is used to process the Vehicle
 * Reading and Vehicle Alert request received from the client.
 */
@RestController
@RequestMapping(path = "/vehicleReading/")
public class VehicleReadingController {
    
    private static Logger log = Logger.getLogger(VehicleReadingController.class.getName());
    
    private VehicleReadingService vehicleReadingService;
    private VehicleDetailService vehicleDetailService;
    private VehicleAlertService vehicleAlertService;
    
    public VehicleReadingController(VehicleReadingService vehicleReadingService, VehicleDetailService vehicleDetailService, VehicleAlertService vehicleAlertService) {
        this.vehicleReadingService = vehicleReadingService;
        this.vehicleDetailService = vehicleDetailService;
        this.vehicleAlertService = vehicleAlertService;
    }

    // This method is used to save the VehicleReading in the Databsse
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVehicleReading(@RequestBody VehicleReading vehicleReading) {
        try {
            log.info("Processing the " + vehicleReading.toString() + " to check if any alert needs to be generated ");
            checkIfAnyAlertNeedsToBeGenerated(vehicleReading);
            log.info("Saving the " + vehicleReading.toString() + " to the database");
            vehicleReadingService.save(vehicleReading);            
        } catch (Exception ex) {
            log.severe("Exception while processing the create Vehicle Reading request " + ex);
        }
        
    }

    //This method is used to get All High alerts in last two Hours
    @RequestMapping(method = RequestMethod.GET, path = "/getAllHighAlerts")
    public List<VehicleAlert> getAllHighAlertsInLastTwoHours() {
        try {
            
            Timestamp twoHoursBack = new Timestamp(System.currentTimeMillis() - 7200000);
            log.info("Time two hours ago was " + twoHoursBack);
            log.info("Fetching all High Alerts since" + twoHoursBack);
            return vehicleAlertService.findAlertsWithTimeGreaterAndPriority(twoHoursBack, AlertPriority.HIGH);
        } catch (Exception ex) {
            log.severe("Exception occured while fetching all high alerts " + ex);
        }
        return null;
    }

    //This method returns all the alerts for a veicle based on the vin or vehicle id
    @RequestMapping(method = RequestMethod.GET, path = "/getAllAlerts/{vin}")
    public List<VehicleAlert> getAllAlertsForVehicle(@PathVariable(value = "vin") String vin) {
        try {
            log.info("Fetching alerts for vehicle " + vin);
            return vehicleAlertService.findVehicleAlertByVin(vin);
        } catch (Exception ex) {
            log.severe("Exception while Fetching alerts for vehicle with vin " + vin);
        }
        return null;
    }

    //This method checks if any alert needs to be generated
    private void checkIfAnyAlertNeedsToBeGenerated(VehicleReading vehicleReading) {
        VehicleDetail currentVehicleDetail = vehicleDetailService.findVehicleDetailByVin(vehicleReading.getVin());
        if (vehicleReading.getEngineRpm() > currentVehicleDetail.getredlineRpm()) {
            log.info("Engine RPM found Greater tthan Threshold , Generating Alert for vehicle " + vehicleReading.getVin());
            createAlert(vehicleReading.getVin(), CarSensorConstants.ALERT_MESSAGE_ENGINE_RPM, AlertPriority.HIGH);
        }
        
        if (currentVehicleDetail.getMaxFuelVolume() > vehicleReading.getFuelVolume() * 10) {
            log.info("Fuel Volume found below tthan Threshold , Generating Alert for vehicle " + vehicleReading.getVin());
            createAlert(vehicleReading.getVin(), CarSensorConstants.ALERT_MESSAGE_FUEL_VOLUME, AlertPriority.MEDIUM);
        }
    }
    
    private void createAlert(String vin, String alertMessage, AlertPriority alertPriority) {
        try {
            
            VehicleAlert alert = new VehicleAlert(vin, alertMessage, alertPriority, new Timestamp(System.currentTimeMillis()));
            log.info("Saving the Alert" + alert + " to the database");
            vehicleAlertService.save(alert);
        } catch (Exception ex) {
            log.severe("Error in creating Alert for vehicle with vin " + vin);
        }
    }
    
}
