package assocication.section02.onetomany;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class OneToManyAssociationTests {

    @Autowired
    private OrderRegistService orderRegistService;

    private static Stream<Arguments> orderInfo() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new OrderMenuDTO(1, 10),
                                new OrderMenuDTO(2, 10)
                        )
                )
        );
    }

    @DisplayName("일대다 연관관계 객체 삽입 테스트")
    @ParameterizedTest
    @MethodSource("orderInfo")
    void testInsertOneToManuAssociationInstance(List<OrderMenuDTO> orderInfo) {

        Assertions.assertDoesNotThrow(
                () -> orderRegistService.registOrder(orderInfo)
        );
    }

}
