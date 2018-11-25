
package com.iot.cs.service;

import com.iot.cs.model.VehicleDetail;
import java.util.List;

/**
 *
 * @author sanjaybadlani
 */
public interface VehicleDetailService {
    public void save(VehicleDetail vehicleDetail);

    public VehicleDetail findVehicleDetailByVin(String vin);

    public List<VehicleDetail> findAllVehicleDetail(); 
}
