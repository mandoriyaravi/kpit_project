# Project Title

Sorting Algorithm Spring Boot Application

## Description

This Spring Boot application implements a sorting algorithm to sort an array of integers using the sort algorithm.
 The application is structured as follows:

SortingController: A Spring Boot controller that exposes a RESTful API to sort an array of integers.


SortingServiceImpl: The service layer that performs the sorting algorithm.

## Getting Started
Prerequisites :-
Java 8 or higher


##Running the Application
1. Clone the repository to your local machine.

2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build and run the application from your IDE, or you can use the following Maven command in the project root directory:-
  
  mvn spring-boot:run

The application will start and listen on http://localhost:8080 by default.

###API Endpoints
#####SORT ARRAY :- 
URL: http://localhost:8080/sortarray 
 
HTTP Method: POST  
Request Body: An array of integers to be sorted.  
Response: An array of sorted integers.



#####Example Request:
json:-

POST /sortarray

{

  "arr": [4, 2, 9, 1, 5, 6]
  
}

#####Example Response:

json:-

output:- [1, 2, 4, 5, 6, 9]


##Error Handling
1. If the input array contains negative numbers, the application will return an InvalidArrayInputException.

2. Any other unexpected errors during the sorting process will result in a SortingException with an error message.

