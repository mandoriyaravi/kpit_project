# Project Title

Heap Sorting Algorithm Spring Boot Application
## Description
This Spring Boot application offers a variety of heap operations and a heap-based sorting algorithm. The application utilizes a Min Heap data structure to perform these operations efficiently. It exposes RESTful APIs to insert values into the heap, find the minimum and maximum values, apply heap-based sorting, and clear the heap list.


## Getting Started

Prerequisites:-

Before running the Heap Sorting Algorithm Spring Boot Application, ensure you have the following prerequisites:

- **Java**: This application requires Java 8 or higher.

### Running the Application

Follow these steps to run the application:

1. Clone the repository to your local machine:

2. Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. Build and run the application from your IDE, or you can use the following Maven command in the project root directory:-
  
  mvn spring-boot:run

The application will start and listen on http://localhost:8080 by default.

##API Endpoints

###*Insert Values:-

URL: http://localhost:8080/api/insert

HTTP Method: POST

Request Body: An array of integers to be inserted into the heap.

Response: 200 ok

curl --location 'http://localhost:8080/api/insert' \

--header 'Content-Type: application/json' \

--data '

[1,6,8,43,54]
'

#####*Get Maximum Value:-

URL: http://localhost:8080/api/max

HTTP Method: GET

Response: The maximum value in the heap.

curl --location --request GET 'http://localhost:8080/api/max' \

--header 'Content-Type: application/json' \

--data '

[1,6,8,43,54]
'

#####*Get Minimum Value:-
URL: http://localhost:8080/api/min

HTTP Method: GET

Response: The minimum value in the heap.

curl --location --request GET 'http://localhost:8080/api/min' \

--header 'Content-Type: application/json' \

--data '

[1,6,8,43,54]
'


#####*Clear Heap List
URL: http://localhost:8080/api/clearlist

HTTP Method: DELETE

Response: 200 ok

#####*Delete Minimum Element
URL: http://localhost:8080/api/deletemin

HTTP Method: DELETE

Response: 200 ok


#####*Apply Min Heap Sorting:-
URL: http://localhost:8080/api/applyMinHeap

HTTP Method: POST

Request Body: An array of integers.

Response: An array with a min-heap structure applied (without sorting).

#####Description:
This endpoint accepts an array of integers and applies a min-heap structure to the input array, transforming it into a valid min-heap.
 The heapify operation is performed on the input array, ensuring that the parent nodes are smaller than their child nodes (min-heap property).

POST /api/applyMinHeap

{
  "arr": [4, 2, 9, 1, 5, 6]
}

#####*Apply Max Heap Sorting:-
URL: http://localhost:8080/api/applyMaxHeap

HTTP Method: POST

Request Body: An array of integers.

Response: An array with a max-heap structure applied (without sorting).

#####Description:
This endpoint is similar to /api/applyMinHeap, but it applies a max-heap structure to the input array, 
ensuring that the parent nodes are larger than their child nodes (max-heap property).

POST /api/applyMaxHeap

{
  "arr": [4, 2, 9, 1, 5, 6]
}

#####*Apply Min Heap Sorting & Sort of element:-
URL: http://localhost:8080/api/applyMinHeapSort

HTTP Method: POST

Request Body: An array of integers.

Response: An array sorted in ascending order using min-heap sort.

#####Description:
This endpoint applies a min-heap sort to the input array, resulting in a sorted array in ascending order.
 It first converts the input array into a min-heap and then repeatedly extracts the minimum element (the root) while maintaining the min-heap property.

POST /api/applyMinHeapSort

{
  "arr": [4, 2, 9, 1, 5, 6]
}
#####*Apply Max Heap Sorting and Sort of element:-
URL: http://localhost:8080/api/applyMaxHeapSort

HTTP Method: POST

Request Body: An array of integers.

Response: An array sorted in descending order using max-heap sort.

#####Description:
Similar to /api/applyMinHeapSort, this endpoint applies a max-heap sort to the input array, resulting in a sorted array in descending order.
 It first converts the input array into a max-heap and then repeatedly extracts the maximum element (the root) while maintaining the max-heap property.

POST /api/applyMaxHeap

{
  "arr": [4, 2, 9, 1, 5, 6]
}







