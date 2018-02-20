package hu.ormai.peter.WebCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Named;

@Named("faster")
@JSCrawler
public class JSoupCrawler implements CrawlerService {
	private static Logger logger = Logger.getLogger(JSoupCrawler.class.getName());

	@Override
	public List<String> findLinks(String URL) {
		List<String> linksList = new ArrayList<>();
		if (!linksList.contains(URL)) {
			logger.info("LOADING: "+URL);
      try {
          Document document = Jsoup.connect(URL)
          		.timeout(500)
          		.followRedirects(true)
          		.ignoreHttpErrors(true)
          		.get();
          Elements linksOnPage = document.select("a[href]");
          for (Element page : linksOnPage) {    	
          	linksList.add(page.attr("abs:href"));
          	logger.info("ADD: "+page.attr("abs:href"));
          }
      } catch (IOException e) {
          logger.log(Level.WARNING,"For '" + URL + "': " + e.getMessage(), e);
      }
		}
		return linksList;
	}

}
