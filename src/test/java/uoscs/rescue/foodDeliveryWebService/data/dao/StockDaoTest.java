package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@ComponentScan(basePackages = "uoscs.rescue.foodDeliveryWebService")
@SpringBootTest
class StockDaoTest {
    @Autowired
    private StockDao stockDao;

    @Autowired
    private EntityManager em;

    @Test
    void getInitStockData(){
        //when
        stockDao.initStock();

        StockDto stockDto = stockDao.getStock();

        //then
        System.out.println(stockDto);
        assertThat(stockDto.getBread()).isEqualTo(0);
    }

    @Test
    @Transactional
    void stockWithIngredient(){
        //given
        stockDao.initStock();
        Stock stock = stockDao.getStockData();

        Ingredient ingredient = Ingredient.builder().id("vm1234").name("감자").quantity(0).build();

        //when
        stock.setSteak(ingredient);

        stock = stockDao.getStockData();
        stock.getSteak().addQuantity(10);

        //then
        stock = stockDao.getStockData();
        System.out.println(stock);
        Assertions.assertThat(stock.getSteak().getQuantity()).isEqualTo(10);
    }

}