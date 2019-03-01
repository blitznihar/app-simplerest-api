pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Building APP'
          }
        }
        stage('Test') {
          steps {
            echo 'Testing API'
          }
        }
        stage('Scanning APP') {
          steps {
            echo 'Scanning API'
          }
        }
      }
    }
    stage('archiving api Artifacts') {
      steps {
        echo 'archiving api Artifacts'
        sleep 5
        timestamps() {
          echo 'Timestamps'
        }

      }
    }
    stage('Approval') {
      steps {
        input(message: 'Approve to Deploy in Production', id: '1', ok: 'Approve')
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying the API'
      }
    }
  }
}