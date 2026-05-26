package com.razorpay.events;

// Published by refund-service once the refund is confirmed processed
// (i.e., money is on its way back to the customer).
// Downstream: notification-service sends a "refund completed" email/webhook.
public class RefundProcessedEvent extends BaseEvent {

    private String refundId;
    private String paymentId;
    private String merchantId;
    private long   refundAmountPaise;
    private String currency;

    public RefundProcessedEvent() {
        super(KafkaTopics.REFUND_PROCESSED);
    }

    public RefundProcessedEvent(String refundId, String paymentId,
                                 String merchantId, long refundAmountPaise, String currency) {
        super(KafkaTopics.REFUND_PROCESSED);
        this.refundId          = refundId;
        this.paymentId         = paymentId;
        this.merchantId        = merchantId;
        this.refundAmountPaise = refundAmountPaise;
        this.currency          = currency;
    }

    public String getRefundId()         { return refundId; }
    public String getPaymentId()        { return paymentId; }
    public String getMerchantId()       { return merchantId; }
    public long getRefundAmountPaise()  { return refundAmountPaise; }
    public String getCurrency()         { return currency; }
}
