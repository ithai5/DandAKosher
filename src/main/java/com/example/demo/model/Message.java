package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="message")
public class Message {
    private int id;
    private String subject;
    private String content;
    private int customerId;

    public Message() {
    }

    public Message(int id, String subject, String content, int customerId) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.customerId = customerId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subject", nullable = true, length = 45)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 256)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                customerId == message.customerId &&
                Objects.equals(subject, message.subject) &&
                Objects.equals(content, message.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, content, customerId);
    }
}
