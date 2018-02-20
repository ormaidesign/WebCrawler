package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.url.WebURL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebCrawlerApplicationTests {

	String[] testURLs = {"http://google.com","https://stackoverflow.com"}; 
	
	@Test
	public void whenURLSetGivenThenAllURLSReturnedInStringList() {
		CrawlerResponseHandlerService service = new CrawlerResponseHandlerImpl();
		assert(checkResponse(service.toListOfUrlStrings(getTestSet())));
	}

	private Set<WebURL> getTestSet()  {
		return new LinkedHashSet<>(Arrays.asList(urlFactory(testURLs[0]), urlFactory(testURLs[1])));
	}
	
	private List<String> getTestList()  {
		return new ArrayList<>(Arrays.asList(testURLs));
	}
	
	private WebURL urlFactory(String urlStr) {
		if (urlStr == null || urlStr.isEmpty()) {
			return null;
		}
		WebURL url = new WebURL();
		url.setURL(urlStr);
		return url;
	}
	
	private boolean checkResponse(List<String> resp) {
		return getTestList().containsAll(resp);
	}
}
