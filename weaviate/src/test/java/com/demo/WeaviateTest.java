package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
public class WeaviateTest {

    @Autowired
    private VectorStore vectorStore;

    @Test
    void vectorStoreTest() {
        Assert.notNull(vectorStore, "vectorStore is null");

        List<Document> documents = List.of(
                new Document("今天是个大晴天", Map.of("天气", "好")));

        try {
            // 添加文档到 Weaviate 向量存储
            vectorStore.add(documents);
            log.info("Documents added successfully");
        } catch (Exception e) {
            log.error("Failed to add documents: {}", e.getMessage(), e);
            // 打印详细的错误信息
            Throwable cause = e.getCause();
            while (cause != null) {
                log.error("Caused by: {}", cause.getMessage(), cause);
                cause = cause.getCause();
            }
        }

        // 检索与查询相似的文档
        List<Document> results = this.vectorStore.similaritySearch("今天天气怎么样");
        log.info("Results: {}", results);
    }
}
