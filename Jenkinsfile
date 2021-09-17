pipeline {
    environment {
    registry = "registry-doopdip"
    registryCredential = 'dockerhub'
    projectName = "hello-jenkins"
    imageName = "$projectName"
    dockerImage = ''
    namespace = "doopdip"
    deployment = "hello-jenkins-api"
    majorbuild="0"
    minorbuild="0"
    buildversion = "$majorbuild.$minorbuild.${BUILD_NUMBER}"
    }
    agent any
    stages {
        stage('Unit Test') {
                agent {
                    docker {
                        image 'maven:3.6.3-openjdk-8'
                        args '-v /data/mvn/.m2:/root/.m2:z -u root'
                        reuseNode true
                    }
                }
                steps {
                    sh '''
                    pwd
                    mvn -s /root/.m2/settings.xml clean install
                    chown -hR 1000 target
                    chgrp -hR 1000 target
                    '''
                }
        }
    }

    post {
       always {
          deleteDir()
       }
    }
}
