package com.razorpay.events;

// Published when a payment fails at any stage (gateway rejection, fraud block, timeout).
// notification-service consumes this to alert the customer.
public class PaymentFailedEvent extends BaseEvent {

    private String paymentId;
    private String merchantId;
    private String orderId;
    private String failureReason;
    private String failureCode;
    private long   amountPaise;

    public PaymentFailedEvent() {
        super(KafkaTopics.PAYMENT_FAILED);
    }

    public PaymentFailedEvent(String paymentId, String merchantId, String orderId,
                               long amountPaise, String failureCode, String failureReason) {
        super(KafkaTopics.PAYMENT_FAILED);
        this.paymentId     = paymentId;
        this.merchantId    = merchantId;
        this.orderId       = orderId;
        this.amountPaise   = amountPaise;
        this.failureCode   = failureCode;
        this.failureReason = failureReason;
    }

    public String getPaymentId()     { return paymentId; }
    public String getMerchantId()    { return merchantId; }
    public String getOrderId()       { return orderId; }
    public long getAmountPaise()     { return amountPaise; }
    public String getFailureReason() { return failureReason; }
    public String getFailureCode()   { return failureCode; }
}
