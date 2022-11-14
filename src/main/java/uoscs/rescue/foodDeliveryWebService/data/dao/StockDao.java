package uoscs.rescue.foodDeliveryWebService.data.dao;


import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;

public interface StockDao {

    void initStock();
    StockDto getStock();
    Stock getStockData();
}
