package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="customermessage")
public class CustomerMessage {
    @Id
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private boolean isSubscribed;
    private String subject;
    private String content;

    @Basic
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
    @Column(name = "full_name", nullable = false, length = 45)
    public String getFullName ()
    {
        return fullName;
    }

    public void setFullName (String fullName)
    {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 12)
    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "is_subscribed", nullable = false)
    public boolean getIsSubscribed ()
    {
        return isSubscribed;
    }

    public void setIsSubscribed (boolean isSubscribed)
    {
        this.isSubscribed = isSubscribed;
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

    @Override
    public boolean equals (Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerMessage that = (CustomerMessage) o;

        if (id != that.id) {
            return false;
        }
        if (isSubscribed != that.isSubscribed) {
            return false;
        }
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) {
            return false;
        }
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) {
            return false;
        }
        if (email != null ? !email.equals(that.email) : that.email != null) {
            return false;
        }
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) {
            return false;
        }
        if (content != null ? !content.equals(that.content) : that.content != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerMessage{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isSubscribed=" + isSubscribed +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
