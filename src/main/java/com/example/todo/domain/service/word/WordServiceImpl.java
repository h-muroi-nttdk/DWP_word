package com.example.todo.domain.service.word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.todo.domain.model.InputWord;
import com.example.todo.domain.model.ResultWord;

@Service
public class WordServiceImpl implements WordService {

	private static final Logger logger = LoggerFactory.getLogger(WordServiceImpl.class);

	@Override
	public ResultWord execute(InputWord inputWord) {
		try {
			// メイン単語と連想単語のベクトルを取得
			List<Float> mainWordEmbedding = OpenAIClient.getEmbedding(inputWord.getMainWord());
			logger.trace("Main Word Embedding: {}", mainWordEmbedding); // ベクトルをログに出力

			List<WordWithCorrelation> wordWithCorrelationList = new ArrayList<>();
			System.out.println(mainWordEmbedding);
			for (String otherWord : inputWord.getOtherWords()) {
				// 各連想単語のベクトルを取得
				List<Float> otherWordEmbedding = OpenAIClient.getEmbedding(otherWord);

				// コサイン類似度を計算して相関値として格納
				double correlation = cosineSimilarity(mainWordEmbedding, otherWordEmbedding);
				wordWithCorrelationList.add(new WordWithCorrelation(otherWord, correlation * 100)); // 相関値をパーセントにして格納
				System.out.println(otherWordEmbedding);
			}

			// 相関値が高い順に並べ替え
			wordWithCorrelationList.sort(Comparator.comparingDouble(WordWithCorrelation::getCorrelation).reversed());

			// 結果をResultWordに格納して返す
			List<String> sortedWords = new ArrayList<>();
			List<Float> sortedCorrelations = new ArrayList<>();
			for (WordWithCorrelation wordWithCorrelation : wordWithCorrelationList) {
				sortedWords.add(wordWithCorrelation.getWord());
				sortedCorrelations.add((float) wordWithCorrelation.getCorrelation());
			}

			return new ResultWord("1", inputWord.getMainWord(), sortedWords, sortedCorrelations);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultWord(); // エラーハンドリング
		}
	}

	// コサイン類似度計算メソッド（前述のものを使用）
	public static double cosineSimilarity(List<Float> vectorA, List<Float> vectorB) {
		double dotProduct = 0;
		double normA = 0;
		double normB = 0;

		for (int i = 0; i < vectorA.size(); i++) {
			dotProduct += vectorA.get(i) * vectorB.get(i);
			normA += Math.pow(vectorA.get(i), 2);
			normB += Math.pow(vectorB.get(i), 2);
		}

		normA = Math.sqrt(normA);
		normB = Math.sqrt(normB);

		return dotProduct / (normA * normB);
	}

	// 単語と相関値のペアを格納するクラス
	public static class WordWithCorrelation {
		private String word;
		private double correlation;

		public WordWithCorrelation(String word, double correlation) {
			this.word = word;
			this.correlation = correlation;
		}

		public String getWord() {
			return word;
		}

		public double getCorrelation() {
			return correlation;
		}
	}
}
