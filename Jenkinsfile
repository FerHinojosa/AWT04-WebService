pipeline {
    agent any
    stages {
        stage ('Build') {
            agent {
                docker {image '5917362014/webapp'}
            }
            steps {
                sh '/usr/src/webService/gradlew build'
                
            }
        }
        stage ('Test2'){
            steps {
                sh 'echo "Hello"'
            }
        }
    }
}  