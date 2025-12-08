pipeline {
    agent any

    environment {
        IMAGE_NAME = 'student-management'
    }

    stages {

        // 1️⃣ Checkout
        stage('Checkout') {
            steps {
                git branch: 'projet-dev', url: 'https://github.com/sahar-khiari/devops-sae1.git'
            }
        }

        // 2️⃣ Build Maven
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        // 3️⃣ Archive
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        // 4️⃣ SonarQube
        stage('MVN SONARQUBE') {
            steps {
                withSonarQubeEnv('sq1') {
                    sh 'mvn clean verify sonar:sonar -Dsonar.token=$SONAR_AUTH_TOKEN'
                }
            }
        }

        // 5️⃣ Build Docker image
        stage('Build Docker Image') {
            steps {
                script {
                    sh """
                    docker build -t  saharkhiari4/student-management:latest .
                    """
                }
            }
        }

        // 6️⃣ Push Docker Image
        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(
                        credentialsId: 'dockerhub-credentials',
                        usernameVariable: 'USERNAME',
                        passwordVariable: 'PASSWORD'
                    )]) {
                        sh """
                        echo "$PASSWORD" | docker login -u "$USERNAME" --password-stdin
                        docker push ${USERNAME}/${IMAGE_NAME}:latest


                        """
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build réussi et livrable généré !'
        }
        failure {
            echo 'Build échoué.'
        }
    }
}
