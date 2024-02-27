pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                
                git branch: 'hedi' ,
                url: 'https://github.com/hamzaoui123-del/devops_back.git'
                
            }
        }
         stage('maven build') {
            steps {
              sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
                
            }
         }
         stage('SonarQube test') {
			steps {
				sh "mvn clean install"
				sh "mvn  sonar:sonar -Dsonar.projectKey=hedi_sonar -Dsonar.host.url=http://192.168.56.3:9000  -Dsonar.login=0b072f01a98784a3fe1865d1b3e0062d5deeeed9"

			}
			
		}
        /* stage('Nexus') {
			steps {				
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			        }
	                } 
         stage('docker') {
            steps {
                sh'''
                
                docker build -t stationski:1.0.0 .
                docker login -u "hediabdelli719" -p "123456789" docker.io
			  
        			
	 			docker tag stationski:1.0.0 hediabdelli719/hedi_repo:newversion
         		docker push hediabdelli719/hedi_repo:newversion
            '''
                
            }
         }*/
    }
}

