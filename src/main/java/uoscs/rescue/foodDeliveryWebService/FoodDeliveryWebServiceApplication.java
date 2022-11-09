package uoscs.rescue.foodDeliveryWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.repository.MemberRepository;
import uoscs.rescue.foodDeliveryWebService.data.repository.OrderRepository;

import java.util.Optional;

@SpringBootApplication
public class FoodDeliveryWebServiceApplication implements CommandLineRunner {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryWebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
