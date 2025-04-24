package com.example.andersenHomeWork.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spaces")
@SQLDelete(sql = "UPDATE spaces SET deleted=true WHERE id=?")
@SQLRestriction("deleted='false'")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "space_type", nullable = false)
    private String spaceType;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "space_availability", nullable = false)
    @Enumerated(EnumType.STRING)
    private SpaceAvailability spaceAvailability;

    @Column(nullable = false)
    private boolean deleted = Boolean.FALSE;


    @ManyToMany
    @JoinTable(
            name = "user_reservations",
            joinColumns = {@JoinColumn(name="space_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
    @JsonManagedReference
    private List<User> users = new ArrayList<>();
}