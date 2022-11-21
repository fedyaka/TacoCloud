package ru.fedyaka.examplebook.tacoCloud.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fedyaka.examplebook.tacoCloud.entity.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
