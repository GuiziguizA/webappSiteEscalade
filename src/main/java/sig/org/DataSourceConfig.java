package sig.org;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties
public class DataSourceConfig {
	
	
	@Bean
	public DataSource getDataSource() { 
	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create(); 
	    dataSourceBuilder.username("SA"); 
	    dataSourceBuilder.password(""); 
	    return dataSourceBuilder.build(); 

}
}