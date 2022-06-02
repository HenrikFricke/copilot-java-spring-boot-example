package com.henrickfricke.events.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "identifier")
    @NotNull
    private String identifier;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "published_at", updatable = false)
    @CreationTimestamp
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date publishedAt;

    protected Event() {
        this.identifier = "test.identifier";
    }
    public Event(String identifier) {
        this.identifier = identifier;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public String getIdentifier() {
        return identifier;
    }
}
