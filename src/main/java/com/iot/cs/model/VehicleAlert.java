package com.iot.cs.model;

import com.iot.cs.misc.AlertPriority;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author sanjaybadlani
 */
@Entity
@Table(name = "vehicle_alert")
public class VehicleAlert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vin")
    private String vin;

    @Column(name = "alert_message")
    private String alertMessage;

    @Column(name = "alert_priority")
    private AlertPriority alertPriority;

    @Column(name = "current_timestamp_ts")
    private Timestamp currentTimestampTs;

    public VehicleAlert(String vin, String alertMessage,
            AlertPriority alertPriority,
            Timestamp currentTimestampTs) {

        this.vin = vin;
        this.alertMessage = alertMessage;
        this.alertPriority = alertPriority;
        this.currentTimestampTs = currentTimestampTs;
    }

    public VehicleAlert() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public AlertPriority getAlertPriority() {
        return alertPriority;
    }

    public void setAlertPriority(AlertPriority alertPriority) {
        this.alertPriority = alertPriority;
    }

    public Timestamp getcurrentTimestampTs() {
        return currentTimestampTs;
    }

    public void setcurrentTimestampTs(Timestamp currentTimestampTs) {
        this.currentTimestampTs = currentTimestampTs;
    }

    @Override
    public String toString() {
        return "Alert{" + "id=" + id + ", vin=" + vin + ", alertMessage=" + alertMessage
                + ", alertPriority="
                + alertPriority
                + ", currentTimestampTs=" + currentTimestampTs + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.vin);
        hash = 97 * hash + Objects.hashCode(this.alertMessage);
        hash = 97 * hash + Objects.hashCode(this.alertPriority);
        hash = 97 * hash + Objects.hashCode(this.currentTimestampTs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleAlert other = (VehicleAlert) obj;
        if (!Objects.equals(this.vin, other.vin)) {
            return false;
        }
        if (!Objects.equals(this.alertMessage, other.alertMessage)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.alertPriority != other.alertPriority) {
            return false;
        }
        if (!Objects.equals(this.currentTimestampTs, other.currentTimestampTs)) {
            return false;
        }
        return true;
    }

}
