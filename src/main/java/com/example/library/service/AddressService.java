package com.example.library.service;

import com.example.library.entity.Address;
import com.example.library.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressService(){};

    public Address add(Address address){
        return addressRepository.save(address);
    }

    public List<Address> getAll(){
        List<Address> list = new ArrayList<>();
        for (Address address : addressRepository.findAll()
        ) {
            list.add(address);
        }
        return list;
    }

    public Address getById(int id){
        return addressRepository.findById(id).get();
    }

    public void delete(int id){
        addressRepository.deleteById(id);
    }
}
