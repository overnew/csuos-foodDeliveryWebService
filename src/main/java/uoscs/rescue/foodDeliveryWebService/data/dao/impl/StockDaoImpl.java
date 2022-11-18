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
    private final String SALAD = "SALAD";
    private final String COFFEE = "COFFEE";
    private final String WINE = "WINE";
    private final String CHAMPAGNE = "CHAMPAGNE";

    private String addIdSuffix(String name){return name + ID_SUFFIX;}

    @Override
    public void initStock() {   //최초 서버 실행시 초기화 기능
        Ingredient steak = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(STEAK)).name(STEAK).quantity(0).build());
        Ingredient bacon = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(BACON)).name(BACON).quantity(0).build());
        Ingredient eggScramble = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(EGG_SCRAMBLE)).name(EGG_SCRAMBLE).quantity(0).build());
        Ingredient bread = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(BREAD)).name(BREAD).quantity(0).build());
        Ingredient salad = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(SALAD)).name(SALAD).quantity(0).build());
        Ingredient coffee = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(COFFEE)).name(COFFEE).quantity(0).build());
        Ingredient wine = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(WINE)).name(WINE).quantity(0).build());
        Ingredient champagne = ingredientRepository.save(Ingredient.builder().id(addIdSuffix(CHAMPAGNE)).name(CHAMPAGNE).quantity(0).build());


        Stock stock = Stock.builder()
                .id(STOCK_ID)
                .steak(steak)
                .bacon(bacon)
                .eggScramble(eggScramble)
                .bread(bread)
                .salad(salad)
                .coffee(coffee)
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
                .champagne(changeForm.getChampagne() * -1)
                .coffee(changeForm.getCoffee() * -1)
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

        log.info("Stock changes Applied, {}", changeForm);
    }

    private void applyIngredientChangeToStock(IngredientChangeForm applyForm, Stock stockData) {

        if(applyForm.getSteak() != 0 && checkIngredientValueNotMinus(applyForm.getSteak(), stockData.getSteak().getQuantity()))
            stockData.getSteak().addQuantity(applyForm.getSteak());

        if(applyForm.getBacon() != 0 && checkIngredientValueNotMinus(applyForm.getBacon(), stockData.getBacon().getQuantity()))
            stockData.getBacon().addQuantity(applyForm.getBacon());

        if(applyForm.getBread() != 0  && checkIngredientValueNotMinus(applyForm.getBread(), stockData.getBread().getQuantity()))
            stockData.getBread().addQuantity(applyForm.getBread());

        if(applyForm.getChampagne() != 0 && checkIngredientValueNotMinus(applyForm.getChampagne(), stockData.getChampagne().getQuantity()))
            stockData.getChampagne().addQuantity(applyForm.getChampagne());

        if(applyForm.getCoffee() != 0 && checkIngredientValueNotMinus(applyForm.getCoffee(), stockData.getCoffee().getQuantity()))
            stockData.getCoffee().addQuantity(applyForm.getCoffee());

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
