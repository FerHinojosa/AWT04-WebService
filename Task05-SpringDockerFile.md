## Code
FROM alpine
RUN apk add openjdk8
COPY . /home/AWT04-WebService
WORKDIR /home/AWT04-WebService
RUN ./gradlew build .
ENTRYPOINT /bin/bash
EXPOSE 8080:8080
CMD java -jar spring.jar

## Steps to create and run our Spring web service
1.- docker build -t <image_name> .
2.- docker run -it -d <image_name> /bin/bash 
3.- docker build -t springubuntu.
4.- docker run -it -d <image_name>
5.- docker exec -it <id_image> bash
6.- cd /home/AWT04-WebService/
7.- ./gradlew build 
8.- java -jar /home/AWT04-WebService/build/libs/WebService-1.0-SNAPSHOT.jar
