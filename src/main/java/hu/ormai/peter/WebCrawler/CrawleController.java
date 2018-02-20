package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CrawleController implements AutoCloseable {
	private static Logger logger = Logger.getLogger(CrawleController.class.getName());
	
	private static final String DIR = "/tmp/crawler";
	private static final int INSTANCES = 1;
	
	private CrawlController controller;
	
	public CrawleController(String seed) {
		String crawlStorageFolder = DIR;

    CrawlConfig config = new CrawlConfig();
    config.setCrawlStorageFolder(crawlStorageFolder);

    /*
     * Instantiate the controller for this crawl.
     */
    PageFetcher pageFetcher = new PageFetcher(config);
    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
    
		try {
			controller = new CrawlController(config, pageFetcher, robotstxtServer);
			/*
	     * For each crawl, you need to add some seed urls. These are the first
	     * URLs that are fetched and then the crawler starts following links
	     * which are found in these pages
	     */
	    controller.addSeed(seed);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Contoller init error: "+e, e);
		}
	}
	
	public void start() {
    /*
     * Start the crawl. This is a blocking operation, meaning that your code
     * will reach the line after this only when crawling is finished.
     */
    controller.start(LinkCrawler.class, INSTANCES);
	}
	
	@Override
	public void close() throws Exception {
		if (controller == null || controller.isShuttingDown()) {
			return;
		}
		controller.shutdown();
	}
	
}
