package com.example.javatechtask.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
////@Entity("salesAndTrafficReport")
//@Document
//public class SalesAndTrafficReport111 {
//
//    @Id
//    private String id;
//
////    @Embedded
//    public static class ReportOptions {
//        private String dateGranularity;
//        private String asinGranularity;
//
//    }
//
////    @Embedded
//    public static class SalesByDate {
//        private double amount;
//        private String currencyCode;
//        private int unitsOrdered;
//        private int unitsOrderedB2B;
//        private int totalOrderItems;
//        private int totalOrderItemsB2B;
//        private AverageSalesPerOrderItem averageSalesPerOrderItem;
//        private AverageSalesPerOrderItem averageSalesPerOrderItemB2B;
//        private double averageUnitsPerOrderItem;
//        private double averageUnitsPerOrderItemB2B;
//        private AverageSellingPrice averageSellingPrice;
//        private AverageSellingPrice averageSellingPriceB2B;
//        private int unitsRefunded;
//        private double refundRate;
//        private int claimsGranted;
//        private ClaimsAmount claimsAmount;
//        private OrderedProductSales shippedProductSales;
//        private int unitsShipped;
//        private int ordersShipped;
//
////        @Embedded
//        public static class AverageSalesPerOrderItem {
//            private double amount;
//            private String currencyCode;
//        }
//
////        @Embedded
//        public static class AverageSellingPrice {
//            private double amount;
//            private String currencyCode;
//        }
//
////        @Embedded
//        public static class ClaimsAmount {
//            private double amount;
//            private String currencyCode;
//        }
//    }
//
////    @Embedded
//    public static class TrafficByDate {
//        private int browserPageViews;
//        private int browserPageViewsB2B;
//        private int mobileAppPageViews;
//        private int mobileAppPageViewsB2B;
//        private int pageViews;
//        private int pageViewsB2B;
//        private int browserSessions;
//        private int browserSessionsB2B;
//        private int mobileAppSessions;
//        private int mobileAppSessionsB2B;
//        private int sessions;
//        private int sessionsB2B;
//        private double buyBoxPercentage;
//        private double buyBoxPercentageB2B;
//        private double orderItemSessionPercentage;
//        private double orderItemSessionPercentageB2B;
//        private double unitSessionPercentage;
//        private double unitSessionPercentageB2B;
//        private int averageOfferCount;
//        private int averageParentItems;
//        private int feedbackReceived;
//        private int negativeFeedbackReceived;
//        private double receivedNegativeFeedbackRate;
//    }
//
////    @Embedded
//    public static class SalesAndTrafficByDate {
//        private String date;
//        private SalesByDate salesByDate;
//        private TrafficByDate trafficByDate;
//    }
//
////    @Embedded
//    public static class SalesByAsin {
//        private String parentAsin;
//        private SalesByAsinDetails salesByAsin;
//        private TrafficByAsinDetails trafficByAsin;
//
////        @Embedded
//        public static class SalesByAsinDetails {
//            private int unitsOrdered;
//            private int unitsOrderedB2B;
//            private OrderedProductSales orderedProductSales;
//        }
//
////        @Embedded
//        public static class TrafficByAsinDetails {
//            private int browserSessions;
//            private int browserSessionsB2B;
//            private int mobileAppSessions;
//            private int mobileAppSessionsB2B;
//            private int sessions;
//            private int sessionsB2B;
//            private double browserSessionPercentage;
//            private double browserSessionPercentageB2B;
//            private double mobileAppSessionPercentage;
//            private double mobileAppSessionPercentageB2B;
//            private double sessionPercentage;
//            private double sessionPercentageB2B;
//            private int browserPageViews;
//            private int browserPageViewsB2B;
//            private int mobileAppPageViews;
//            private int mobileAppPageViewsB2B;
//            private int pageViews;
//            private int pageViewsB2B;
//            private double browserPageViewsPercentage;
//            private double browserPageViewsPercentageB2B;
//            private double mobileAppPageViewsPercentage;
//            private double mobileAppPageViewsPercentageB2B;
//            private double pageViewsPercentage;
//            private double pageViewsPercentageB2B;
//            private double buyBoxPercentage;
//            private double buyBoxPercentageB2B;
//            private double unitSessionPercentage;
//            private double unitSessionPercentageB2B;
//        }
//    }
//
////    @Embedded
//    public static class OrderedProductSales {
//        private double amount;
//        private String currencyCode;
//    }
//
////    @Embedded
//    public static class SalesAndTrafficByAsinDetails {
//        private String parentAsin;
//        private SalesByAsinDetails salesByAsin;
//        private TrafficByAsinDetails trafficByAsin;
//
////        @Embedded
//        public static class SalesByAsinDetails {
//            private int unitsOrdered;
//            private int unitsOrderedB2B;
//            private OrderedProductSales orderedProductSales;
//        }
//
////        @Embedded
//        public static class TrafficByAsinDetails {
//            private int browserSessions;
//            private int browserSessionsB2B;
//            private int mobileAppSessions;
//            private int mobileAppSessionsB2B;
//            private int sessions;
//            private int sessionsB2B;
//            private double browserSessionPercentage;
//            private double browserSessionPercentageB2B;
//            private double mobileAppSessionPercentage;
//            private double mobileAppSessionPercentageB2B;
//            private double sessionPercentage;
//            private double sessionPercentageB2B;
//            private int browserPageViews;
//            private int browserPageViewsB2B;
//            private int mobileAppPageViews;
//            private int mobileAppPageViewsB2B;
//            private int pageViews;
//            private int pageViewsB2B;
//            private double browserPageViewsPercentage;
//            private double browserPageViewsPercentageB2B;
//            private double mobileAppPageViewsPercentage;
//            private double mobileAppPageViewsPercentageB2B;
//            private double pageViewsPercentage;
//            private double pageViewsPercentageB2B;
//            private double buyBoxPercentage;
//            private double buyBoxPercentageB2B;
//            private double unitSessionPercentage;
//            private double unitSessionPercentageB2B;
//        }
//    }
//
////    @Embedded
//    public static class TrafficByAsin {
//        private int browserSessions;
//        private int browserSessionsB2B;
//        private int mobileAppSessions;
//        private int mobileAppSessionsB2B;
//        private int sessions;
//        private int sessionsB2B;
//        private double browserSessionPercentage;
//        private double browserSessionPercentageB2B;
//        private double mobileAppSessionPercentage;
//        private double mobileAppSessionPercentageB2B;
//        private double sessionPercentage;
//        private double sessionPercentageB2B;
//        private int browserPageViews;
//        private int browserPageViewsB2B;
//        private int mobileAppPageViews;
//        private int mobileAppPageViewsB2B;
//        private int pageViews;
//        private int pageViewsB2B;
//        private double browserPageViewsPercentage;
//        private double browserPageViewsPercentageB2B;
////        private double mobileAppPageViews;
//    }
//}
