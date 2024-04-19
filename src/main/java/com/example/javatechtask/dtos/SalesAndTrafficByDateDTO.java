package com.example.javatechtask.dtos;

import com.example.javatechtask.models.SalesByDate;
import com.example.javatechtask.models.TrafficByDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

//@EqualsAndHashCode(callSuper = true)
//@Data
public class SalesAndTrafficByDateDTO(

) {

    public SalesAndTrafficByDateDTO() {
    }

    public SalesAndTrafficByDateDTO(String date,
                                    SalesByDate salesByDate,
                                    TrafficByDate trafficByDate) {

        this.date = date;
        this.SalesByDate = salesByDate;
        this.age = age;
        this.addressEntity = addressEntity;
        this.createdAt = createdAt;
        this.insurance = insurance;
        this.carEntities = carEntities;
    }
}
