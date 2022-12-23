# PRODUCT web api


----
### information

Backend project for product api. trying to simulate api for ecommerce product module which also includes user login
and registration. specific role is also provided like admin or normal user. multiple roles can be added its not limited to 
only admin and user. uses JWT token based authentication.

### Main features used
- spring data jpa
- Hibernate
- Jwt Token based Authentication
- Spring security
- Spring rest
- swagger ui ( limited not configured for complete project)
- lombok project
- MySql database/H2 db


### software requirements
- Intellij idea / Eclipse or any other IDE that supports spring framework (*configure settings for hibernate module in settings if req.)
- MySql Community server (if you don't want to use mysql please change application properties to use H2 Database)
- Postman or any other Api testing software

### running this api project
- clone this project by using (https://github.com/someshsurve/WebProductApi.git) or simply download it.
- create schema in sql with name "code0db"
- with pom.xml included import or build project so that all dependencies will be added
- run WebProject Module
- now let's create user so that we can access api
- before using you can set where you want to local host your api. in applicaion properties you can change
![img.png](img.png)
- now access ```localhost:8081/register``` to create new user

