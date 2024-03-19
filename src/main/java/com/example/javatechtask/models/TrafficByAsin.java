package com.example.javatechtask.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
class TrafficByAsin {

    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private Double browserSessionPercentage;
    private int browserSessionPercentageB2B;
    private Double mobileAppSessionPercentage;
    private int mobileAppSessionPercentageB2B;
    private Double sessionPercentage;
    private int sessionPercentageB2B;
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private Double browserPageViewsPercentage;
    private int browserPageViewsPercentageB2B;
    private Double mobileAppPageViewsPercentage;
    private int mobileAppPageViewsPercentageB2B;
    private Double pageViewsPercentage;
    private int pageViewsPercentageB2B;
    private int buyBoxPercentage;
    private int buyBoxPercentageB2B;
    private Double unitSessionPercentage;
    private int unitSessionPercentageB2B;

}
