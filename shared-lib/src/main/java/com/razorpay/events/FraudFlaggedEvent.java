package com.razorpay.events;

// Published by fraud-service when it detects a suspicious transaction.
// payment-service consumes this and moves the payment to FAILED.
public class FraudFlaggedEvent extends BaseEvent {

    private String paymentId;
    private String merchantId;
    private String ruleTriggered;   // which fraud rule fired, e.g. "VELOCITY_BREACH"
    private double riskScore;       // 0.0–1.0
    private String notes;

    public FraudFlaggedEvent() {
        super(KafkaTopics.FRAUD_FLAGGED);
    }

    public FraudFlaggedEvent(String paymentId, String merchantId,
                              String ruleTriggered, double riskScore, String notes) {
        super(KafkaTopics.FRAUD_FLAGGED);
        this.paymentId     = paymentId;
        this.merchantId    = merchantId;
        this.ruleTriggered = ruleTriggered;
        this.riskScore     = riskScore;
        this.notes         = notes;
    }

    public String getPaymentId()     { return paymentId; }
    public String getMerchantId()    { return merchantId; }
    public String getRuleTriggered() { return ruleTriggered; }
    public double getRiskScore()     { return riskScore; }
    public String getNotes()         { return notes; }
}
