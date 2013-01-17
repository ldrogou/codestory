#  Hibernate and tomcat clickstart

This clickstart sets up a database, build service, repository and a basic Java servlet and Hibernate ORM application.
All built by maven. 

<a href="https://grandcentral.cloudbees.com/?CB_clickstart=https://raw.github.com/CloudBees-community/maven_template/master/clickstart.json"><img src="https://d3ko533tu1ozfq.cloudfront.net/clickstart/deployInstantly_white.png"/></a>

Launch this clickstart and glory could be yours too ! Use it as a building block if you like.

You can launch this on Cloudbees via a clickstart automatically, or follow the instructions below. 



# Deploying manually: 


## Note before deploying this on JBoss 7:

There are configuration changes to do in the following file, comments will indicate which lines to change and how.

    src/main/webapp/WEB-INF/web.xml

## To build and deploy this on CloudBees, follow those steps:

Create application:

    bees app:create MYAPP_ID

Create database:

    bees db:create -u DB_USER -p DB_PASSWORD DBNAME

Bind database as datasource:

    bees app:bind -db DBNAME -a MYAPP_ID -as ExampleDS

Create a new Maven project in Jenkins, changing the following:

* Add this git repository (or yours, with this code) on Jenkins
* Also check "Deploy to CloudBees" with those parameters:

        Applications: First Match
        Application Id: MYAPP_ID
        Filename Pattern: target/*.war

* Optionally change the application container to Java EE, if you wish to deploy on JBoss. 

## To build this locally:

In the maven_template directory, open a command line, and invoke maven by typing "mvn package" to build the war file, then deploy it on cloudbees typing:

    bees app:deploy -t tomcat -a MYAPP_ID target/*.war

Or, for JBoss:

    bees app:deploy -t jboss -a MYAPP_ID target/*.war

## To deploy this locally:

Make sure you have a MySQL database bound to java:comp/env/jdbc/ExampleDS, and then deploy in your favorite container.
