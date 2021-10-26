package com.example.library.controller;

import com.example.library.entity.Address;
import com.example.library.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Address add(@RequestBody Address address){
        return addressService.add(address);
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public Address get(@Param("id") int id){
        return addressService.getById(id);
    }

    @RequestMapping(path = "/getAll",method = RequestMethod.GET)
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public void delete(@Param("id") int id){
        addressService.delete(id);
    }
}
