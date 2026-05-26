package com.razorpay.exceptions;

public class RefundException extends RazorpayException {

    public RefundException(String errorCode, String message) {
        super(errorCode, message, 400);
    }

    public static RefundException notFound(String refundId) {
        return new RefundException("REFUND_NOT_FOUND", "Refund not found: " + refundId);
    }

    public static RefundException paymentNotCaptured(String paymentId) {
        return new RefundException("PAYMENT_NOT_CAPTURED",
                "Payment " + paymentId + " has not been captured or does not exist");
    }

    public static RefundException amountExceedsRefundable(String paymentId, long requested, long available) {
        return new RefundException("REFUND_AMOUNT_EXCEEDS_BALANCE",
                String.format("Refund amount %dp exceeds refundable balance %dp for payment %s",
                        requested, available, paymentId));
    }
}
