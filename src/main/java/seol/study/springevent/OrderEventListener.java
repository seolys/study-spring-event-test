package seol.study.springevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderEventListener {

    //    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void eventHandler(final CreateOrderEvent event) {
        log.info("event = {}", event);
        throw new RuntimeException("야호!");
    }
}
