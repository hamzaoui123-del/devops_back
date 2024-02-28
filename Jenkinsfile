pipeline {
    agent any

    stages {
        stage('Git clone') {
            steps {
                
                git branch: 'sassiyasser' ,
                url: 'https://github.com/hamzaoui123-del/devops_back.git'
                
            }
        }
         stage('build JAR') {
            steps {
              sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
                
            }
         }
         
 //          stage('SonarQube test') {
	// steps {
 // 				sh "mvn clean install"
 // 				sh "mvn  sonar:sonar -Dsonar.projectKey=sassi_sonar -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=5ed0207fe9852601330dd9ca92709a21790ce459"

 // 			}
			
	// 	}
		stage('Nexus') {
			steps {				
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			        }
	                }
	                
	                stage('docker build and push') {
            steps {
                sh'''
                
                docker build -t stationski:1.0.0 .
                docker login -u "yasser22" -p "123456789" docker.io
			  
        			
	 			docker tag stationski:1.0.0 yasser22/yasserrepo:newversion
         		docker push yasser22/yasserrepo:newversion
            '''
	    }
          }

         stage('Docker compose') {
       steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 7m '
               sh 'docker rm -f spring mysql '
           }
         )
       }
     }
        
        
    }
}
