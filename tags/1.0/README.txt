AppFuse Basic Spring MVC Archetype
--------------------------------------------------------------------------------
If you're reading this then you've created your new project using Maven and
appfuse-basic-spring.  You have only created the shell of an AppFuse Java EE
application.  The project object model (pom) is defined in the file pom.xml.
The application is ready to run as a web application. The pom.xml file is
pre-defined with Hibernate as a persistence model and Spring MVC as the web
framework.

To get started, please complete the following steps:

1. Download and install a MySQL 5.x database from
   http://dev.mysql.com/downloads/mysql/5.0.html#downloads.

2. Run "mvn jetty:run-war" and view the application at http://localhost:8080.

3. More information can be found at:

   http://appfuse.org/display/APF/QuickStart+Guide


==================================================
 	mvn archetype:create -DarchetypeGroupId=org.appfuse.archetypes -DarchetypeArtifactId=appfuse-basic-spring -DremoteRepositories=http://static.appfuse.org/releases -DarchetypeVersion=2.0.2 -DgroupId=com.mycompany.app -DartifactId=AppFuseSpring

	cd AppFuseSpring

	mvn appfuse:full-source

		(modifica il profilo per il db sul pom.xml)
	mvn -Phsqldb

	dopo aver fatto checkout eclipse nn trova la classe: org.aspectj.lang.JoinPoint
	se commenti le dipendenze:

		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>${aspectj.version}</version>
		</dependency>
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>${aspectj.version}</version>
		</dependency>

	salvi  ricompili, decommenti le dipendenze e ricompili, tutto dovrebbe essere ok.