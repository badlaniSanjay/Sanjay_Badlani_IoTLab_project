package com.iot.cs;


import com.iot.cs.DAO.TestClassDAO;
import com.iot.cs.model.TestClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSensorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSensorApplication.class, args);
                
//              TestClassDAO testClassDAO = new TestClassDAO();
//              TestClass testClass = new TestClass();
//              testClass.setFirstName("abcd");
//              //testClass.setId(1);
//              testClassDAO.save(testClass);
	}
}
