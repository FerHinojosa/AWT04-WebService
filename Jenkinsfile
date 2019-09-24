pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo "Hello World"'
      }
    }
    stage('Unit test') {
      steps {
        sh 'echo "Hello" && ls /tmp'
        sh 'ls /src'
      }
    }
  }
}