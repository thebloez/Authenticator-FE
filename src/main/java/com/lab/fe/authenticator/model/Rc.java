package com.lab.fe.authenticator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rc {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "rc")
    private String rc;

    @Column(name = "rc_desc")
    private String rc_desc;

    @Column(name = "httpstatus")
    private String httpstatus;
}
