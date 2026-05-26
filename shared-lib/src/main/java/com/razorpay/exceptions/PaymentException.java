package com.razorpay.exceptions;

public class PaymentException extends RazorpayException {

    public PaymentException(String errorCode, String message) {
        super(errorCode, message, 400);
    }

    // Named constructors for common cases — easier to read at the call site
    public static PaymentException notFound(String paymentId) {
        return new PaymentException("PAYMENT_NOT_FOUND",
                "Payment not found: " + paymentId);
    }

    public static PaymentException invalidStatus(String paymentId, String currentStatus, String requiredStatus) {
        return new PaymentException("INVALID_PAYMENT_STATUS",
                "Payment " + paymentId + " is " + currentStatus + ", expected " + requiredStatus);
    }

    public static PaymentException alreadyCaptured(String paymentId) {
        return new PaymentException("PAYMENT_ALREADY_CAPTURED",
                "Payment " + paymentId + " has already been captured");
    }
}
