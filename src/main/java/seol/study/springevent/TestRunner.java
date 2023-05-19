package seol.study.springevent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TestRunner implements ApplicationRunner {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        final Order order = orderService.createOrder();
        final Order findOrder = orderRepository.findById(order.getId()).get();
        log.info("findOrder.getId() = {}", findOrder.getId());
    }
}
