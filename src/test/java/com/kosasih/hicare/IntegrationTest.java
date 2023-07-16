package com.kosasih.hicare;

import com.kosasih.hicare.HicareApp;
import com.kosasih.hicare.config.AsyncSyncConfiguration;
import com.kosasih.hicare.config.EmbeddedElasticsearch;
import com.kosasih.hicare.config.EmbeddedKafka;
import com.kosasih.hicare.config.EmbeddedSQL;
import com.kosasih.hicare.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { HicareApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
