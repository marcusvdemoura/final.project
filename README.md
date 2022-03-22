# final.project
CCT college - Final Project

 -- Check the end of the readme to see the list of abbreviations and bibliography


## STRUCTURE OF A SPRING PROJECT:

This project was created using Maven, therere all dependencies (archives—JAR, ZIP, and so on—which our current project needs in order to compile, build, test, and/or run) must be there.

### Layers

The project is divided into a few packages and layers:

1) In the main directory **com.example.demo** are the subfolders and layers and the **Application** class which will run the application.

**Subfolders and Layers**

2) Config:

As the project develops, we will be using different profiles for test, development and production. The profiles will allow us to map our beans to different profiles. 
For the testing profile, we'll be using the H2 database, which is a in-memory database for testing and we can access the data though the browser.
For the dev profile, we'll be using a mysql on myphpAdmin to test all data to be created/inserted and retrieved.
For the production, we'll use webservices and requests. A test has already been made on Heroku and it was deployed. It has been deleted at this point for corrections (05/02/2022) and another deployment will be made as soon as possible.
  
  Within the config layer, we'll configure the security. What can be accessed or not on the page by the browser etc.
  

3) Domain:
 
Within the domain layer, there will be the base for the entities and objects to be created. 
There are 5 classes created so far and one class in which the important variables are created. The parameter to create these important variables are that they won't be changed throughout the project, therefore they are static and final. We'll use them to store API request addresses and for the testing, some lists.
There are some subfolders within the domain:

  3.1) domaindto:
  
  In this subfolders the DTO classes will be created. 
  DTO, which stands for Data Transfer Object, is a design pattern conceived to reduce the number of calls when working with remote interfaces. 
  
  3.2) Enums
  
  Sometimes, when there are different types of choices and data, we will store them in the enums folder.
  When the person loggin in is a staff member of the company, we might want to know what their position is within the company to know what will be allowed or not for that         person.
  If it's a guest or future guest, we want to know which of the OTA the booking came through. The companies always have agencies they're partners with so that list will be         fixed.
  
4) repositories

Here, all of the JPA repositories will be stored.

A JPA repository is an interface and it contains the full API of CrudRepository and PagingAndSortingRepository. So it contains API for basic CRUD operations and also API for pagination and sorting.

This interface takes as parameter between <> the class which it refers to and the object ID type.

5) services

This layer contains the service providers. This means that, before the CRUD is ready to go, the service will deal with the data and its functionalities.

Also, for the testing purposes, there's a class named **DBService** in which the H2 or Mysql databases will have the main data stored when the project runs first.

6) resources

In this layer, all the entities resources will be stored.

The entity resource is responsible for the mapping of the requests. It will contain the CRUD functions. After the service is executed, the resource class will execute the CRUD and make the requests.






#Abbreviations

OTA - online travel agency 

Bibliography

https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3  Accessed: 22-02-2022 at 15:30
https://www.baeldung.com/spring-profiles Accessed at: 22-02-2022 at 16:00
https://www.geeksforgeeks.org/spring-service-annotation-with-example/ Accessed at: 22-02-2022 at 15:20
