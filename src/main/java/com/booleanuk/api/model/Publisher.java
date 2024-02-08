package com.booleanuk.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String location;


    @OneToMany(mappedBy = "publisher")
    @JsonIgnoreProperties("publisher")
    private List<Book> books;

    public Publisher(String name, String location) {
        this.name = name;
        this.location = location;
    }
    public Publisher(int id) {
        this.id = id;
    }


}