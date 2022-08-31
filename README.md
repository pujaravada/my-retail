# my-retail Application

## Description
my-retail is a web application with RESTful webservices that expose internal data to its clients, to provide product information and pricing using REST APIs that clients can access for this information.


This app has a GET API- 
1. A GET API over HTTP that retrieves the following information : id, productName, currentPrice, and curreny code
    {
        "id": 13860428,
        "productName": "The Big Lebowski (Blu-ray)",
        "currentPrice": {
            "productPrice": 17.89,
            "currencyCode": "USD"
        }
    }
    

### Data Source - 2 sources
1. The Product info comes from an external API from the given Redsky URL
2. The pricing info is sourced from a hosted NoSQL data store, MongoDb, thats running on a mongo cluster instance at https://cloud.mongodb.com/ using Mongo Atlas

### Tech stack
Spring Boot | 
Java |
Azure |
MongoDb |
Maven

## Running the app
### 1. Method 1 - Locally as Spring boot
my-retail is a Spring Boot application and can be cloned into a Java machine and using an IDE, can be started by using the "Run as Spring boot app" option.
**Docker - pending
Once the app is up and started, using the following GET URL to retrieve product info by id:
http://localhost:8080/myRetail/products?productId=13860428

### 2. Method 2 - It's live on Azure!!
The app is now hosted on Azure as an app service. It can be deployed to Azure by using the maven command as below
>mvn package azure-webapp:deploy - already taken care of for purposes of this project
<img width="911" alt="image" src="https://user-images.githubusercontent.com/9792815/187345084-23563b3d-fe53-4e06-97e1-c7ba16202172.png">
<img width="911" alt="image" src="https://user-images.githubusercontent.com/9792815/187765519-57887540-bb68-410d-b8d4-02df9340cddf.png">



## Accessing the API
https://my-retail-appservice.azurewebsites.net/myRetail/products?productId=13860428
The app is now hosted and running for the next few days on Azure as an appservice
The database is hosted and running on Mongo Atlas


*Note - For purposes of this project, I've kept the db fields down to 4.






