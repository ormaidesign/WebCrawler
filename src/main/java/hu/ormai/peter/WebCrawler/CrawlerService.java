package hu.ormai.peter.WebCrawler;

import java.util.List;

public interface CrawlerService {
	public List<String> findLinks(String URL);
}
