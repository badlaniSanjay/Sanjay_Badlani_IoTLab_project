package com.iot.cs.web;

import com.iot.cs.model.VehicleDetail;
import com.iot.cs.service.VehicleDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sanjaybadlani This is Rest controller useful for handling the Vehicle
 * Detail Requests.
 */
@RestController
@RequestMapping(path = "/vehicleDetail/")
public class VehicleDetailController {

    private static final Logger log = LoggerFactory.getLogger(VehicleDetailController.class);

    private VehicleDetailService vehicleDetailService;

    @Autowired
    public VehicleDetailController(VehicleDetailService vehicleDetailService) {
        this.vehicleDetailService = vehicleDetailService;
    }

    //This method is used to save the vehicle Detail in the Database.
    @RequestMapping(method = RequestMethod.PUT, path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVehicleDetail(@RequestBody VehicleDetail[] vehicleDetails) {

        for (VehicleDetail eachVehicleDetail : vehicleDetails) {
            try {
                if (vehicleDetailService.findVehicleDetailByVin(eachVehicleDetail.getVin()) != null) {
                    log.debug("There is  entry in the database with vehice Id vin as " + (eachVehicleDetail.getVin()));
                    log.debug("Updating the existing Object " + eachVehicleDetail.toString());
                    vehicleDetailService.save(eachVehicleDetail);
                } else {
                    log.debug("There is no entry in the database with vehice Id vin as " + (eachVehicleDetail.getVin()));
                    log.debug("saving Object " + eachVehicleDetail.toString());
                    vehicleDetailService.save(eachVehicleDetail);
                }
            } catch (Exception ex) {
                log.error("Exception in saving the Vehicle Detail"
                        + eachVehicleDetail.toString() + " in the database " + ex);
            }
        }

    }

    // This method is used to get the Details of all the vehicles stored in the database.
    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public Iterable<VehicleDetail> findAllVehicleDetails() {
        try {
            log.debug("Fetching all the Vehicle Details in the database ");
            return vehicleDetailService.findAllVehicleDetail();
        } catch (Exception ex) {
            log.error("Exception occured while fetching vehicle Details from Database " + ex);
        }
        return null;
    }

}
