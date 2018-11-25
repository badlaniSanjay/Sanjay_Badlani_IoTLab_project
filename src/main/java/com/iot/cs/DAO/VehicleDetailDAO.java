
package com.iot.cs.DAO;

import com.iot.cs.model.VehicleDetail;
import java.util.List;

/**
 *
 * @author sanjaybadlani
 */
public interface VehicleDetailDAO {
    public void save(VehicleDetail vehicleDetail);
    public VehicleDetail findVehicleDetailByVin(String vin);
    public List<VehicleDetail> findAllVehicleDetails();
}
