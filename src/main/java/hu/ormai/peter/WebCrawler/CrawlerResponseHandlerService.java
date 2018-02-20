package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.url.WebURL;

import java.util.List;
import java.util.Set;

public interface CrawlerResponseHandlerService {
	public List<String> toListOfUrlStrings(Set<WebURL> urlSet);
}
