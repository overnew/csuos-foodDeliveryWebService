package uoscs.rescue.foodDeliveryWebService.service;

import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;

public interface StockService {
    StockDto getStockData();
    void applyIngredientChangeForm(IngredientChangeForm changeForm);
}
