package com.razorpay.exceptions;

public class MerchantException extends RazorpayException {

    public MerchantException(String errorCode, String message) {
        super(errorCode, message, 400);
    }

    public static MerchantException notFound(String merchantId) {
        return new MerchantException("MERCHANT_NOT_FOUND",
                "Merchant not found: " + merchantId);
    }

    public static MerchantException inactive(String merchantId) {
        return new MerchantException("MERCHANT_INACTIVE",
                "Merchant " + merchantId + " is not active");
    }

    public static MerchantException invalidApiKey() {
        return new MerchantException("INVALID_API_KEY", "Invalid API key");
    }
}
