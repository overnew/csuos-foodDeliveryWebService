package uoscs.rescue.foodDeliveryWebService.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import uoscs.rescue.foodDeliveryWebService.data.entity.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);
}
