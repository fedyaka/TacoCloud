package ru.fedyaka.examplebook.tacoCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.fedyaka.examplebook.tacoCloud.entity.Ingredient;
import ru.fedyaka.examplebook.tacoCloud.entity.Ingredient.Type;
import ru.fedyaka.examplebook.tacoCloud.entity.Taco;
import ru.fedyaka.examplebook.tacoCloud.entity.TacoOrder;
import ru.fedyaka.examplebook.tacoCloud.repository.IngredientRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    IngredientRepository ingredientRepository;

    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientToModel(Model model) {

        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute("tacoOrder") //Добавляет в модель сессии объект TacoOrder, с которым в дальнейшем будет работа
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute("taco") //Добавляет в модель сессии объект Taco, с которым в дальнейшем будет работа
    public Taco taco() {
        return new Taco();
    }


    @GetMapping()
    public String showDesignForm() {
        return "design";
    }

    @PostMapping()
    public String processTaco(@Valid @ModelAttribute Taco taco, Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) { //ModelAttribute перед параметром TacoOrder указывает, что он должен использовать объект TacoOrder, который был помещен в модель методом order() с аннотацией @ModelAttribute
        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("processing taco: {}", taco);

        return "redirect:/orders/current";
    }


    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
