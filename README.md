# Inventory Management System
Coverage: 17.7%

An IMS with CRUD functionality that uses GCP to host a mySQL database. This project aimed at creating a system that can manipulate data on the cloud. The development process included Java code to run the processes with JUnit and Mockito as unit tests. This produced a working IMS that can track and manipulate customer information, order details and item data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Install: Eclipse IDE for Java and JDK14 as well as MySQL Server (locally running the project). You can also run the MySQL Server on a GCP instance.


```

### Installing

The repository can be cloned with the following command in your terminal Make sure you are running the latest version of Java and MySQL 5.7 Server. The DBUtils files need to be changed to reflect this with your MySQL IP address. Cloning the project will give you an IMS-Starter directory which you can open in Eclipse or another IDE of your choice.

```
git clone <repoURL>.git
```

### Running the project

The user name and password:

```
user: root
password: root
```

The project will be interactable through the use of the command line in Eclipse. This is what you will see upon signing in:

```
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
```

To interact simply type the entity you would like to use:

```
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application

customer
What would you like to do with customer:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection

```

## Running the tests
Both JUnit and Mockito were used in this project for testing and as it stands the unit coverage of the entire project is only at 17.7% due to time constaints. Testing is on-going in the hopes of increasing it.

### Unit Tests 
The test suites are stored in src/test/java -> com.qa.ims. One example is:

```
CustomerDAOTest.java
```

### Integration Tests 
These tests test the CRUD functionality of the DAOs as well as testing for the right outputs being generated. The controllers are also being tested. Below is a list of all the tests in the project

```
CustomerDAOTest.java
CustomerDAOTestFail.java
CustomerControllerTest.java
ItemDAOTest.java
ItemDAOTestFail.java
ItemControllerTest.java
OrderDAOTest.java
OrderDAOTestFail.java
OrderControllerTest.java

```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
# Inventory-Management-System
