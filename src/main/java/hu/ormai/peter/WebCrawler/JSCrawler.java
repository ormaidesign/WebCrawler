package hu.ormai.peter.WebCrawler;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE, METHOD})
@javax.inject.Qualifier
public @interface JSCrawler {}
