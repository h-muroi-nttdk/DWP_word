package com.example.todo.domain.service.word;

import com.example.todo.domain.model.InputWord;
import com.example.todo.domain.model.ResultWord;

public interface WordService {
	ResultWord execute(InputWord inputword);

}
