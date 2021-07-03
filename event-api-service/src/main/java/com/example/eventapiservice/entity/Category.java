package com.example.eventapiservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "tu_category")
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
