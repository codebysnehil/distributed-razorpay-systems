package com.razorpay.events;

import com.razorpay.domain.PaymentMethod;

// Published by payment-service when a new payment is created.
// fraud-service and ledger-service both consume this.
public class PaymentInitiatedEvent extends BaseEvent {

    private String paymentId;
    private String merchantId;
    private String orderId;
    private long   amountPaise;    // always store money in smallest unit — paise (1 INR = 100 paise)
    private String currency;
    private PaymentMethod paymentMethod;
    private String customerEmail;
    private String customerPhone;

    // Jackson needs a no-arg constructor to deserialize JSON back into this object
    public PaymentInitiatedEvent() {
        super(KafkaTopics.PAYMENT_INITIATED);
    }

    public PaymentInitiatedEvent(String paymentId, String merchantId, String orderId,
                                  long amountPaise, String currency,
                                  PaymentMethod paymentMethod,
                                  String customerEmail, String customerPhone) {
        super(KafkaTopics.PAYMENT_INITIATED);
        this.paymentId     = paymentId;
        this.merchantId    = merchantId;
        this.orderId       = orderId;
        this.amountPaise   = amountPaise;
        this.currency      = currency;
        this.paymentMethod = paymentMethod;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public String getPaymentId()          { return paymentId; }
    public String getMerchantId()         { return merchantId; }
    public String getOrderId()            { return orderId; }
    public long getAmountPaise()          { return amountPaise; }
    public String getCurrency()           { return currency; }
    public PaymentMethod getPaymentMethod(){ return paymentMethod; }
    public String getCustomerEmail()      { return customerEmail; }
    public String getCustomerPhone()      { return customerPhone; }
}
