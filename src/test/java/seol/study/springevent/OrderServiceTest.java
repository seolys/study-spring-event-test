package seol.study.springevent;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
//@Transactional
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void test() {
        final Order order = orderService.createOrder();
        entityManager.flush();
        entityManager.clear();
        final Order findOrder = orderRepository.findById(order.getId()).get();
        log.info("findOrder.getId() = {}", findOrder.getId());
        try {
            Thread.sleep(5000L);
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}