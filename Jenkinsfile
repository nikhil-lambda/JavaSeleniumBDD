
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
    stage('Test') {
      steps {
        sh "chmod +x src/main/resources/drivers/chromedriverlinux"
        sh "rm -rf allure-results/ |:"
        sh "mvn test -Dmaven.test.failure.ignore=true"
      }
    }     
    stage('Run Allure') {
      steps {
        sh "nohup /opt/allure/bin/allure serve allure-results --port 3030 &"
      }
    } 
    stage('Run JMeter') {
      steps {
        sh "/app/apache-jmeter-5.1/bin/jmeter -n -t HTTPRequest.jmx -l /app/apache-jmeter-5.1/HTTPRequest.jtl"
        step([$class: 'ArtifactArchiver', artifacts: 'HTTPRequest.jtl'])
      }
    } 
  }
}
