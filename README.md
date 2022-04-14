# springboot-my-app
Light Feather Project
    
1. Clone code into your local machine from this repo.
2. (Developer notep: If you want to rebuild the jar file in Eclipse (ID of choice) select the project root directory and right click to select: 
    Run As » Maven build… » Goals: clean package » Run. A new jar is created under target directory. Need to copy this to the root directory.)
		
3. docker build --tag=springboot-my-app:latest .
		
4. docker run -p9099:8080 springboot-my-app:latest
5. GET: http://localhost:9099/api/supervisors
6. POST: Use postman localhost:9099/api/submit and supply the body in JSON format as below: 
7. {
		 "firstName": "Impedimenta",
		 "lastName": "Ram",
		 "email": "Impedimenta.ram@saturn.com",
		 "phone": "512-523-5555",
		 "supervisor": "Jim"
		}
