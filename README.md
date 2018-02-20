Inital test for Spring and webcrawler

A Java-based rest service with one endpoint (/links). 
The endpoint must take as input a single http url and locate all the hyperlinks present on the page identified by the input url. 
The reponse is a JSON list of founded urls.
The service will be stateless, without database. 

1. REST service to listen
2. Handle request, validate and get url from the request
3. Init the crawler  (later with the given parameters from the request, now with 1 level depth and 1 instance) and pass the url.
4. Run crawler 
5. Get urls from crawler in List<String>
6. Response for request convert List<String> to JSON 



