package com.example.recyclerview1;

public class Contact {
    private String name;
    private String emailid;
    private String imageUrl;

    public Contact(String name, String emailid, String imageUrl) {
        this.name = name;
        this.emailid = emailid;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", emailid='" + emailid + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
