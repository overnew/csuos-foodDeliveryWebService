package uoscs.rescue.foodDeliveryWebService.data.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uoscs.rescue.foodDeliveryWebService.data.dao.StockDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;
import uoscs.rescue.foodDeliveryWebService.data.form.StockApplyForm;
import uoscs.rescue.foodDeliveryWebService.data.mapper.StockMapper;
import uoscs.rescue.foodDeliveryWebService.data.repository.StockRepository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StockDaoImpl implements StockDao {

    @Autowired
    private final StockRepository stockRepository;
    @Autowired
    private final StockMapper stockMapper;

    private final String STOCK_ID = "STOCK_ID";

    @Override
    public void initStock() {   //임시로 모두 초기화됬을때 저장하는 기능
        stockRepository.save(
                Stock.builder()
                        .id(STOCK_ID)
                        .build());
    }

    public Stock getStockData(){
        Optional<Stock> stock = stockRepository.findById(STOCK_ID);

        return stock.get();
    }

    @Override
    public void applyIngredientChanges(StockApplyForm applyForm) {
        Stock stockData = getStockData();

        log.info("stockData: {}", stockData);
        if(applyForm.getSteak() != 0)
            stockData.getSteak().addQuantity(applyForm.getSteak());

        log.info("Stock changes Applied, {}", applyForm);
    }

    @Override
    public StockDto getStock(){
        return stockMapper.toDto(getStockData());
    }

}