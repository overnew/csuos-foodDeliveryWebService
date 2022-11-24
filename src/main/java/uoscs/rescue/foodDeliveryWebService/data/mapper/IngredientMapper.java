package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import uoscs.rescue.foodDeliveryWebService.data.dto.IngredientDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;

@Named("IngredientMapper")
@Mapper(componentModel ="spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {

    @Named("ingredientToDto")
    IngredientDto toDto(Ingredient ingredient);

    Ingredient dtoToIngredient(IngredientDto ingredientDto);
}
