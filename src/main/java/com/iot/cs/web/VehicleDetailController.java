
package com.iot.cs.web;

import com.iot.cs.model.VehicleDetail;
import com.iot.cs.service.VehicleDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping(path = "/vehicleDetail/")
public class VehicleDetailController {
    
    VehicleDetailService vehicleDetailService;
    
    @Autowired
    public VehicleDetailController(VehicleDetailService vehicleDetailService) {
        this.vehicleDetailService = vehicleDetailService;
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVehicleDetail( @RequestBody VehicleDetail[] vehicleDetails) {
        //VehicleDetail vehicleDetail = (VehicleDetail) ratingDto ;
        
        for(VehicleDetail eachVehicleDetail : vehicleDetails){
            if(vehicleDetailService.findVehicleDetailByVin(eachVehicleDetail.getVin()) != null){
                vehicleDetailService.save(eachVehicleDetail);
            }
            else {
            vehicleDetailService.save(eachVehicleDetail);
            }
    }
        
    }

   
    
    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public Iterable<VehicleDetail> findAllVehicleDetails( ) {      
        return vehicleDetailService.findAllVehicleDetail();
    }
    
    
    

    
}
