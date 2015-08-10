AWS SQS and SNS Messaging with Spring Boot
------------------------------------------

Add when running locally to pick up Profile Credentials Provider - this will use the credentials in $USER_HOME/.aws/credentials
-Duse.profile.credentials=true

Postcode Queue and Notification URLs
------------------------------------
Send Queue Message:
http://localhost:8080/send?message=KJTEST33
http://localhost:8080/send?message=KJTEST

Send Notification Message:
http://localhost:8080/notification?message=KJNOTE

Deployment to Elasticbeanstalk as a Docker Image.
-------------------------------------------------

Needs to add the following Role Policies to the Elasticbeanstalk Image Role:
- AmazonSQSFullAccess
- AmazonSNSFullAccess

Example URLs after deployment to AWS
------------------------------------
http://postcodemessaging.elasticbeanstalk.com/health

http://postcodemessaging.elasticbeanstalk.com/send?message=KJTEST

http://postcodemessaging.elasticbeanstalk.com/notification?message=KJNOTE
