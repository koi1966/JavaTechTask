package com.example.javatechtask.dtos.arhiv;

import lombok.Data;
import lombok.EqualsAndHashCode;


public record TrafficByDateDTO(
        int browserPageViews,
        int browserPageViewsB2B,
        int mobileAppPageViews,
        int mobileAppPageViewsB2B,
        int pageViews,
        int pageViewsB2B,
        int browserSessions,
        int browserSessionsB2B,
        int mobileAppSessions,
        int mobileAppSessionsB2B,
        int sessions,
        int sessionsB2B,
        double buyBoxPercentage,
        double buyBoxPercentageB2B,
        double orderItemSessionPercentage,
        double orderItemSessionPercentageB2B,
        double unitSessionPercentage,
        double unitSessionPercentageB2B,
        int averageOfferCount,
        int averageParentItems,
        int feedbackReceived,
        int negativeFeedbackReceived,
        int receivedNegativeFeedbackRate
) {

}
