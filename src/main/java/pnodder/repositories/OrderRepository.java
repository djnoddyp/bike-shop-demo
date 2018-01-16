package pnodder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pnodder.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}