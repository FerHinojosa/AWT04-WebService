
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