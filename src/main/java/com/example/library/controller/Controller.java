package com.example.library.controller;

import com.example.library.entity.Address;
import com.example.library.entity.Author;
import com.example.library.entity.Library;
import com.example.library.service.AddressService;
import com.example.library.service.AuthorService;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private AddressService addressService;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(path = "/address/add", method = RequestMethod.POST)
    public Address addAddress(@RequestBody Address address){
        System.out.println(address.getLocation());
        return addressService.add(address);
    }

    @RequestMapping(path = "/test")
    public String test(){
        addressService.add(new Address("test location"));
        return "ok";
    }

    @RequestMapping(path = "/library/add", method = RequestMethod.POST)
    public Library addLibrary(@RequestBody Library library){
        System.out.println(library.getName());
        System.out.println(library.getAddress());
        return libraryService.addLibrary(library);
    }


}
