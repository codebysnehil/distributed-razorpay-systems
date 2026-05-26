package com.razorpay.exceptions;

public class FraudException extends RazorpayException {

    public FraudException(String message) {
        super("FRAUD_DETECTED", message, 422);
    }
}
