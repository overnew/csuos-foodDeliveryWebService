package uoscs.rescue.foodDeliveryWebService.data.dao;


import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;
import uoscs.rescue.foodDeliveryWebService.data.form.StockApplyForm;

public interface StockDao {

    void initStock();
    StockDto getStock();
    Stock getStockData();

    void applyIngredientChanges(StockApplyForm applyForm);
}
