
pipeline {
  agent any
  tools {
    maven 'Maven'
    jdk 'JDK'
  }
  stages {
    stage('Clean'){
      steps{
        sh "mvn clean"
      }
    }
    stage('Build') {
      steps {
        sh "chmod +x src/main/resources/drivers/chromedriverlinux"
        sh "mvn test  -X"
      }
    }     
     stage('Run Allure') {
      steps {
        sh "nohup /opt/allure/bin/allure serve allure-results --port 3030 &"
      }
    } 
  }
}
