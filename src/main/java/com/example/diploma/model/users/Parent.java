package com.example.diploma.model.users;

import javax.persistence.*;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long parent_id;

    @OneToOne(mappedBy = "parent")
    private TeacherbookUser user;

}
