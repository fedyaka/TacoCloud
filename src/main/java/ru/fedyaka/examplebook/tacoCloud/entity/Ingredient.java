package ru.fedyaka.examplebook.tacoCloud.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
public class Ingredient {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotNull
    private Type type;

    public enum Type{
        WRAP,SAUCE,PROTEIN,VEGGIES,CHEESE
    }
}
