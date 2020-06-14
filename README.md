# test-service
Test task for Java developer

CRUD application with REST API using Spring Framework:
#### 1. POST /task 
	* creates a row in DB with GUID and timestamp
	* returns 202 and task GUID
	* refreshes timestamp and makes task status "running"
	* waits 2 minutes then makes task status "funished"
#### 2. GET /task/{id} 
	* {id} is a GUID of a task
	* returns 200 and task status
	* returns 404 if task not found
	* returns 400 if {id} is not a GUID
