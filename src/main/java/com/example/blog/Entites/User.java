/*
package com.example.blog.Entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "roleId")
    private Role role;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private Set<Post> posts;
}
*/
