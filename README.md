# BookAPI

The aim of the task was to prepare an API for managing books. The project was built in Maven in the Spring framework (including Spring MVC). I put the application on Tomcat. I store the data to power the application directly in the code. I'm using an interface, not a specific implementation - such an approach will allow in the future to easily replace the data source with any other implementation, such as a database.
I converted objects to JSON format using the Jackson library. The Lombok library helped me to create an object class.
