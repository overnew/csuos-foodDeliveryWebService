package uoscs.rescue.foodDeliveryWebService.data.dao;


import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;

public interface StockDao {

    void initStock();
    StockDto getStock();
}
