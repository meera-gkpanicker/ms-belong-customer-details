# Belong Customer Phone Number Services!

This project provides the following APIs and is developed using spring boot, gradle and adding new API for fetching phonenumbers and activating them.

1. An API that allows clients to retrieve all the phone numbers present in the system
2. An API that allows clients to retrieve all the phone numbers for a single customer 
3. An API that allows to activate the phone number.

## Project Repo URL
https://github.com/meera-gkpanicker/ms-belong-customer-details.git

# Follow the below steps to build and run this application:

1. Clone the project and import the same in an IDE (IntelliJ/STS).
2. Build the project from terminal using the command ./gradlew bootJar 
3. After build completes, run the jar file in the target folder using the command

####java -jar build/libs/ms-belong-customer-details-1.0-SNAPSHOT.jar ####

4. The microservices will run on the port 8090 using the context path **/ms-belong-customer-details **
7. Refer to the below curl commands

## Testing RESTful Services

1. Retrieve All Phone Numbers:
		
		$ curl -X GET \
          http://localhost:8090/ms-belong-customer-details/phonenumbers/customer1 \
          -H 'cache-control: no-cache' \
          -H 'postman-token: 405b0149-abb5-58a2-e0a6-42391dd9f852'

		

2. Retrieve Phone number By customer:

        $ curl -X GET \
          http://localhost:8090/ms-belong-customer-details/phonenumbers/list \
          -H 'cache-control: no-cache' \
          -H 'postman-token: 3fbc9b70-62fa-428b-aed3-4f8c657d0bde'



3. Activate Phone Number:

        $ curl -X POST \
          http://localhost:8090/ms-belong-customer-details/activate/456789003 \
          -H 'cache-control: no-cache' \
          -H 'postman-token: df5a6648-2b23-4c7e-cefb-d0fb4d238811'
