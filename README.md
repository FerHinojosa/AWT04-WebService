## DockerCompose

1. Clone this project 
2. Install docker compose
   sudo apt-get install docker-compose
3. Go to this path /src/usr/AWT04-WebService
4. Run
   docker-compose up -d
5. Install Postman and paste this path:
	http://localhost:8080/api/v1.0/hello
   Select option(Get, Post, Put, Delete)


## Dockerfile to create a image WebService

FROM ubuntu 
MAINTAINER Fernando Hinojosa (Fernando.Hinojosa@fundacion-jala.org)
RUN apt-get update && apt-get install -y default-jdk
COPY . /tmp/AWT04-WebService
ENTRYPOINT /bin/bash
EXPOSE 8080
CMD java -jar spring.jar

## Create a image
docker build -t <image_name> .

## Create a container

docker run -it -d <image_name> /bin/bash 

## 
=======
Create image with a Dockerfile

    docker build -t ubuntufer .

To Run a container

    docker run -it -d <image_name>

Connect to the container

    docker exec -it <ID_image>

Go to the path

    cd /tmp/AWT04-WebService/

Build project

    ./gradlew build 

Run project
    java -jar /tmp/AWT04-WebService/build/libs/WebService-1.0-SNAPSHOT.jar

