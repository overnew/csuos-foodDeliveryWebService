package uoscs.rescue.foodDeliveryWebService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dao.StockDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;
import uoscs.rescue.foodDeliveryWebService.data.enums.Authority;
import uoscs.rescue.foodDeliveryWebService.data.enums.Grade;
import uoscs.rescue.foodDeliveryWebService.data.repository.MemberRepository;
import uoscs.rescue.foodDeliveryWebService.data.repository.OrderRepository;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class FoodDeliveryWebServiceApplication implements CommandLineRunner {

	@Autowired private StockDao stockDao;
	@Autowired private MemberDao memberDao;

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryWebServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		stockDao.initStock();
		MemberDto generalMemberDto = MemberDto.builder().id("user1234").password("user1234").grade(Grade.GENERAL).authority(Authority.GENERAL).build();
		MemberDto adminMemberDto = MemberDto.builder().id("admin1234").password("admin1234").grade(Grade.GENERAL).authority(Authority.ADMIN).build();
		memberDao.save(generalMemberDto);
		memberDao.save(adminMemberDto);
		log.info("Server init complete");
	}
}
