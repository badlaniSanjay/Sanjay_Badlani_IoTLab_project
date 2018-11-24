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
@Table(name = "vehicle_detail")
public class VehicleDetail implements Serializable {

    @Id
    @Column(name = "vin")
    private String vin;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "redline_rpm")
    private Integer redlineRpm;

    @Column(name = "max_fuel_volume")
    private Integer maxFuelVolume;

    @Column(name = "last_service_date")
    private Timestamp lastServiceDate;

    public VehicleDetail() {
    }

    public VehicleDetail(String vin, String make, String model, Integer year, Integer redlineRpm, Integer maxFuelVolume, Timestamp lastServiceDate) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.redlineRpm = redlineRpm;
        this.maxFuelVolume = maxFuelVolume;
        this.lastServiceDate = lastServiceDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getredlineRpm() {
        return redlineRpm;
    }

    public void setredlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public Integer getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Integer maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" + "vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlineRpm=" + redlineRpm + ", maxFuelVolume=" + maxFuelVolume + ", lastServiceDate=" + lastServiceDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 83 * hash + Objects.hashCode(this.vin);
        hash = 83 * hash + Objects.hashCode(this.make);
        hash = 83 * hash + Objects.hashCode(this.model);
        hash = 83 * hash + Objects.hashCode(this.year);
        hash = 83 * hash + Objects.hashCode(this.redlineRpm);
        hash = 83 * hash + Objects.hashCode(this.maxFuelVolume);
        hash = 83 * hash + Objects.hashCode(this.lastServiceDate);
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
        final VehicleDetail other = (VehicleDetail) obj;
        if (!Objects.equals(this.vin, other.vin)) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }

        if (!Objects.equals(this.year, other.year)) {
            return false;
        }
        if (!Objects.equals(this.redlineRpm, other.redlineRpm)) {
            return false;
        }
        if (!Objects.equals(this.maxFuelVolume, other.maxFuelVolume)) {
            return false;
        }
        if (!Objects.equals(this.lastServiceDate, other.lastServiceDate)) {
            return false;
        }
        return true;
    }

}
