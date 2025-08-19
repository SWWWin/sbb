package com.mysite.sbb.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) throws DataFormatException {
        Optional<Question> oq = questionRepository.findById(id);

        if(oq.isPresent()) {
            return oq.get();
        } else {
            throw new DataFormatException("question not found");
        }
    }
}
