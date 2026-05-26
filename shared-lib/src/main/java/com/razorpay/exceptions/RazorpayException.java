package com.razorpay.exceptions;

// Base exception for all Razorpay domain errors.
// Extends RuntimeException (unchecked) — callers don't need to declare "throws".
// In Go terms: think of this as a sentinel error type you embed in others.
public class RazorpayException extends RuntimeException {

    private final String errorCode;
    private final int httpStatus;

    public RazorpayException(String errorCode, String message, int httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public RazorpayException(String errorCode, String message, int httpStatus, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() { return errorCode; }
    public int getHttpStatus()   { return httpStatus; }
}
