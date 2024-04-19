package com.example.javatechtask.models;

import lombok.Data;

//@Data
public class TrafficByDate{
    private int browserPageViews;
    private int browserPageViewsB2B;
    private int mobileAppPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViews;
    private int pageViewsB2B;
    private int browserSessions;
    private int browserSessionsB2B;
    private int mobileAppSessions;
    private int mobileAppSessionsB2B;
    private int sessions;
    private int sessionsB2B;
    private double buyBoxPercentage;
    public double buyBoxPercentageB2B;
    public double orderItemSessionPercentage;
    public double orderItemSessionPercentageB2B;
    public double unitSessionPercentage;
    public double unitSessionPercentageB2B;
    public int averageOfferCount;
    public int averageParentItems;
    public int feedbackReceived;
    public int negativeFeedbackReceived;
    public int receivedNegativeFeedbackRate;
}
