pipeline {
       agent any 

  stages{
        
    

 /*stage ('Junit + Mockito') {
     steps {
   sh 'mvn test'
  
}
}*/
	  stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
/*stage ('Sonar + jacOcO') {
steps {

sh 'mvn sonar:sonar -Dsonar.projectKey=tn.esprit.rh:achat -Dsonar.login=admin -Dsonar.password=admin1 -Dsonar.host.url=http://192.168.1.20:9000'
}
post {
				always {
					jacoco execPattern: 'target/jacoco.exec'
				}    
			} 
}
stage('Nexus') {
			steps {				
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			        }
	                } 
	  
	  stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t thaboutiikram/spring .'
	 			  sh 'docker tag thaboutiikram/spring thaboutiikram/spring:latest'
         			  sh 'docker push thaboutiikram/spring:latest'
         			}
     			  }
    		}*/
		
		 stage('Docker compose') {
       steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 10m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
     }
	 
		
	}
		
		post {
			
			  always {
           
	       dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
	       //publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'owasp-zap-report', reportFiles: 'zap_report.html', reportName: 'Owasp zap HTML Report', reportTitles: 'Owasp zap HTML Report', useWrapperFileDirectly: true])
	      
		  //   sendNotification currentBuild.result
           }
			
				success {

					echo "passed"
				}    
			       failure {
				       echo "failed"
				
		                }


}
}
