
package com.iot.cs.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author sanjaybadlani
 */
@Entity
@Table(name = "vehicle_reading")
public class VehicleReading implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "vin")
    private String vin;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "current_timestamp_ts")
    private Timestamp currentTimestampTs;

    @Column(name = "fuel_volume")
    private Float fuelVolume;

    @Column(name = "speed")
    private Integer speed;
    
    @Column(name = "engine_hp")
    private Integer engineHp;
    
    @Column(name = "check_engine_light_on")
    private Boolean checkEngineLightOn;
    
    @Column(name = "engine_coolant_low")
    private Boolean engineCoolantLow;
    
    @Column(name = "cruise_control_on")
    private Boolean cruiseControlOn;
    
    @Column(name = "engine_rpm")
    private Integer engineRpm;

    public VehicleReading(Integer id, String vin, Double latitude, Double longitude, Timestamp currentTimestampTs, Float fuelVolume, Integer speed, Integer engineHp, Boolean checkEngineLightOn, Boolean engineCoolantLow, Boolean cruiseControlOn, Integer engineRpm) {
        this.id = id;
        this.vin = vin;
        this.latitude = latitude;
        this.longitude = longitude;
        this.currentTimestampTs = currentTimestampTs;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.engineHp = engineHp;
        this.checkEngineLightOn = checkEngineLightOn;
        this.engineCoolantLow = engineCoolantLow;
        this.cruiseControlOn = cruiseControlOn;
        this.engineRpm = engineRpm;
    }

    public VehicleReading() {
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
    
    

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return currentTimestampTs;
    }

    public void setTimestamp(Timestamp currentTimestampTs) {
        this.currentTimestampTs = currentTimestampTs;
    }

    public Float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(Float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(Integer engineHp) {
        this.engineHp = engineHp;
    }

    public Boolean getCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public Boolean getEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(Boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public Boolean getCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(Boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public Integer getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(Integer engineRpm) {
        this.engineRpm = engineRpm;
    }

    @Override
    public String toString() {
        return "VehicleReading{" + "id=" + id + ", vin=" + vin + ", latitude=" + latitude + ", longitude=" + longitude + ", currentTimestampTs=" + currentTimestampTs + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", engineHp=" + engineHp + ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow=" + engineCoolantLow + ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + '}';
    }

    
   

    
    
    
}
