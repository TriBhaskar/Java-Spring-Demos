
To Dockerise your springboot application:
1. Run this command inside your project
- docker init
// This will ask you couple of questions see below example:
// Example:
- docker init

Welcome to the Docker Init CLI!

This utility will walk you through creating the following files with sensible defaults for your project:
- .dockerignore
- Dockerfile
- compose.yaml
- README.Docker.md

Let's get started!

? What application platform does your project use? Java
? What's the relative directory (with a leading .) for your app? (./src)

? What's the relative directory (with a leading .) for your app? ./src
? What version of Java do you want to use? 17

? What version of Java do you want to use? 17
? What port does your server listen on? 8080

? What port does your server listen on? 8080

✔ Created → .dockerignore
✔ Created → Dockerfile
✔ Created → compose.yaml
✔ Created → README.Docker.md

→ Your Docker files are ready!
Review your Docker files and tailor them to your application.
Consult README.Docker.md for information about using the generated files.

* For running your spring-boot application in docker you required maven wrapper *


maven based projects need maven to run, but different projects may have different maven versions.
and why do we have to install different maven on our machine.

So we take help of Maven Wrapper
Instead of installing many versions of it in the operating system, we can just use the project-specific wrapper script.

Steps to follow for maven wrapper plugin:
1. Run this command  inside your maven project
   mvn -N wrapper:wrapper
2. This will create a maven wrapper in your project directory
3. Now you can run maven commands using the wrapper script
   ./mvnw clean install
4. To run springboot project with maven wrapper
   ./mvnw spring-boot:run

Now to start your springboot application in docker follow below steps:
- docker compose up --build
Note : Make sure you have done correct configurations in your pom.xml file for creating executable jar file.
