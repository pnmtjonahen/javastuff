javastuff
=========

All kind of java stuff

* ClassPathViewer application to print the classpath of an EAR file according to application.xml beans module web module and manifest files
    TODO: rewrite to use jaxb instead of castor for xml parsing.

* SSL Client and Server application, does not work as it is missing certificates and so.

* securitymanager shows how to use an SecuriyManager

* jacoco-poc Shows how we can use JaCoCo test coverage to calculate coverage in a multi-module setup. 
The api contains no jUnit test. All tests are done by the impl artifact.
* jacoco-poc-IT Show Integration testing, test coverage with jacoco. At the moment it is not posible to get coverage while using embedded-glassfish. 
lassfish cannot be started using the jacoco agent by maven. As long this is the case only IT test that directly call the code can be measured.
* Resources:

 * http://www.lordofthejars.com/2012/07/jacoco-in-maven-multi-module-projects.html
 * http://blog.javabien.net/2012/11/23/combine-surefire-tests-and-failsafe-tests-coverage/
