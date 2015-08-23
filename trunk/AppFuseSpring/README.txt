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

modificare il pom.xml:
...
		<profile>
			<id>hsqldb</id>
			<properties>
				<dbunit.dataTypeFactoryName>org.dbunit.ext.hsqldb.HsqldbDataTypeFactory</dbunit.dataTypeFactoryName>
				<hibernate.dialect>org.hibernate.dialect.HSQLDialect</hibernate.dialect>
				<jdbc.groupId>hsqldb</jdbc.groupId>
				<jdbc.artifactId>hsqldb</jdbc.artifactId>
				<jdbc.version>1.8.0.7</jdbc.version>
				<jdbc.driverClassName>org.hsqldb.jdbcDriver</jdbc.driverClassName>
				<!-- RIGA DA COMMENTARE
					<jdbc.url><![CDATA[jdbc:hsqldb:${java.io.tmpdir}/AppFuseSpring;shutdown=true]]></jdbc.url>

				RIGA DA AGGIUNGERE:
				-->
				<jdbc.url><![CDATA[jdbc:hsqldb:hsql://localhost]]></jdbc.url>
				<jdbc.username>sa</jdbc.username>
				<jdbc.password></jdbc.password>
			</properties>
		</profile>
...

	mvn -Phsqldb








===  zxmax googlecode:           ===================================================
Dopo aver fatto checkout del mio progetto, eclipse non trova la classe: org.aspectj.lang.JoinPoint
	se, nel pom.xml, commenti le dipendenze:

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

	salvi e  ricompili,  decommenti risalvi e ricompili. Tutto dovrebbe essere ok.




====================================================================
###	HSQLDB   #######################################################
====================================================================
jdbc.properties per HSQLDB
jdbc.driverClassName=${jdbc.driverClassName}
jdbc.url=jdbc:hsqldb:hsql://localhost
jdbc.username=sa
jdbc.password=
hibernate.dialect=org.hibernate.dialect.HSQLDialect

hibernate.connection.username=sa
hibernate.connection.password=
hibernate.connection.url=jdbc:hsqldb:hsql://localhost
hibernate.connection.driver_class=org.hsqldb.jdbcDriver

--------
Stringhe di connessione al db hsqldb:
SERVER:
jdbc:hsqldb:hsql://localhost

FILE:
jdbc:hsqldb:file:./db/AppFuseSpring;shutdown=true
--------



Nella cartella hsqldb ci sono i file .bat per far eseguire hsqldb come server.

ISTANZIARE HSQLDB SERVER:
Controllare che i valore del file jdbc.properties corrispondano ad una connessione verso hsqldb.
Ricordarsi di lanciare i target maven col profilo: "hsqldb",    es: mvn  package -phsqldb



====================================================================
### TOMCAT 5.5.27     ###############################################
====================================================================
copiare il file .war nella cartella di deploy del web/application server

es:
%tomcat_home%/webapps

far partire il web/application server.

Nella cartella Tomcat-5 c'è un file per eseguire Tomcat in modalità debug.




