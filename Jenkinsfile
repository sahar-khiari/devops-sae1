pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'projet-dev', url: 'https://github.com/sahar-khiari/devops-sae1.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('MVN SONARQUBE') {
            steps {
                withSonarQubeEnv('sq1') {
                    sh 'mvn clean verify sonar:sonar -Dsonar.token=$SONAR_AUTH_TOKEN'
                }
            }
        }
    } // <- fermeture du bloc stages

    post {
        success {
            echo 'Build réussi et livrable généré !'
        }
        failure {
            echo 'Build échoué.'
        }
    }
}
