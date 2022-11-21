package uoscs.rescue.foodDeliveryWebService.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uoscs.rescue.foodDeliveryWebService.data.dao.StockDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;
import uoscs.rescue.foodDeliveryWebService.service.StockService;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    @Autowired
    private final StockDao stockDao;

    @Override
    public StockDto getStockData() {
        return stockDao.getStockDtoData();
    }

    @Override
    public void applyIngredientChangeForm(IngredientChangeForm changeForm) {
        stockDao.applyIngredientChanges(changeForm);
    }
}
