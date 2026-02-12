pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9' // Must match the name in Manage Jenkins > Tools
        jdk 'JDK 17'      // Must match the name in Manage Jenkins > Tools
    }
    
    stages {
        // We replace your old Checkout stage with the logic from the Canvas
        stage('Checkout') {
            steps {
                checkout scm
                script {
                    // Logic to set the Build Display Name to the Commit Message
                    // Note: Using 'bat' because your environment uses Windows commands
                    // '@echo off' ensures we only get the hash/message without the command itself
                    String commitHash = bat(script: '@echo off & git rev-parse --short HEAD', returnStdout: true).trim()
                    String commitMsg = bat(script: "@echo off & git log -1 --pretty=%B", returnStdout: true).trim()
                    
                    // This updates the Jenkins sidebar name from #9 to "#9 - Commit Message (hash)"
                    currentBuild.displayName = "#${env.BUILD_NUMBER} - ${commitMsg} (${commitHash})"
                }
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