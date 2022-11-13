package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uoscs.rescue.foodDeliveryWebService.data.dao.StockDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class StockDaoTest {
    @Autowired
    private StockDao stockDao;

    @Test
    void getInitStockData(){
        //when
        stockDao.initStock();

        StockDto stockDto = stockDao.getStock();

        //then
        System.out.println(stockDto);
        assertThat(stockDto.getBread()).isEqualTo(0);
    }

}