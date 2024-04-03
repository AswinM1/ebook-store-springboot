package com.example.springboot.loginentity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginEntity {

    @Id
    private int lid;
    private String pass;
    
    public LoginEntity(int lid, String pass) 
    {
        this.lid = lid;
        this.pass = pass;
    }
    public LoginEntity() {
    }
    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

}
