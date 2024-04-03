package com.example.springboot.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.loginentity.*;
import com.example.springboot.service.*;;

@RestController
public class LoginController {

    @Autowired
    LoginService es;

    @PostMapping("newdata")
public ResponseEntity<LoginEntity>add(@RequestBody LoginEntity em){
    LoginEntity obj=es.create(em);
   return new ResponseEntity<>(obj,HttpStatus.CREATED); 
}
@GetMapping("showdata")
public ResponseEntity <List<LoginEntity>>showinfo(){
    return new ResponseEntity<>(es.getalldetails(),HttpStatus.OK);
}
@GetMapping("getdata")
public ResponseEntity <List<LoginEntity>>getinfo(){
    return new ResponseEntity<>(es.getalldetails(),HttpStatus.OK);
}

@PutMapping("/api/login/{loginId}")
    public ResponseEntity<LoginEntity> putMethodName(@PathVariable("loginId") int id, @RequestBody LoginEntity login) {
        if(es.updateDetails(id,login) == true)
        {
            return new ResponseEntity<>(login,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/login/{loginId}")
    public ResponseEntity<Boolean> delete(@PathVariable("loginId") int id)
    {
        if(es.deleteDetails(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}