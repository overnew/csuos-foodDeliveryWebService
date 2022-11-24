package uoscs.rescue.foodDeliveryWebService.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
