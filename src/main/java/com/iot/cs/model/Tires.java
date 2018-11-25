
package com.iot.cs.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sanjaybadlani
 */
@Entity
@Table(name = "tires")
public class Tires implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @OneToOne(mappedBy="tires")
    private VehicleReading vehicleReading;
    
    @Column(name = "front_left")
    private Integer frontLeft;
    
    @Column(name = "front_right")
    private Integer frontRight;
    
    @Column(name = "rear_left")
    private Integer rearLeft;
    
    @Column(name = "rear_right")
    private Integer rearRight;

    public Tires(VehicleReading vehicleReading, Integer frontLeft, Integer frontRight, Integer rearLeft, Integer rearRight) {
        this.vehicleReading = vehicleReading;
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
    }

    public Tires(Integer frontLeft, Integer frontRight, Integer rearLeft, Integer rearRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
    }

    public Tires() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VehicleReading getVehicleReading() {
        return vehicleReading;
    }

    public void setVehicleReading(VehicleReading vehicleReading) {
        this.vehicleReading = vehicleReading;
    }

   

    public Integer getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(Integer frontLeft) {
        this.frontLeft = frontLeft;
    }

    public Integer getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(Integer frontRight) {
        this.frontRight = frontRight;
    }

    public Integer getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(Integer rearLeft) {
        this.rearLeft = rearLeft;
    }

    public Integer getRearRight() {
        return rearRight;
    }

    public void setRearRight(Integer rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tires{" + "id=" + id + ", vehicleReading=" + vehicleReading + ", frontLeft=" + frontLeft + ", frontRight=" + frontRight + ", rearLeft=" + rearLeft + ", rearRight=" + rearRight + '}';
    }

    
    
    
    
}
