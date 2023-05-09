# Pet management API and Angular
Pet management API and Angular frontend for Wisercats internship test.
Unfinished

## How to start
1. Clone the repository. In terminal ```git clone https://github.com/Taavi4n5/PetManagementAPIandAngular```

### How to run API
2. Once clean install is complete, run ```mvn spring-boot:run``` in terminal. 
3. API will start on [localhost:8080](http://localhost:8080)

### How to run Angular frontend
4. Navigate to AngularFrontend folder (If already on root folder ```cd AngularFolder``` in terminal should do the trick).
5. Run ```ng serve``` in the terminal.
6. App will start on [localhost:4200}(http://localhost:4200/login)

## API Endpoints
### User endpoints
1. POST ```/api/login``` Used to compare login credentials with database.

3 users in database are:
```JSON
{
"name": "John",
"password": "Passw0rd"
}
```
```JSON
{
"name": "Mary",
"password": "Par00lA"
}
```
```JSON
{
"name": "Tommy",
"password": "123"
}
```
3. POST ```/api/authenticate``` Used to distribute JWT tokens.

Takes
```JSON
{
"name": string,
"password": string
}
```
### Pet endpoints
3. GET ```/api/pets``` Returns all pets from database.
4. GET ```/api/pets/:id``` Returns a pet from database by id.
5. GET ```/api/pet-types``` Returns a list of pet types from database.
6. GET ```/api/pet-colours``` Returns a list of pet colours from database.
7. GET ```/api/pet-countries``` Returns a list of pet countries from database.
8. POST ```/api/pets``` Adds a pet to database. 
Takes
```JSON
{
"name": string,
"code": integer,
"type": string,
"furColour": string,
"country": string
}
```
6. PUT ```/api/pets/:id``` Updates pet in database from id.
Takes
```JSON
{
"name": string,
"code": integer,
"type": string,
"furColour": string,
"country": string
}
```
7. DELETE ```/api/pets/:id``` Deletes pet from database by id.

## My thoughts
### What works
User endpoints work, pet endpoints work. Authentication and autorization works.
### What needs work
Currently angular side of autorization needs some correcting. Implementing user pets instead of showing everyones pets.
### What I wanted to implement
Validation was something I wanted to leave as last. I have not thought much about that yet but I thought using regex in frontend. No idea what to use on backend though.
I also wanted to add error exceptions to handle cases to API.
## Time
I started on 2nd May, I just couldn't start earlier due to schoolwork. I am sure had I started earlier I would have something more grand to show, but it is what it is. It took me 6 hours to build this API, 3 hours for Angular and some 16 hours of spring boot security (specifically getting security and angular get along nicely).

