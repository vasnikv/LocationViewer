package my.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationViewerApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	private void testJpaMethods(){
//		System.out.println("222222222222222222222222222");
//	}

}
