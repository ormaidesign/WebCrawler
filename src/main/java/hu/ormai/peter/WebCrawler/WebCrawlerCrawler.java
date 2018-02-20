package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.url.WebURL;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Named;

@Named("slow")
@WCCrawler
public class WebCrawlerCrawler implements CrawlerService {
	private static Logger logger = Logger.getLogger(WebCrawlerCrawler.class.getName());
	
	private static Set<WebURL> links = null;
	
	@Override
	public List<String> findLinks(String URL) {
		try (CrawleController crawler = new CrawleController(URL)) {
			crawler.start();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		CrawlerResponseHandlerService service = new CrawlerResponseHandlerImpl();
		return service.toListOfUrlStrings(links);
	}
	
	public static Set<WebURL> getLinks() {
		if (links == null) {
			links = new LinkedHashSet<>();
		}
		return links;
	}
	
	public static synchronized void addLinks(Set<WebURL> urls) {
		if (links == null) {
			links = new LinkedHashSet<>();
		}
		links.addAll(urls);
	}
	
	public static synchronized void addLink(WebURL url) {
		if (links == null) {
			links = new LinkedHashSet<>();
		}
		links.add(url);
	}

}
