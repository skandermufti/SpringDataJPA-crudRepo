pipeline {
       agent any 

  stages{
        
    
stage ('Cleaning the project') {
     steps {
   echo 'cleaning project'
   echo 'Maven version'
   sh "mvn -version"
   sh "mvn help:effective-settings"
   sh "mvn clean install"

}
}
 stage ('Junit + Mockito') {
     steps {
   sh 'mvn test'
  
}
}
stage ('Sonar + jacOcO') {
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
		
	

}
}
