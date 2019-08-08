package xpadro.helloworldjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloWorldJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldJavaApplication.class, args);
	}

	@RestController
	public class HelloWorldController {

		@GetMapping("/hello")
		public String helloWorld() {
			return "Hello world!";
		}
	}

}
