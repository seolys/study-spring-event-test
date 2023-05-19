package seol.study.springevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void test() {
        orderService.createOrder();
    }
}