spring-rest-weather-info
========================

This project shows the temperature and a few other weather statistics of a group of selected cities.
The project has a rest service that uses spring rest and jackson as a json to java library.
The project uses maven, spring, jackson, log4j, junit for testing a few functionality.
The browser gets the information from the local server and the server gets the live data information 
from the openweathermap public weather service. The server cleans the data to a format that will
be easier to work by the client, the browser. I wanted to add hibernate to show examples of usage 
but was not sure how an orm library would be utilized.

To use the project from the browser on development, the url is:

	http://localhost:8080/weather-info/

To see the rest service, here are some examples:

	http://localhost:8080/weather-info/rest/city/Baltimore,md
	http://localhost:8080/weather-info/rest/city/Orlando,fl

Development
-----------

- clone or download the git project from github
- import the maven project on eclipse, use import maven projects.
- should work on netbeans too, but has not been tested with this ide.
- to run on development, a local tomcat should be setup on eclipse and right click on the project.
and click run on server, and select the tomcat server.
- to test unit tests right click on the unit tests and run as junit tests.
- to test on the browser go to the urls previously shown.
- to package the project use mvn package on eclipse, will generate a war file. 
note: when running mvn package, all tests have to pass, so the dev server should be running
because one test tests the dev rest server. Or the RestWeatherInfoTest unit test can be deleted. Or if the server is not running, run mvn package with the flag -Dmaven.test.skip=true.
- war file can be installed on a servlet container like tomcat or jboss, tested on tomcat.

openweathermap rest api
-----------------------

http://api.openweathermap.org/data/2.5/weather?q=Baltimore,md
http://openweathermap.org/weather-data#current
