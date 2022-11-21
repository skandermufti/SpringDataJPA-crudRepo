pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }


    stages {



        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/oussemanedri']],
			extensions: [],
			userRemoteConfigs: [[url: 'https://github.com/skandermufti/SpringDataJPA-crudRepo.git']]])
            }
        }



        stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  "
            }
        }



        stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }



         stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }



        stage('Code Quality Check via SonarQube') {
            steps{

             		sh "  mvn sonar:sonar -Dsonar.projectKey=oussemadevops -Dsonar.host.url=http://192.168.1.105:9000 -Dsonar.login=8951d24c2cd0244c5e33b781bf35647cc7581d95"

            }
        }


        stage('Publish to Nexus') {
            steps {


  sh 'mvn deploy'


            }
        }

stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t oussamanedri/achat:latest .'
                          }
                      }
                  }

                  stage('login dockerhub') {
                                        steps {
                                      sh 'docker login -u oussamanedri -p oussDockerhub99'
                                            }
		  }
	    
	                      stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push oussamanedri/achat:latest'
                                            }
		  }

		   

		   stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh 'docker-compose up -d'
                                    }
                                }
                            }

	    



     
}

	    
        post {

        always {
            cleanWs()
        }
		
		
		
		post {
        success {
             mail to: "oussama.nedri@esprit.tn",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "oussama.nedri@esprit.tn",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }
		
		
		
		
		
		
    }

    
	
}
       
