package com.example.springboot.service;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.loginentity.*;
import com.example.springboot.repository.LoginRepo;

// import jakarta.persistence.metamodel.ListAttribute;

@Service
public class LoginService {

    @Autowired
    LoginRepo er;

    public LoginEntity create(LoginEntity ee){
        return er.save(ee);
    }

    public java.util.List<LoginEntity> getalldetails(){
        return er.findAll();
    
    }

    public LoginEntity getById(int id){
        return er.findById(id).orElse(null);
    }

    public boolean updateDetails(int id,LoginEntity l)
        {
            if(this.getById(id)==null)
            {
                return false;
            }
            try{
                er.save(l);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }

        public boolean deleteDetails(int id)
        {
            if(this.getById(id) == null)
            {
                return false;
            }
            er.deleteById(id);
            return true;
        }

}