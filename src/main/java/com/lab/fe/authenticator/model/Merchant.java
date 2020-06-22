package com.lab.fe.authenticator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Merchant {
    @Id
    @Column(name = "merchantid")
    private String merchantid;

    @Column(name = "apikey")
    private String apiKey;

    @Column(name = "secretkey")
    private String secretkey;
}
