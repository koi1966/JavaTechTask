package com.example.javatechtask.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonPOJOBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "salesAndTrafficByAsin")
public class SalesAndTrafficByAsin {
    public String parentAsin;
    public SalesByAsin salesByAsin;
    public TrafficByAsin trafficByAsin;
}
