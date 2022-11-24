package uoscs.rescue.foodDeliveryWebService.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, String> {
}
