pipeline {
    agent any
    environment {
        DOCKER_REPOSITORY = 'marcinperka/gus-soap-integration'
        REGISTRY_CREDENTIAL = 'dockerhub_id'
        REGISTRY_URL = 'https://hub.docker.com'
    }
    def dockerImage
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                sh "./mvnw clean package -DskipTests"
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

        stage("Check Coverage") {
            steps {
                sh "./mvnw jacoco:report"
                publishHTML(target: [
                        reportDir  : 'build/reports/jacoco/test/html',
                        reportFiles: 'index.html',
                        reportName : "JaCoCo Report"
                ])
            }
        }

        stage('Install') {
            steps {
                dockerImage = docker.build("${DOCKER_REPOSITORY}:${BUILD_ID}")
            }
        }

        stage('Deploy') {
            steps {
                docker.withRegistry(REGISTRY_CREDENTIAL, REGISTRY_CREDENTIAL) {
                    dockerImage.push()
                }
            }
        }

        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_ID"
            }
        }
    }
}
