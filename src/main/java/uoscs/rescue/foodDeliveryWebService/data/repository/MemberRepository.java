package uoscs.rescue.foodDeliveryWebService.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
