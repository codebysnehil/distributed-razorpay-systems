package com.razorpay.events;

// Published by payment-service when a refund is requested.
// ledger-service reverses the journal entry; notification-service notifies customer.
public class RefundInitiatedEvent extends BaseEvent {

    private String refundId;
    private String paymentId;
    private String merchantId;
    private long   refundAmountPaise;
    private String reason;

    public RefundInitiatedEvent() {
        super(KafkaTopics.REFUND_INITIATED);
    }

    public RefundInitiatedEvent(String refundId, String paymentId,
                                 String merchantId, long refundAmountPaise, String reason) {
        super(KafkaTopics.REFUND_INITIATED);
        this.refundId          = refundId;
        this.paymentId         = paymentId;
        this.merchantId        = merchantId;
        this.refundAmountPaise = refundAmountPaise;
        this.reason            = reason;
    }

    public String getRefundId()           { return refundId; }
    public String getPaymentId()          { return paymentId; }
    public String getMerchantId()         { return merchantId; }
    public long getRefundAmountPaise()    { return refundAmountPaise; }
    public String getReason()             { return reason; }
}
