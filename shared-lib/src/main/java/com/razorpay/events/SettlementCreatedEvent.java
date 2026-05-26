package com.razorpay.events;

// Published by settlement-service when a merchant's settlement batch is created.
// Future: a payout-service would consume this and initiate the actual bank transfer.
public class SettlementCreatedEvent extends BaseEvent {

    private String settlementId;
    private String merchantId;
    private long   totalAmountPaise;
    private String currency;
    private int    itemCount;

    public SettlementCreatedEvent() {
        super(KafkaTopics.SETTLEMENT_CREATED);
    }

    public SettlementCreatedEvent(String settlementId, String merchantId,
                                   long totalAmountPaise, String currency, int itemCount) {
        super(KafkaTopics.SETTLEMENT_CREATED);
        this.settlementId     = settlementId;
        this.merchantId       = merchantId;
        this.totalAmountPaise = totalAmountPaise;
        this.currency         = currency;
        this.itemCount        = itemCount;
    }

    public String getSettlementId()      { return settlementId; }
    public String getMerchantId()        { return merchantId; }
    public long getTotalAmountPaise()    { return totalAmountPaise; }
    public String getCurrency()          { return currency; }
    public int getItemCount()            { return itemCount; }
}
