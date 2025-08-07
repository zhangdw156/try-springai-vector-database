package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

;

@Slf4j
@SpringBootTest
public class VectorStoreTest {

    @Autowired
    private VectorStore vectorStore;

    @Autowired
    private EmbeddingModel embeddingModel;

    @Test
    public void connectionTest() {
        Assert.notNull(vectorStore, "vectorStore is null");
        log.info("VectorStore: {}", vectorStore);
    }

    @Test
    void embeddingDimensionsTest() {
        Assert.notNull(embeddingModel, "ollamaEmbeddingModel is null");
        //打印embedding模型的转换向量的维度
        log.info("Embedding dimensions: {}", embeddingModel.dimensions());
    }

    @Test
    void vectorStoreTest() {
        Assert.notNull(vectorStore, "vectorStore is null");

        List<Document> documents = List.of(
                new Document("今天是个大晴天", Map.of("天气", "好")));
        // 添加文档到 Milvus 向量存储
        vectorStore.add(documents);
        // 检索与查询相似的文档
        List<Document> results = this.vectorStore.similaritySearch("今天天气怎么样");
        log.info("Results: {}", results);
    }
}