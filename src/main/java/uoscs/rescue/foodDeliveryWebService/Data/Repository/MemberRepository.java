package uoscs.rescue.foodDeliveryWebService.Data.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.Data.Entity.Member;

@Transactional
public interface MemberRepository extends JpaRepository<Member, String> {
}
