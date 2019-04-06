#BookLibraryApp

The main goal of this project was build the system backed by a WEB API that will provide several endpoints and serve the relevant information based on data read from a JSON file.

###1. http://localhost:8000/book/{isbnNumber}
Expose the endpoint which allows reading details about a book. It will return a book identified by the given ISBN number in the form of a JSON document or return a 404 "No results found" if the book does not exist in the data set.

###2. http://localhost:8000/category/{categoryName}
Create an endpoint that will list all books that are assigned to the requested category (empty list if no books belong to the category).

###3. http://localhost:8000/rating
Lists all authors and their rating in descending order of the average rating of their books. If a book is not rated, it is not be taken into account in the calculation of its author rating.

## Description of the application framework that have beed used
App framework that was used is Java EE. To design RESTFul convention for endpoint address jersey and grizzly was used. To serialize and deserialize objects Jackson was used.


## Description of the testing framework used
Testing libraries is JUnit.


## Design Patterns used and why they were used
Design pattern used in this project is singleton. It is used twice: in Deserialize class, so that programm deserialize objects only once ang paraller requests see the same data and in InstanceMaker class used in tests.


##Running application

###To build project and run tests use following command:
```
mvn clean package
```

###To run code from existing jar:
```
java -jar BookLibraryApp.jar.jar arg
```
where arg is *.json file path or Google Books APIs URI, for example: https://www.googleapis.com/books/v1/volumes?q=java&maxResults=40. Programm will recognize if it is URL or file (it allows switching the dataset from the commandline).
App is running on port 8000.
Jar file path: in ./out/artifacts/BookLibraryApp_jar/BookLibraryApp.jar. It was copied also to ./ directory.


###To generate javadocs:
```
mvn javadoc:javadoc
```
Wygenerowane javadocki znajdują się w pliku: target/site/apidocs





