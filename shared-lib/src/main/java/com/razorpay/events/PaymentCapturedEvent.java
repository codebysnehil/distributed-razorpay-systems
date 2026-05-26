package com.razorpay.events;

import java.time.Instant;

// Published after a payment is successfully captured (money actually moved).
// ledger-service creates a journal entry; notification-service sends a webhook.
public class PaymentCapturedEvent extends BaseEvent {

    private String paymentId;
    private String merchantId;
    private String orderId;
    private long   amountPaise;
    private String currency;

    @com.fasterxml.jackson.annotation.JsonFormat(shape = com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING)
    private Instant capturedAt;

    public PaymentCapturedEvent() {
        super(KafkaTopics.PAYMENT_CAPTURED);
    }

    public PaymentCapturedEvent(String paymentId, String merchantId, String orderId,
                                 long amountPaise, String currency) {
        super(KafkaTopics.PAYMENT_CAPTURED);
        this.paymentId   = paymentId;
        this.merchantId  = merchantId;
        this.orderId     = orderId;
        this.amountPaise = amountPaise;
        this.currency    = currency;
        this.capturedAt  = Instant.now();
    }

    public String getPaymentId()  { return paymentId; }
    public String getMerchantId() { return merchantId; }
    public String getOrderId()    { return orderId; }
    public long getAmountPaise()  { return amountPaise; }
    public String getCurrency()   { return currency; }
    public Instant getCapturedAt(){ return capturedAt; }
}
