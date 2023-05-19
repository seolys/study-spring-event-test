package seol.study.springevent;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
