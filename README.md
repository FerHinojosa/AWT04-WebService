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
