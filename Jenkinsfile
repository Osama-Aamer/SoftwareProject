pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub-cred'
        DOCKERHUB_REPO = 'osamaaa1/softwareproject'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                // This part is now fixed and working!
                git branch: 'main', url: 'https://github.com/Osama-Aamer/SoftwareProject.git'
            }
        }

        stage('Build & Test') {
            steps {
                // We use 'verify' because it handles both tests and coverage data creation
                bat 'mvn clean verify'
            }
        }

        stage('Publish Results') {
            steps {
                // This captures your test results and coverage data for the Jenkins UI
                junit '**/target/surefire-reports/*.xml'
                recordCoverage(tools: [[parser: 'JACOCO', pattern: '**/jacoco.xml']])
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // This looks for your Dockerfile in the root folder
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}