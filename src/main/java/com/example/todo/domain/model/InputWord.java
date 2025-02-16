package com.example.todo.domain.model;

import java.util.ArrayList;
import java.util.List;

public class InputWord {
	private String wordId;

	private String mainWord;
	private List<String> otherWords;

	// 引数なしのコンストラクタ
	public InputWord() {
		this.otherWords = new ArrayList<>(); // 初期化
	}

	// 引数ありのコンストラクタ（必要に応じて追加）
	public InputWord(String wordId, String mainWord, List<String> otherWords) {
		this.setWordId(wordId);
		this.mainWord = mainWord;
		this.otherWords = otherWords;
	}

	// Getter と Setter を適切に追加
	public String getMainWord() {
		return mainWord;
	}

	public void setMainWord(String mainWord) {
		this.mainWord = mainWord;
	}

	public List<String> getOtherWords() {
		return otherWords;
	}

	public void setOtherWords(List<String> otherWords) {
		this.otherWords = otherWords;
	}

	public String getWordId() {
		return wordId;
	}

	public void setWordId(String wordId) {
		this.wordId = wordId;
	}
}
