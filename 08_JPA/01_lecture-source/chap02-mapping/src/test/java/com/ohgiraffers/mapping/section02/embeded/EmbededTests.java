package com.ohgiraffers.mapping.section02.embeded;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class EmbededTests {

    @Autowired
    private BookRegistService bookRegistService;

    private static Stream<Arguments> getBook() {
        return Stream.of(
                Arguments.of(
                        "자바의정석",
                        "남궁성",
                        "도우출판",
                        LocalDate.now(),
                        30000,
                        0.1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getBook")
    void testCreateEmbeddedPriceOfBook(String bookTitle, String author, String publisher, LocalDate publishedDate,
                                       int regularPrice, double discountRate) {

        BookRegistRequestDTO bookInfo = new BookRegistRequestDTO(bookTitle,
                author, publisher, publishedDate, regularPrice, discountRate);

        Assertions.assertDoesNotThrow(
                () -> bookRegistService.registBook(bookInfo)
        );
    }


    // 음수로 넣을 경우
    private static Stream<Arguments> negativePrice() {
        return Stream.of(
                Arguments.of(
                        "자바의정석",
                        "남궁성",
                        "도우출판",
                        LocalDate.now(),
                        -30000,
                        0.1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("negativePrice")
    void testNegativePrice(String bookTitle, String author, String publisher, LocalDate publishedDate,
                           int regularPrice, double discountRate) {

        BookRegistRequestDTO bookInfo = new BookRegistRequestDTO(bookTitle,
                author, publisher, publishedDate, regularPrice, discountRate);

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> bookRegistService.registBook(bookInfo)
        );

        Assertions.assertEquals("가격은 음수일 수 없습니다.", exception.getMessage());

    }

    // 할인률이 음수일 경우 negativeDiscount
    private static Stream<Arguments> negativeDiscount() {
        return Stream.of(
                Arguments.of(
                        "자바의정석",
                        "남궁성",
                        "도우출판",
                        LocalDate.now(),
                        30000,
                        -0.1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("negativeDiscount")
    void testNegativeDiscount(String bookTitle, String author, String publisher, LocalDate publishedDate,
                              int regularPrice, double discountRate) {

        BookRegistRequestDTO bookInfo = new BookRegistRequestDTO(bookTitle,
                author, publisher, publishedDate, regularPrice, discountRate);

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> bookRegistService.registBook(bookInfo)
        );

    }


}