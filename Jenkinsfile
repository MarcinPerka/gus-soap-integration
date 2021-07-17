pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/MarcinPerka/gus-soap-integration.git'
            }
        }
        
        stage('Compile') {
            steps {
                sh "./mvnw clean compile"
            }

        }

        stage('Test') {
            steps {
                sh "./mvnw test"
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh "./mvnw package"
            }

            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
