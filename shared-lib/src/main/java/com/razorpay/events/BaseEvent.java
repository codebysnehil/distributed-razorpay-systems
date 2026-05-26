package com.razorpay.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.util.UUID;

// Every Kafka event wraps this — gives consumers a consistent envelope.
// In Go: type BaseEvent struct { EventId, OccurredAt, Topic string }
public abstract class BaseEvent {

    private final String eventId;
    private final String topic;

    // Instant is Java's equivalent of time.Time in Go — UTC nanosecond precision
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private final Instant occurredAt;

    protected BaseEvent(String topic) {
        this.eventId    = UUID.randomUUID().toString();
        this.topic      = topic;
        this.occurredAt = Instant.now();
    }

    public String getEventId()      { return eventId; }
    public String getTopic()        { return topic; }
    public Instant getOccurredAt()  { return occurredAt; }
}
