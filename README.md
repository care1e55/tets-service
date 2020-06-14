# test-service
Test task for Java developer

CRUD application with REST API using Spring Framework:
#### POST /task 
	1. creates a row in DB with GUID and timestamp
	2. returns 202 and task GUID
	3. refreshes timestamp and makes task status "running"
	4. waits 2 minutes then makes task status "funished"
 #### GET /task/{id} 
	1. {id} is a GUID of a task
	2. returns 200 and task status
	3. returns 404 if task not found
	4. returns 400 if {id} is not a GUID
