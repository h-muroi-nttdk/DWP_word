package com.example.todo.app.todo;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.model.InputWord; // 修正箇所
import com.example.todo.domain.model.ResultWord;
import com.example.todo.domain.service.todo.TodoService;
import com.example.todo.domain.service.word.WordServiceImpl;

@Controller
@RequestMapping("word")
public class WordController {

	@Inject // (1)
	TodoService todoService;

	// メモリ上で単語データを保持するためのリスト
	private List<InputWord> inputwordList = new ArrayList<>(); // 修正箇所
	private List<ResultWord> resultwordList = new ArrayList<>();

	@ModelAttribute
	public InputWord setUpForm() {
		return new InputWord(); // 修正箇所
	}

	@GetMapping("list") // (3)
	public String list(Model model) {
		// 現在保存されている単語リストをビューに渡す
		model.addAttribute("inputwordList", inputwordList);
		model.addAttribute("resultwordList", resultwordList); // resultwordList も渡す
		return "word/word"; // (5)
	}

	@PostMapping("submit")
	public String submit(@ModelAttribute InputWord inputWord, Model model) { // 修正箇所
		// 以前の結果をクリア
		resultwordList.clear();
		// 入力された単語データをリストに追加
		inputwordList.add(inputWord);

		// 入力されたデータに基づいて結果を生成し、resultwordList に追加
		ResultWord resultWord = processInput(inputWord);
		resultwordList.add(resultWord);

		// リストに追加されたデータをビューに渡す
		model.addAttribute("inputwordList", inputwordList);
		model.addAttribute("resultwordList", resultwordList);

		return "word/word"; // (5)
	}

	// 入力データに基づいて結果を生成するメソッド
	private ResultWord processInput(InputWord inputWord) {
		// WordServiceImpl のインスタンスを作成
		WordServiceImpl wordService = new WordServiceImpl();
		ResultWord resultWord = null;

		try {
			// execute メソッドをインスタンスから呼び出し
			resultWord = wordService.execute(inputWord);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 結果を返す
		return resultWord;
	}

}
