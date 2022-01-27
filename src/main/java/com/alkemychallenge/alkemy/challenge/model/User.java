package com.alkemychallenge.alkemy.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idMovie;

    @Column(name = "mail")
    private String mail;

    @Column(name = "pass")
    private String pass;

    @Column(name = "accountVerified")
    private Boolean accountVerified;
}
