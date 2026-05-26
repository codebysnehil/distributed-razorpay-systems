package com.razorpay.domain;

public enum PaymentStatus {
    CREATED,            // payment record exists, nothing sent to bank yet
    PENDING,            // sent to gateway, waiting for user action (UPI approval etc)
    AUTHORIZED,
    CAPTURED,
    REFUNDED,
    PARTIALLY_REFUNDED,
    FAILED,
    CANCELLED,
    EXPIRED             // 15-min expiry
}
