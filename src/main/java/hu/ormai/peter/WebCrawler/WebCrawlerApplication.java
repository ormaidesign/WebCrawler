package hu.ormai.peter.WebCrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class WebCrawlerApplication {
	private Logger logger = Logger.getLogger(WebCrawlerApplication.class.getName());
	
	@Inject private @JSCrawler CrawlerService service;

	@RequestMapping("/links")
	List<String> links(@RequestParam(value="url", required=false, defaultValue="http://ormai.hu") String url) {
		url = url.matches("^http[s]{0,1}://.*") ? url : "http://"+url;
		return service.findLinks(url);	
  }
	
	public static void main(String[] args) {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}
	
	
}