package com.social.cooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.elasticsearch.common.settings.Settings;

@Configuration
@EnableElasticsearchRepositories("com.social.cooking.recipes")
@PropertySource("classpath:elasticsearch.properties")
public class ElasticSearchConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public ElasticsearchOperations elasticSearchTemplate() {
		String pathHome = env.getProperty("spring.data.elasticsearch.properties.path.home");
	    Settings.Builder elasticSearchSetting = Settings.settingsBuilder()
	            .put("path.home", pathHome); 
		return new ElasticsearchTemplate(nodeBuilder().local(true).settings(elasticSearchSetting.build()).node().client());
	}

}
