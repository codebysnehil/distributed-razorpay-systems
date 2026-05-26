package com.razorpay.events;

public final class KafkaTopics {

    private KafkaTopics() {}

    public static final String PAYMENT_INITIATED  = "payment.initiated";
    public static final String PAYMENT_AUTHORIZED = "payment.authorized";
    public static final String PAYMENT_CAPTURED   = "payment.captured";
    public static final String PAYMENT_FAILED     = "payment.failed";
    public static final String PAYMENT_CANCELLED  = "payment.cancelled";

    // Refunds
    public static final String REFUND_INITIATED   = "refund.initiated";
    public static final String REFUND_PROCESSED   = "refund.processed";
    public static final String REFUND_FAILED      = "refund.failed";

    // Fraud
    public static final String FRAUD_FLAGGED      = "fraud.flagged";

    // Settlements
    public static final String SETTLEMENT_CREATED = "settlement.created";
    public static final String SETTLEMENT_PAID    = "settlement.paid";

    // Notifications
    public static final String WEBHOOK_DISPATCH   = "webhook.dispatch";

    // Ledger
    public static final String LEDGER_ENTRY       = "ledger.entry";

    // Dead-letter — failed events land here (append to any topic name)
    public static final String DLQ_SUFFIX         = ".dlq";
}
