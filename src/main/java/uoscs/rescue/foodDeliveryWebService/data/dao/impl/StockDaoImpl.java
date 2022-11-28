package uoscs.rescue.foodDeliveryWebService.data.dao.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uoscs.rescue.foodDeliveryWebService.data.dao.StockDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.StockDto;
import uoscs.rescue.foodDeliveryWebService.data.entity.Ingredient;
import uoscs.rescue.foodDeliveryWebService.data.entity.Stock;
import uoscs.rescue.foodDeliveryWebService.data.form.IngredientChangeForm;
import uoscs.rescue.foodDeliveryWebService.data.mapper.StockMapper;
import uoscs.rescue.foodDeliveryWebService.data.repository.IngredientRepository;
import uoscs.rescue.foodDeliveryWebService.data.repository.StockRepository;
import uoscs.rescue.foodDeliveryWebService.exception.StockValueException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StockDaoImpl implements StockDao {

    @Autowired
    private final StockRepository stockRepository;
    @Autowired
    private final IngredientRepository ingredientRepository;

    @Autowired
    private final StockMapper stockMapper;

    private final String STOCK_ID = "STOCK_ID";
    private final String ID_SUFFIX = "_ID";

    private final String STEAK = "STEAK";
    private final String BACON = "BACON";
    private final String EGG_SCRAMBLE = "EGG_SCRAMBLE";
    private final String BREAD = "BREAD";
    private final String BAGUETTE_BREAD = "BAGUETTE_BREAD";
    private final String SALAD = "SALAD";
    private final String COFFEE_CUP = "COFFEE_CUP";
    private final String COFFEE_PORT = "COFFEE_PORT";
    private final String WINE = "WINE";
    private final String CHAMPAGNE = "CHAMPAGNE";

    private String addIdSuffix(String name){return name + ID_SUFFIX;}

    @Override
    public void initStock() {   //최초 서버 실행시 초기화 기능
        Ingredient steak = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(STEAK)).name(STEAK).quantity(100).build());
        Ingredient bacon = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(BACON)).name(BACON).quantity(100).build());
        Ingredient eggScramble = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(EGG_SCRAMBLE)).name(EGG_SCRAMBLE).quantity(100).build());
        Ingredient bread = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(BREAD)).name(BREAD).quantity(100).build());
        Ingredient baguetteBread = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(BAGUETTE_BREAD)).name(BAGUETTE_BREAD).quantity(100).build());
        Ingredient salad = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(SALAD)).name(SALAD).quantity(100).build());
        Ingredient coffee_cup = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(COFFEE_CUP)).name(COFFEE_CUP).quantity(100).build());
        Ingredient coffee_port = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(COFFEE_PORT)).name(COFFEE_PORT).quantity(100).build());
        Ingredient wine = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(WINE)).name(WINE).quantity(100).build());
        Ingredient champagne = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(CHAMPAGNE)).name(CHAMPAGNE).quantity(100).build());


        Stock stock = Stock.builder()
                .id(STOCK_ID)
                .steak(steak)
                .bacon(bacon)
                .eggScramble(eggScramble)
                .bread(bread)
                .baguetteBread(baguetteBread)
                .salad(salad)
                .coffee_cup(coffee_cup)
                .coffee_port(coffee_port)
                .wine(wine)
                .champagne(champagne)
                .build();

        stockRepository.save(stock);
    }

    public Stock getStockData(){
        Optional<Stock> stock = stockRepository.findById(STOCK_ID);

        return stock.get();
    }

    @Override
    public void consumeByIngredientChangeForm(IngredientChangeForm changeForm){
        IngredientChangeForm consumeForm = IngredientChangeForm.builder()
                .bacon(changeForm.getBacon() * -1)
                .bread(changeForm.getBread() * -1)
                .baguetteBread(changeForm.getBaguetteBread() * -1)
                .champagne(changeForm.getChampagne() * -1)
                .coffee_cup(changeForm.getCoffee_cup() * -1)
                .coffee_port(changeForm.getCoffee_port() * -1)
                .eggScramble(changeForm.getEggScramble() * -1)
                .salad(changeForm.getSalad() * -1)
                .steak(changeForm.getSteak() * -1)
                .wine(changeForm.getWine() * -1)
                .build();

        applyIngredientChanges(consumeForm);
    }

    @Override
    public void applyIngredientChanges(IngredientChangeForm changeForm) {
        Stock stockData = getStockData();

        applyIngredientChangeToStock(changeForm, stockData);

        log.info("changed to, {}", stockData);
        log.info("Stock changes Applied, {}", changeForm);
    }


    private void applyIngredientChangeToStock(IngredientChangeForm applyForm, Stock stockData) {

        if(applyForm.getSteak() != 0 && checkIngredientValueNotMinus(applyForm.getSteak(), stockData.getSteak().getQuantity())){
            stockData.getSteak().addQuantity(applyForm.getSteak());
        }

        if(applyForm.getBacon() != 0 && checkIngredientValueNotMinus(applyForm.getBacon(), stockData.getBacon().getQuantity()))
            stockData.getBacon().addQuantity(applyForm.getBacon());

        if(applyForm.getBread() != 0  && checkIngredientValueNotMinus(applyForm.getBread(), stockData.getBread().getQuantity()))
            stockData.getBread().addQuantity(applyForm.getBread());

        if(applyForm.getBaguetteBread() != 0  && checkIngredientValueNotMinus(applyForm.getBaguetteBread(), stockData.getBaguetteBread().getQuantity()))
            stockData.getBaguetteBread().addQuantity(applyForm.getBaguetteBread());

        if(applyForm.getChampagne() != 0 && checkIngredientValueNotMinus(applyForm.getChampagne(), stockData.getChampagne().getQuantity()))
            stockData.getChampagne().addQuantity(applyForm.getChampagne());

        if(applyForm.getCoffee_cup() != 0 && checkIngredientValueNotMinus(applyForm.getCoffee_cup(), stockData.getCoffee_cup().getQuantity()))
            stockData.getCoffee_cup().addQuantity(applyForm.getCoffee_cup());

        if(applyForm.getCoffee_port() != 0 && checkIngredientValueNotMinus(applyForm.getCoffee_port(), stockData.getCoffee_port().getQuantity()))
            stockData.getCoffee_port().addQuantity(applyForm.getCoffee_port());

        if(applyForm.getSalad() != 0 && checkIngredientValueNotMinus(applyForm.getSalad(), stockData.getSalad().getQuantity()))
            stockData.getSalad().addQuantity(applyForm.getSalad());

        if(applyForm.getEggScramble() != 0 && checkIngredientValueNotMinus(applyForm.getEggScramble(), stockData.getEggScramble().getQuantity()))
            stockData.getEggScramble().addQuantity(applyForm.getEggScramble());

        if(applyForm.getWine() != 0 && checkIngredientValueNotMinus(applyForm.getWine(), stockData.getWine().getQuantity()))
            stockData.getWine().addQuantity(applyForm.getWine());

    }

    private boolean checkIngredientValueNotMinus(final int addedValue, final int originValue){
        //예외 터지면 transaction 취소로 모두 rollback

        if( originValue + addedValue <0 )
            throw new StockValueException("재료는 음수가 될 수 없음");

        return true;
    }

    @Override
    public StockDto getStockDtoData(){

        return stockMapper.toDto(getStockData());
    }

}
