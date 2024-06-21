package com.bellrajin.practice02.javaconfig;

import com.bellrajin.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean("board")
    public BoardDTO getBoard() {

        return new BoardDTO(2L, "스프링 수업 어떠세요?", "그래도 포기하지 않고 열심히 해볼거예요!", "미래의멋진개발자");
    }
}
