package seol.study.springevent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public Order createOrder() {
        final Order order = new Order();
        final Order save = orderRepository.save(order);
        log.info("save.getId() = {}", save.getId());

        final CreateOrderEvent createOrderEvent = new CreateOrderEvent(save.getId());
        eventPublisher.publishEvent(createOrderEvent);
        log.info("createOrderEvent = {}", createOrderEvent);
        return save;
    }
}
