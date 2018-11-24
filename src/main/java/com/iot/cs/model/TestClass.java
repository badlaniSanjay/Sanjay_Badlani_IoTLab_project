
package com.iot.cs.model;
import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author sanjaybadlani
 */
@Entity
@Table(name= "test_class")  
public class TestClass {
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; 
    
    @Column(name = "first_name")
    private String firstName;

    public TestClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "TestClass{" + "id=" + id + ", firstName=" + firstName + '}';
    }
    
    
}
