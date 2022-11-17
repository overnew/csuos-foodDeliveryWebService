package uoscs.rescue.foodDeliveryWebService.data.dao;


import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;

public interface StockDao {

    void initStock();
    StockDto getStockDtoData();
    Stock getStockData();

    void applyIngredientChanges(IngredientChangeForm applyForm);
}
