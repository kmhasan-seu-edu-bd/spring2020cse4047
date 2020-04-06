package bd.edu.seu.springbootdemo;

import bd.edu.seu.springbootdemo.service.DummyDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootDemoApplication.class, args);
//		DummyDataService dummyDataService = run.getBean(DummyDataService.class);
//		dummyDataService.addDummyData();
	}

}
