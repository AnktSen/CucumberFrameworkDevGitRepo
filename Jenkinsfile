pipeline {
    agent any    
    
    tools {
        maven 'Maven 3.9'
        jdk 'JDK 17' 
    }
    
    stages {
        stage('Checkout & Setup Name') {
            steps {
                // 1. Pull the code
                checkout scm
                
                script {
                    try {
                        // 2. Fetch Git info using '@' to suppress command echoing in the output
                        // We use .trim() to remove any trailing newlines
                        String commitHash = bat(script: "@echo off & git rev-parse --short HEAD", returnStdout: true).trim()
                        String commitMsg = bat(script: "@echo off & git log -1 --pretty=%s", returnStdout: true).trim()
                        
                        // 3. Set the display name
                        // .take(30) ensures the message isn't so long it breaks the UI
                        String shortMsg = commitMsg.take(50)
                        currentBuild.displayName = "#${env.BUILD_NUMBER} - ${shortMsg} (${commitHash})"
                        
                        echo "Successfully updated build name to: ${currentBuild.displayName}"
                    } catch (Exception e) {
                        // If Git fails, we still want the build to try to run tests
                        echo "Could not update build name. Error: ${e.message}"
                        currentBuild.displayName = "#${env.BUILD_NUMBER} - Git Info Error"
                    }
                }
            }
        }        
        
        stage('Run Automation Tests') {
            steps {
                // Ensure headless is true for Jenkins/Server environments
                bat 'mvn clean test -Dheadless=true'
            }
        }
    }
    
    post {
        always {
            // This will help you find the reports in Jenkins after the run
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/*.html', allowEmptyArchive: true
        }
    }
}