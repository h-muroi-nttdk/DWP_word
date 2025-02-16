package com.example.todo.domain.service.word;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenAIClient {

	private static final String OPENAI_API_KEY = "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"; // APIキー
	private static final String API_URL = "https://api.openai.com/v1/embeddings";

	public static List<Float> getEmbedding(String inputText) throws Exception {
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost post = new HttpPost(API_URL);
			post.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);
			post.setHeader("Content-Type", "application/json");

			// JSONリクエストボディを設定
			String jsonBody = "{\"model\": \"text-embedding-3-small\", \"input\": \"" + inputText + "\"}";
			post.setEntity(new StringEntity(jsonBody));

			// リクエスト実行
			String response = EntityUtils.toString(client.execute(post).getEntity());

			// JSONレスポンスから埋め込みを取得
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);
			JsonNode embeddingNode = rootNode.path("data").get(0).path("embedding");

			List<Float> embedding = new ArrayList<>();
			for (int i = 0; i < embeddingNode.size(); i++) {
				embedding.add((float) embeddingNode.get(i).asDouble());
			}

			return embedding;
		}
	}

	public static void main(String[] args) throws Exception {
		String text = "こんにちは、ChatGPT!";
		List<Float> embedding = getEmbedding(text);
		System.out.println(embedding);
	}
}
