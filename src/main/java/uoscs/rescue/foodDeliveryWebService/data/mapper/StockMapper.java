package uoscs.rescue.foodDeliveryWebService.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;

@Named("StockMapper")
@Mapper(componentModel ="spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {IngredientMapper.class})
public interface StockMapper {
    StockDto toDto(Stock stock);
    Stock dtoToStock(StockDto stockDto);
}
