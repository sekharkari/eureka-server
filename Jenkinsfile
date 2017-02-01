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
   
   //CF push
   stage 'Deploy Dev'
   sh 'cf push vkari-eureka -p ./target/account-service-0.0.1-SNAPSHOT.jar  -n cfdemo-eureka -m 256M'
}