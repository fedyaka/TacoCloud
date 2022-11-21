package ru.fedyaka.examplebook.tacoCloud.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.fedyaka.examplebook.tacoCloud.entity.Taco;


public interface TacoRepository extends CrudRepository<Taco, Long> {

    Iterable<Taco> findAll(Pageable page);
}
