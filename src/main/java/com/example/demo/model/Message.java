package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
    private int id;
    private String subject;
    private String content;
    private int customerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "subject", nullable = true, length = 45)
    public String getSubject ()
    {
        return subject;
    }

    public void setSubject (String subject)
    {
        this.subject = subject;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 256)
    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Basic
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId ()
    {
        return customerId;
    }

    public void setCustomerId (int customerId)
    {
        this.customerId = customerId;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Message message = (Message) o;

        if (id != message.id) {
            return false;
        }
        if (customerId != message.customerId) {
            return false;
        }
        if (subject != null ? !subject.equals(message.subject) : message.subject != null) {
            return false;
        }
        if (content != null ? !content.equals(message.content) : message.content != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + customerId;
        return result;
    }
}
