# Revature: Project2

Group Name:		Mac-Man

Group Members:	John, Priyanka, Dan, Chandresh

Project2 Name:	Developer’s Corner Learning Website

Project Description:
	The project consists of a fully functional website where users can sign up to become ‘Leaners’ or ‘Mentors’. Learners will learn from each other, as well as be mentored by the users classified as ‘Mentors’. The Mentors are individuals that have experience in various technologies that will be beneficial to helping explain the complicated parts of software development.

#

## Project User Stores:
1)	User can sign up a new account.
2)	User can set account to new learner or mentor.
3)	User can set their time to learn (day/night).
4)	Mentors can set their teaching time (day/night).
5)	Mentors can add their languages/technologies to their account details.
6)	User can sign in as new Learner.
7)	Learner can request help from a Mentor via posting a question.
8)	Learner can send messages to Mentors.
9)	User can sign in as a Mentor.
10)	Mentors can view messages sent to them.
11)	Learners and Mentors can manage their account profile details.
12)	Users can delete their accounts.
13)	Mentors can respond to a Learner’s question.
14)	Users can add blog posts to their blogs for their account.
15)	Users can view other User’s blog posts.
16)	Users can like/dislike a blog post.
 
#

## Technologies Used:
1)	Java
2)	Spring Boot
3)	Spring JPA (Hibernate)
4)	Spring Security
5)	Angular
6)	TypeScript/JavaScript
7)	HTML & CSS
8)	Bootstrap
9)	PostgreSQL / JDBC
10)	Amazon Web Services – Relational Database
11)	H2 Database
12)	Postman
13)	DBeaver
14)	IntelliJ IDE
15)	Git / GitHub

#

## How to use this Repo:

Frontend

- The frontend is set up to use the 'proxy.config.json' file. This allows the frontend to connect with the backend through direct access via '/api/**' in the URL path. To use it, run the following command in the terminal:

		ng serve --proxy-config proxy.config.json --open

- This will start the frontend up to be hosted on port 4200, and open it in the default web browser.

Backend

- The backend requires setting up the 'application.properties' file inside of the '/src/main/resources' folder. The 'resources' folder needs to be created inside of the '/main' folder.The configuration below should be inserted into the 'application.properties' file, but replace the placeholder text for the database endpoint, username, and password to match your specific database that you use:

		server.port=8080
		server.servlet.context-Path=/api

		# Test Database with H2:
		#spring.h2.console.enabled=true
		#spring.datasource.url=jdbc:h2:mem:test
		#spring.datasource.driverClassName=org.h2.Driver
		#spring.datasource.username=admin
		#spring.datasource.password=password
		#spring.jpa-database-platform=org.hibernate.dialect.H2Dialect

		# Postgres Configuration:
		spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
		spring.jpa.hibernate.ddl_auto=update
		spring.jpa.hibernate.show-sql=true

		# AWS PostgreSQL Database Config
		#spring.datasource.url=jdbc:postgresql:// [placeholder for AWS RDS endpoint]
		#spring.datasource.username= [placeholder for username (default: postgres)]
		#spring.datasource.password= [placeholder for AWS RDS password]

		# Local PostgreSQL Database Config
		spring.datasource.url=jdbc:postgresql://localhost:5432/ [placeholder for local database]
		spring.datasource.username= [placeholder for local database name]
		spring.datasource.password= [placeholder for local database password]

- <b>NOTE:</b> You can change the server port to something other than 8080, if you wish. For those wanting to use the H2 database, or the AWS RDS, just comment the 'Local PostgreSQL Database Config' with #'s, and uncomment the specific database you want (remove #'s).