package com.mysite.sbb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ActiveProfiles("test")
@SpringBootTest
class SbbApplicationTests {


    @Autowired //의존성 주입 new 해 주는 거임
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("findAll")
    void t1() {
        List<Question> questionList = questionRepository.findAll();

        assertEquals(2, questionList.size());

        Question question = questionList.get(0);
        assertEquals("sbb가 무엇인가요?", question.getSubject());
    }

}
