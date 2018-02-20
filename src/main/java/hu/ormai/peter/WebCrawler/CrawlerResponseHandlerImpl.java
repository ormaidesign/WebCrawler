package hu.ormai.peter.WebCrawler;

import edu.uci.ics.crawler4j.url.WebURL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class CrawlerResponseHandlerImpl implements CrawlerResponseHandlerService {
	 @Inject private Logger logger;
	
	public List<String> toListOfUrlStrings(Set<WebURL> urlSet) {
		if (urlSet == null)
			return null;
		if (urlSet.size() == 0)
			return new ArrayList<>();
		return Optional.ofNullable(
			urlSet.stream()
				.map(u->u.getURL())
				.filter(Objects::nonNull)
		)
		.orElse(Arrays.asList("").stream())
		.collect(Collectors.toList());
	}

}
