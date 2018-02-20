package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.url.WebURL;
import org.hibernate.validator.internal.constraintvalidators.hv.URLValidator;
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

	@Test
	public void whenURLSetGivenThenAllURLSReturnedInStringList() {
		CrawlerResponseHandlerService service = new CrawlerResponseHandlerImpl();
		assert(checkResponse(service.toListOfUrlStrings(getTestSet())));
	}

	private Set<WebURL> getTestSet()  {
		return new LinkedHashSet<>(Arrays.asList(urlFactory("http://google.com"), urlFactory("https://stackoverflow.com")));
	}
	
	private List<String> getTestList()  {
		return new ArrayList<>(Arrays.asList("http://google.com","https://stackoverflow.com"));
	}
	
	private WebURL urlFactory(String urlStr) {
		URLValidator urlv = new URLValidator();
		if (urlStr == null || urlStr.isEmpty() || !urlv.isValid(urlStr, null)) {
			return null;
		}
		WebURL url = new WebURL();
		url.setURL(urlStr);
		return url;
	}
	
	private boolean checkResponse(List<String> resp) {
		return getTestList().stream().filter(s-> resp.contains(s)).count() == 0;
	}
}
