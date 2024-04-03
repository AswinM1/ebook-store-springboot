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
public class BookController {

    @Autowired
    BookService bs;

    @PostMapping("book")
public ResponseEntity<BookEntity>add(@RequestBody BookEntity em){
    BookEntity obj=bs.create(em);
   return new ResponseEntity<>(obj,HttpStatus.CREATED); 
}
@GetMapping("showbook")
public ResponseEntity <List<BookEntity>>showinfo(){
    return new ResponseEntity<>(bs.getalldetails(),HttpStatus.OK);
}
@GetMapping("getbookdata")
public ResponseEntity <List<BookEntity>>getinfo(){
    return new ResponseEntity<>(bs.getalldetails(),HttpStatus.OK);
}

@PutMapping("/api/book/{bookId}")
    public ResponseEntity<BookEntity> putMethodName(@PathVariable("bookId") int id, @RequestBody BookEntity b) {
        if(bs.updateDetails(id,b) == true)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/book/{bookId}")
    public ResponseEntity<Boolean> delete(@PathVariable("bookId") int id)
    {
        if(bs.deleteDetails(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}