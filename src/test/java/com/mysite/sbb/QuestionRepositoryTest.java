package com.mysite.sbb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@ActiveProfiles("test")
@SpringBootTest
class QuestionRepositoryTest {


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

    @Test
    @DisplayName("findById")
    void t2() {
        Optional<Question> oq = questionRepository.findById(1);

        if(oq.isPresent()){
            Question q = oq.get();

            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }


    }

    @Test
    @DisplayName("findBySubject")
    void test3() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?").get();
        assertThat(q.getId()).isEqualTo(1);
    }

    @Test
    @DisplayName("findBySubjectAndContent")
    void test4() {
        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.").get();

    }

    @Test
    @DisplayName("findBySubjectLike")
    void t5() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
        assertThat(q.getSubject()).isEqualTo("sbb가 무엇인가요?");
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }
}
