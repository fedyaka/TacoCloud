package ru.fedyaka.examplebook.tacoCloud.сonverter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.fedyaka.examplebook.tacoCloud.repository.IngredientRepository;
import ru.fedyaka.examplebook.tacoCloud.entity.Ingredient;


//Просто конвертёр, нигде не используется :)
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
