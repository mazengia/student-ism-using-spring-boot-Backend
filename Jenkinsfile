pipeline {
    environment {
    DATE = new Date().format('yy.M')
    TAG = "${DATE}.${BUILD_NUMBER}"
  }
  agent any
  stages {
    stage('Build Docker for Development') {
      when {
        branch 'develop'
      }
      steps {
        script {
          docker.build("10.1.12.73:5000/hr-workflow-front-end:${TAG}")
        }

      }
    }

    stage('Build Docker for Production') {
      when {
        branch 'main'
      }
      steps {
        script {
          docker.build("10.1.12.73:5000/hr-workflow-front-end:${TAG}")
        }

      }
    }

    stage('Push Docker Image to Local Registry') {
      steps {
        script {
          docker.withRegistry("http://10.1.12.73:5000"){
            docker.image("10.1.12.73:5000/hr-workflow-front-end:${TAG}").push()
            docker.image("10.1.12.73:5000/hr-workflow-front-end:${TAG}").push("latest")
          }
        }

      }
    }

    stage('Deliver for development') {
      when {
        branch 'develop'
      }
      steps {
        sshagent(credentials: ['ebdev']) {
          sh 'ssh -o StrictHostKeyChecking=no -l  ebdevuat 10.1.22.72      "docker stop hr-workflow-front-end | true;     docker rm hr-workflow-front-end | true;     docker run -p 5005:80  -d --name hr-workflow-front-end 10.1.12.73:5000/hr-workflow-front-end:${TAG}"'
        }

      }
    }

    stage('Deploy for production') {
      when {
        branch 'main'
      }
      steps {
        sshagent(credentials: ['enat-remedy-production']) {
          sh 'ssh -o StrictHostKeyChecking=no -l  administrator 10.1.12.70      "docker stop hr-workflow-front-end| true;     docker rm hr-workflow-front-end| true;     docker run -p 5005:80  -d --name hr-workflow-front-end 10.1.12.73:5000/hr-workflow-front-end:${TAG}"'
        }

      }
    }

  }
  post {
    always {
      cleanWs()
    }

  }
}
