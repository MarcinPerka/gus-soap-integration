pipeline {
    agent any
    environment {
        DOCKER_REPOSITORY = 'marcinperka/gus-soap-integration'
        REGISTRY_CREDENTIAL = 'dockerhub_id'
        REGISTRY_URL = 'https://hub.docker.com'
        dockerImage = ''
    }
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
            }
            post {
                always {
                    // Requires HTMLPublisher plugin in Jenkins instance.
                    publishHTML(target: [
                            reportDir  : 'target/site/jacoco',
                            reportFiles: 'index.html',
                            reportName : 'Coverage_Report_Unit_Test'
                    ])
                }
            }
        }

        stage('Install') {
            steps {
                script {
                    // Requires Docker Plugin in Jenkins instance.
                    dockerImage = docker.build("${DOCKER_REPOSITORY}:${BUILD_ID}")
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    docker.withRegistry(REGISTRY_CREDENTIAL, REGISTRY_CREDENTIAL) {
                        dockerImage.push()
                    }
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
