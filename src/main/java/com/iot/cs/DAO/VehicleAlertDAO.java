/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iot.cs.DAO;

import com.iot.cs.misc.AlertPriority;
import com.iot.cs.model.VehicleAlert;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author sanjaybadlani
 */
public interface VehicleAlertDAO {
    public void save(VehicleAlert vehicleAlert);
    public List<VehicleAlert> findVehicleAlertsByVin(String vin);
    public List<VehicleAlert> findAlertsWithTimeGreaterAndPriority(Timestamp twoHoursBack, AlertPriority alertPriority);
}
