package com.iot.cs.service;

import com.iot.cs.misc.AlertPriority;
import com.iot.cs.model.VehicleAlert;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author sanjaybadlani
 */
public interface VehicleAlertService {
    public void save(VehicleAlert VehicleAlert);
    public List<VehicleAlert> findVehicleAlertByVin(String vin);
    public List<VehicleAlert> findAlertsWithTimeGreaterAndPriority(Timestamp twoHoursBack, AlertPriority alertPriority);
}
