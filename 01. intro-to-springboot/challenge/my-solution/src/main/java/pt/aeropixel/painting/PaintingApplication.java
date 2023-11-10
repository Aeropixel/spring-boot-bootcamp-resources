package pt.aeropixel.painting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaintingApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");
		System.out.println("Goodbye");
		SpringApplication.run(PaintingApplication.class, args);
	}

}
