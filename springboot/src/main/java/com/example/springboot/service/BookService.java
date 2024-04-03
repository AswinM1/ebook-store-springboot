package com.example.springboot.service;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.loginentity.*;
import com.example.springboot.repository.BookRepo;

// import jakarta.persistence.metamodel.ListAttribute;

@Service
public class BookService {

    @Autowired
    BookRepo er;

    public BookEntity create(BookEntity ee){
        return er.save(ee);
    }

    public java.util.List<BookEntity> getalldetails(){
        return er.findAll();
    
    }

    public BookEntity getById(int id){
        return er.findById(id).orElse(null);
    }

    public boolean updateDetails(int id,BookEntity l)
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