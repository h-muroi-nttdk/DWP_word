package com.example.todo.domain.model;

import java.util.List;

public class ResultWord {

	private String wordId; // 結果のwordId
	private String mainWord; // メイン単語
	private List<String> otherWords; // その他の単語
	private List<Float> correlationValues; // 各単語との相関値

	// デフォルトコンストラクタ（引数なし）
	public ResultWord() {
		// 必要に応じてフィールドの初期化を行うことができます（例：空のリスト）
		this.otherWords = null;
		this.correlationValues = null;
	}

	// 引数ありのコンストラクタ
	public ResultWord(String wordId, String mainWord, List<String> otherWords, List<Float> correlationValues2) {
		this.wordId = wordId;
		this.mainWord = mainWord;
		this.otherWords = otherWords;
		this.correlationValues = correlationValues2;
	}

	// ゲッターとセッター
	public String getWordId() {
		return wordId;
	}

	public void setWordId(String wordId) {
		this.wordId = wordId;
	}

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

	public List<Float> getCorrelationValues() {
		return correlationValues;
	}

	public void setCorrelationValues(List<Float> correlationValues) {
		this.correlationValues = correlationValues;
	}

	// toStringメソッド（任意）
	@Override
	public String toString() {
		return "ResultWord [wordId=" + wordId + ", mainWord=" + mainWord + ", otherWords=" + otherWords
				+ ", correlationValues=" + correlationValues + "]";
	}
}
