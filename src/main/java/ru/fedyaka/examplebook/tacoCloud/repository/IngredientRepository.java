package ru.fedyaka.examplebook.tacoCloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedyaka.examplebook.tacoCloud.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
