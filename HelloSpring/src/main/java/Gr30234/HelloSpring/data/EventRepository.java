package Gr30234.HelloSpring.data;

import Gr30234.HelloSpring.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {


}
