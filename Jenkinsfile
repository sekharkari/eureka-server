node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'

   // Checkout code from repository
   checkout scm

   // Get the maven tool.
   // ** NOTE: This 'M3' maven tool must be configured
   // **       in the global configuration.
   def mvnHome = tool 'M3'

   // Mark the code build 'stage'....
   stage 'Build'
   // Run the maven build
   sh "${mvnHome}/bin/mvn clean install"
   archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
   stash includes: '**/target/*.jar', name: 'app' 
   
   stage 'Deploy to Cloudfoundry'
   //CF push
     wrap([$class: 'CloudFoundryCliBuildWrapper',
        cloudFoundryCliVersion: 'Cloud Foundry CLI (built-in)',
        apiEndpoint: 'https://api.ng.bluemix.net',
        skipSslValidation: true,
        credentialsId: 'cloud-foundry-elastic-runtime-credentials',
        organization: 'vkari',
        space: 'dev']) {
		unstash 'app'
        sh 'cf push vkari-eureka -p target/eureka-server-0.0.1-SNAPSHOT.jar  -n cfdemo-eureka -m 256M'
    }
   
}