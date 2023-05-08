# Pet management API and Angular
Pet management API and Angular frontend for Wisercats internship test.
Unfinished

## How to start
1. Clone the repository. In terminal ```git clone https://github.com/Taavi4n5/PetManagementAPIandAngular```

### How to run API
2. On project root folder, run ```mvn clean install``` in terminal.
3. Once clean install is complete, run ```mvn spring-boot:run``` in terminal.
4. API will start on [localhost:8080](http://localhost:8080)

### How to run Angular frontend
5. Navigate to AngularFrontend folder (If already on root folder ```cd AngularFolder``` i terminal should do the trick).
6. Run ```ng serve``` in the terminal.
7. App will start on [localhost:4200}(http://localhost:4200/login)

## API Endpoints
### User endpoints
1. POST ```/api/login``` Used to compare login credentials with database.

Takes

{

"name": "",

"password": ""

}

3. POST ```/api/authenticate``` Used to distribute JWT tokens.

Takes

{

"name": "",

"password": ""

}

### Pet endpoints
3. GET ```/api/pets``` Returns all pets from database.
4. GET ```/api/pets/:id``` Returns a pet from database by id.
5. GET ```/api/pet-types``` Returns a list of pet types from database.
6. GET ```/api/pet-colours``` Returns a list of pet colours from database.
7. GET ```/api/pet-countries``` Returns a list of pet countries from database.
8. POST ```/api/pets``` Adds a pet to database. 

Takes

{

"name": string,

"code": integer,

"type": string,

"furColour": string,

"country": string

}

6. PUT ```/api/pets/:id``` Updates pet in database from id.

Takes

{

"name": string,

"code": integer,

"type": string,

"furColour": string,

"country": string

}

7. DELETE ```/api/pets/:id``` Deletes pet from database by id.
