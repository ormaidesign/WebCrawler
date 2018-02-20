package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.regex.Pattern;

public class LinkCrawler extends WebCrawler {
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
			+ "|png|mp3|mp4|zip|gz))$");
	

	/**
	 * This method receives two parameters. The first parameter is the page in which we have discovered this new url and the second parameter is the new url. 
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches()
				&& href.startsWith("http://www.ics.uci.edu/");
	}

	/**
	 * This function is called when a page is fetched and ready to be processed by the program.
	 */
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		System.out.println("URL: " + url);

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String text = htmlParseData.getText();
			String html = htmlParseData.getHtml();
			WebCrawlerCrawler.addLinks(htmlParseData.getOutgoingUrls());

			System.out.println("Text length: " + text.length());
			System.out.println("Html length: " + html.length());
			System.out.println("Number of outgoing links: " +  WebCrawlerCrawler.getLinks().size());
		}
	}
	
	
}
