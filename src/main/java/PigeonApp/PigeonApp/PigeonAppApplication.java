package PigeonApp.PigeonApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PigeonAppApplication {

	public static void main(String[] args) {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		Dotenv dotenv = Dotenv.load();

		System.setProperty("SPRING_DATA_MONGODB_URI", dotenv.get("SPRING_DATA_MONGODB_URI"));

		SpringApplication.run(PigeonAppApplication.class, args);
	}

}
