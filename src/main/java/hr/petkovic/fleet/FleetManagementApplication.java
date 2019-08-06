package hr.petkovic.fleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("hr.petkovic.fleet.repositories")
@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
//public class FleetManagementApplication {
	public class FleetManagementApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FleetManagementApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FleetManagementApplication.class, args);
	}

}
