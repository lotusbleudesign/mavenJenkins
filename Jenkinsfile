pipeline{
    agent any

    post{
        always {
                echo 'Test sending mail..'
            }
       always {
           emailext body: 'A Test EMail : Ce Build $BUILD_NUMBER a échoué',
           recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test',  to:'lotus.b78@gmail.com',
       }

    }
        stages{


            stage("Init"){
                stepss{
                    echo 'Lancement en cours ...'
                }
            }

            stage("Git Checkout"){
                steps{
                     git branch:'main', credentialsId: '1a99507c-89d7-42a0-8495-67d6c25b0c6c', url:'https://github.com/lotusbleudesign/mavenJenkins.git'

                }
            }

            stage("Build"){
                tools {
                    maven 'maven'
                    jdk 'jdk'
                }
                steps{
                    sh 'mvn clean install'
                }
            }

            stage("Test"){
                tools {
                    maven 'maven'
                    jdk 'jdk'
                }
                steps{
                    sh 'mvn test'
                }
            }

            stage("Build DockerFile"){
                steps{
                   sh 'docker build -t lotusbleudesign/devops .'
                }
            }

            stage("Push DockerHub"){
                steps{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')])
                    {
                        sh 'docker login -u $USERNAME -p $PASSWORD'

                    }

                        sh 'docker push lotusbleudesign/devops'
                    }
            }

        }
}