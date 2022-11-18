package uoscs.rescue.foodDeliveryWebService.data.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;

import javax.persistence.EntityManager;

@ComponentScan(basePackages = "uoscs.rescue.foodDeliveryWebService")
@SpringBootTest
class StockDaoTest {
    @Autowired
    private StockDao stockDao;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void consumeStockByOrderData(){
        //given
        //stockDao.initStock();
        Stock stock = stockDao.getStockData();

        IngredientChangeForm applyForm = IngredientChangeForm.builder().steak(10).bread(10).build();
        IngredientChangeForm consumeForm = IngredientChangeForm.builder().steak(5).bread(10).build();

        //when
        stockDao.applyIngredientChanges(applyForm);
        stockDao.consumeByIngredientChangeForm(consumeForm);

        //then
        stock = stockDao.getStockData();
        System.out.println(stock.getSteak());
        Assertions.assertThat(stock.getSteak().getQuantity()).isEqualTo(5);
        Assertions.assertThat(stock.getBread().getQuantity()).isEqualTo(0);
    }

    @Test
    @Transactional
    void applyStockChange(){
        //given
        //stockDao.initStock();
        Stock stock = stockDao.getStockData();

        Ingredient ingredientSteak = Ingredient.builder().id("vm1234").name("스테끼").quantity(0).build();
        Ingredient ingredientBread = Ingredient.builder().id("vms1234").name("빵야").quantity(0).build();

        IngredientChangeForm applyForm = IngredientChangeForm.builder().steak(10).bread(-10).build();

        //when
        stock.setSteak(ingredientSteak);
        stock.setBread(ingredientBread);

        stockDao.applyIngredientChanges(applyForm);

        //then
        stock = stockDao.getStockData();
        System.out.println(stock.getSteak());
        Assertions.assertThat(stock.getSteak().getQuantity()).isEqualTo(10);
        Assertions.assertThat(stock.getBread().getQuantity()).isEqualTo(-10);
    }

    @Test
    @Transactional
    void stockWithIngredient(){
        //given
        //stockDao.initStock();
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