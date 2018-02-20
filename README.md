Inital test for Spring and webcrawler

PLEASE RUN 
$ mvn spring-boot:run

PLEASE TRY
http://localhost:8080/links?url=google.com

A Java-based rest service with one endpoint (/links). 
The endpoint must take as input a single http url and locate all the hyperlinks present on the page identified by the input url. 
The reponse is a JSON list of founded urls.
The service will be stateless, without database.
The project use Spring Boot, JUnit, crawler4j, Java 8, Java EE DI  

1. REST service to listen
2. Handle request, validate and get url from the request
3. Init the crawler  (later with the given parameters from the request, now with 1 level depth and 1 instance) and pass the url.
4. Run crawler 
5. Get urls from crawler in List<String>
6. Response for request convert List<String> to JSON 


TESTS
The code will use a lot of frameworks, the only logic is the convert Set<WebURL> to List<String>.

whenURLSetGivenThenAllURLSReturnedInStringList // No comment ;)



