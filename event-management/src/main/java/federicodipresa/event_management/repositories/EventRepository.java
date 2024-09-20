package federicodipresa.event_management.repositories;

import federicodipresa.event_management.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    default List<Event> findByTitleContaining(String title) {
        return null;
    }
}

