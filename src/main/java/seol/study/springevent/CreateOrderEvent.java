package seol.study.springevent;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderEvent {
    private final Long id;
}
