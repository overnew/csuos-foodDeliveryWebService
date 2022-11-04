package uoscs.rescue.foodDeliveryWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uoscs.rescue.foodDeliveryWebService.Data.Entity.Member;
import uoscs.rescue.foodDeliveryWebService.Data.Repository.MemberRepository;

@SpringBootApplication
public class FoodDeliveryWebServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryWebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
