package sit.int202.week7int202;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Week7int202Application {

	public static void main(String[] args) {
		SpringApplication.run(Week7int202Application.class, args);
	}

}
