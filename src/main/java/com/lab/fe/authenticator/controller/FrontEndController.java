package com.lab.fe.authenticator.controller;

import com.lab.fe.authenticator.abstraction.Request;
import com.lab.fe.authenticator.model.Merchant;
import com.lab.fe.authenticator.model.Person;
import com.lab.fe.authenticator.repository.MerchantRepos;
import com.lab.fe.authenticator.repository.PersonRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class FrontEndController {

    @Autowired
    MerchantRepos merchantRepos;

    @Autowired
    PersonRepos personRepos;

    @GetMapping("/merchant/all")
    public List<Merchant> getall(){
        return merchantRepos.findAll();
    }

    @GetMapping("/{merchantid}")
    public Optional<Merchant> findMerchant(@PathVariable("merchantid") String merchantid){
        return merchantRepos.findById(merchantid);
    }

    @GetMapping("/person")
    public ResponseEntity<String> getAllUser(@RequestHeader("API-Key") String apikey,
                                             @RequestHeader("signature") String signature,
                                             @RequestHeader("timestamp") String timestamp){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
