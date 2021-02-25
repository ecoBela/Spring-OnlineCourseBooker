package com.codeclan.example.OnlineCourseBooker.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="town")
    private String town;

    @Column(name="rating")
    private Double rating;


    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties({"course"})
    private List<Booking> bookings;




    public Course(String name, String town, Double rating) {
        this.name = name;
        this.town = town;
        this.rating = rating;
        this.bookings = new ArrayList<>();
    }

    public Course(){}

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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
