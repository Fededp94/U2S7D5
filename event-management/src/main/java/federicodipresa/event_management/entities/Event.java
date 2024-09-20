package federicodipresa.event_management.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private int availableSeats;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
}
