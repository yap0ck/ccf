package be.yapock.ccf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcfApplication.class, args);
	}

}
