pipeline {
       agent any 
     tools {
           maven 'Maven2'
       }
    
  stages{
    stage ('Getting projects from git'){
        steps{
            echo 'Projet is downloading'
            git branch :'thabouti',
            url : 'https://github.com/skandermufti/SpringDataJPA-crudRepo.git',
                     credentialsId:"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";

        }
    }
    
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
stage ('Sonar') {
steps {

sh 'mvn sonar:sonar -Dsonar.projectKey=tn.esprit.rh:achat -Dsonar.login=admin -Dsonar.password=admin1 -Dsonar.host.url=http://192.168.1.20:9000'
}

}
stage('NEXUS'){
            steps{
                sh 'mvn deploy'
                echo 'nexus';
            }
        }

}
}
