package com.wang.controller;

import com.wang.pojo.Book;
import com.wang.service.BookService;
import com.wang.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    @CrossOrigin
    public List<Book> list(){
        return bookService.list();
    }
    @PostMapping("/api/books")
    @CrossOrigin
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    @CrossOrigin
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }


    @GetMapping("/api/categories/{cid}/books")
    @CrossOrigin
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)){
            return bookService.list();
        }else {
            return bookService.search(keywords);
        }
    }
    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file){
        String folder = "/Users/xihengwang/Documents/My_Tutorial/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if(!f.getParentFile().exists())
            f.getParentFile().mkdir();
        try {
          file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/"+f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }


    }

}
