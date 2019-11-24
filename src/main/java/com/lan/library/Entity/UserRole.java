package com.lan.library.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Xiang Lan
 * Created on 2019-07-15 11:22
 */
@Entity(name = "user_role")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleName role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserRole(RoleName role){
        this.role = role;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        return role == userRole.role;

    }

    @Override
    public int hashCode() {
        return role.hashCode();
    }


}
