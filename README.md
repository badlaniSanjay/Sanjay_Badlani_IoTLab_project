# Sanjay_Badlani_IoTLab_project

CarSensor
This project implements Back-end Microservice REST API that is used to service the Data provided from the sensors of different vehicles and also provides end points to display these data and create alerts if necessary for different events.



Make sure the following softwares are installed in your system Before trying to run the project.
1. MySql server - 8.0.13
2. Java - 1.8

Getting Started
1. Import the Database.sql file in Mysql workbench to create the necessary database structure.
2. Update the hibernate.cfg.xml in src/main/resources folder based on the username and password of Mysql server.

Give examples
Installing
1.The micro service accepts request which have JSON data in the request body(in case of PUT and POST) and processes it and also stores that in Database.
2. It sends the response in case of GET request by fetching the data from database, also in the form of JSON objects.

Running the tests
1. We can test the system by making use of [http://mocker.ennate.academy/]
2. Also we can use Postman software to send the request to the API


The URL to be used for testing different project functionalities are as follows :-
1. To Put an array of Vehicle Details - “http://localhost:8080/vehicleDetail/save”
2. To Post Vehicle Reading - “http://localhost:8080/vehicleReading/save”
3. To Get Details of all the vehicles - “http://localhost:8080/vehicleDetail/getAll”
4. To Get ALL HIGH alerts in last two hours - 
		“http://localhost:8080/vehicleReading/getAllHighAlerts”
5. To Get All alerts for a given vehicle - “http://localhost:8080/vehicleReading/getAllAlerts/<vehicle_id>”

 

Built With
1. Spring Web Framework - The web framework used
2. Hibernate Core - Data Persistence
3. Maven - Dependency Management


Versioning
Github is used for versioning.

Author
Sanjay Badlani.

