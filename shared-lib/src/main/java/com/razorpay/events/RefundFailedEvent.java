package com.razorpay.events;

// Published by refund-service if the refund cannot be processed
// (e.g., bank rejected, insufficient merchant balance).
public class RefundFailedEvent extends BaseEvent {

    private String refundId;
    private String paymentId;
    private String merchantId;
    private long   refundAmountPaise;
    private String failureReason;

    public RefundFailedEvent() {
        super(KafkaTopics.REFUND_FAILED);
    }

    public RefundFailedEvent(String refundId, String paymentId, String merchantId,
                              long refundAmountPaise, String failureReason) {
        super(KafkaTopics.REFUND_FAILED);
        this.refundId          = refundId;
        this.paymentId         = paymentId;
        this.merchantId        = merchantId;
        this.refundAmountPaise = refundAmountPaise;
        this.failureReason     = failureReason;
    }

    public String getRefundId()         { return refundId; }
    public String getPaymentId()        { return paymentId; }
    public String getMerchantId()       { return merchantId; }
    public long getRefundAmountPaise()  { return refundAmountPaise; }
    public String getFailureReason()    { return failureReason; }
}
