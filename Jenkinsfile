pipeline {
    agent any
    tools {
        maven 'Maven 3.9' // Must match the name in Manage Jenkins > Tools
        jdk 'JDK 17'      // Must match the name in Manage Jenkins > Tools
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run Automation Tests') {
            steps {
                // Use 'bat' for Windows, 'sh' for Linux
                bat 'mvn clean test -Dheadless=true'
            }
        }
    }
}