package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.milvus.v2.client.MilvusClientV2;
import io.milvus.v2.client.ConnectConfig;
import io.milvus.v2.service.database.request.*;
import io.milvus.v2.common.DataType;
import io.milvus.v2.client.ConnectConfig;
import io.milvus.v2.client.MilvusClientV2;
import io.milvus.v2.service.collection.request.AddFieldReq;
import io.milvus.v2.service.collection.request.CreateCollectionReq;

@Slf4j
@SpringBootTest
public class MilvusTest {

    @Test
    public void connectTest() throws Exception {
        ConnectConfig config = ConnectConfig.builder()
                .uri("http://localhost:19530")
                .token("root:Milvus")
                .build();
        MilvusClientV2 client = new MilvusClientV2(config);
        CreateDatabaseReq createDatabaseReq = CreateDatabaseReq.builder()
                .databaseName("vector_store")
                .build();
        client.createDatabase(createDatabaseReq);
        log.info("成功创建数据库");
        DropDatabaseReq dropDatabaseReq=DropDatabaseReq.builder()
                .databaseName("vector_store")
                .build();
        client.dropDatabase(dropDatabaseReq);
        log.info("成功删除数据库");
    }

    @Test
    public void createCollectionTest() throws Exception {
        String CLUSTER_ENDPOINT = "http://localhost:19530";
        String TOKEN = "root:Milvus";
        // 1. Connect to Milvus server
        ConnectConfig connectConfig = ConnectConfig.builder()
                .uri(CLUSTER_ENDPOINT)
                .token(TOKEN)
                .build();

        MilvusClientV2 client = new MilvusClientV2(connectConfig);
        // 3. Create a collection in customized setup mode
        // 3.1 Create schema
        CreateCollectionReq.CollectionSchema schema = client.createSchema();
        // 3.2 Add fields to schema
        schema.addField(AddFieldReq.builder()
                .fieldName("my_id")
                .dataType(DataType.Int64)
                .isPrimaryKey(true)
                .autoID(false)
                .build());

        schema.addField(AddFieldReq.builder()
                .fieldName("my_vector")
                .dataType(DataType.FloatVector)
                .dimension(5)
                .build());

        schema.addField(AddFieldReq.builder()
                .fieldName("my_varchar")
                .dataType(DataType.VarChar)
                .maxLength(512)
                .build());
    }

}
