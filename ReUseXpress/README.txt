ReUseXpress - Import & Run (Eclipse)
1. Ensure JDK 17+, Maven, Tomcat 9/10 and MySQL are installed.
2. Run the SQL script: sql/reusexpress_schema.sql (creates DB and sample admin).
   - MySQL user/password in this package: root / root
3. In Eclipse: File -> Import -> Maven -> Existing Maven Projects -> select /ReUseXpress
4. Configure a Tomcat server and Run on Server.
5. Visit http://localhost:8080/ReUseXpress/
Notes:
- Passwords are stored in plain text for demo. Use BCrypt for production.
- Uploaded images are saved to webapp/resources/uploads when running via Tomcat in Eclipse.
