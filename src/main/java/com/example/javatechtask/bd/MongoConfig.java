package com.example.javatechtask.bd;

import com.example.javatechtask.models.*;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private static final String MONGO_URL = "mongodb://localhost:27017";

    @Override
    protected String getDatabaseName() {
        return "newdb";
    }

    @Override
//    public com.mongodb.client.MongoClient mongoClient() {
    public MongoClient mongoClient() {

        ConnectionString connectionString = new ConnectionString(MONGO_URL);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .codecRegistry(createCodecRegistry())
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    private static CodecRegistry createCodecRegistry() {
        // Создание PojoCodecProvider для вашего класса Employee
        PojoCodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                .register(ReportSpecification.class)
                .register(ReportOptions.class)
                .register(OrderedProductSales.class)
                .register(OrderedProductSalesB2B.class)
                .register(MarketplaceIds.class)
                .register(SalesAndTrafficByDate.class)
                .register(SalesByDate.class) // Зарегистрируйте другие классы по аналогии
                .register(TrafficByDate.class)
                .register(AverageSalesPerOrderItem.class)
                .register(AverageSalesPerOrderItemB2B.class)
                .register(AverageSellingPrice.class)
                .register(AverageSellingPriceB2B.class)
                .register(ClaimsAmount.class)
                .register(ShippedProductSales.class)
                .register(TrafficByDate.class)
                .register(SalesAndTrafficByAsin.class)
                .register(SalesByAsin.class)
                .register(Community.class)
                .build();


        // Создание кодека для работы с вашим классом Employee
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(pojoCodecProvider));

        return codecRegistry;
    }

}
