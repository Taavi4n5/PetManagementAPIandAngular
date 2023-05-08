# Pet management API and Angular
Pet management API and Angular frontend for Wisercats internship test.
Unfinished

## How to start
1. Clone the repository. In terminal ```git clone https://github.com/Taavi4n5/PetManagementAPIandAngular```

### How to run API
2. Once clean install is complete, run ```mvn spring-boot:run``` in terminal. 
3. API will start on [localhost:8080](http://localhost:8080)

### How to run Angular frontend
4. Navigate to AngularFrontend folder (If already on root folder ```cd AngularFolder``` i terminal should do the trick).
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
Maybe you have already tried to run the application or maybe you are reading this first. Maybe API didnt even start? Hopefully at least it did that... I do not have much prior ecperience with Spring Boot or Angular, much less sharing it. Anyways, what works, what does not.
### What works
User endpoints work, in angular when you login with one of 3 accounts, a POST is sent to API and a response is sent back. If login was a success, user is given a JWT token. Column sorting. Here ends what works currently. Well, PET endpoints kinda work, just not through frontend right now. 
### What does not work
All of PET endpoints through Angular (they do work when using tools like Postman) because I just couldn't figure out why Authorization with bearer token requests could not produce responses. Its not CORS, its not CSFR, it might be headers, but I just can not figure this out right now. I could remove authentication and authorization and the application would work (I might do seperate branch), lists would load, user could add, update or delete.. , but so much work has gone into it that I want to figure this out later on.
### What I wanted to implement
That TODO where user is displayed their own pets was on the menu after security. However that should be a simple PetModel, PetDTO and pets table edit to include forgein key user ids. Then when user logs in and we know his id, we can load pets associated with that id.
Validation was something I wanted to leave as last. I have not thought much about that yet but I thought using regex in frontend. No idea what to use on backend though.
I also wanted to add error exceptions to handle cases to API.
## Time
I started on 2nd May, I just couldn't start earlier due to schoolwork. I am sure had I started earlier I would have something more grand to show, but it is what it is. It took me 6 hours to build this API, 3 hours for Angular and then I decided: "OK, pretty good, lets create security with JWT on unfamiliar Spring Boot grounds because why not." It has taken me 14 hours over 2 last days to implement this security - sphagetti code. 

