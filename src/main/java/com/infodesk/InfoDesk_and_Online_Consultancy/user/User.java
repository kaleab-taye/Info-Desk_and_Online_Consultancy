 package com.infodesk.InfoDesk_and_Online_Consultancy.user;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "first_name", nullable = true, length = 20)
    private String firstName;

    @Column(nullable = false, length = 64)
    private String password;
    
    @Column(name = "last_name", nullable = true, length = 20)
    private String lastName;

    @Column(name = "full_name", nullable = true, length = 20)
    private String fullName = firstName + " " + lastName;

    private String phoneNo;
    private String type;

    // public static Long currentUser ;

    private String username;
    @Column(columnDefinition = "boolean default true")
    private boolean enabled=true;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    @Column (columnDefinition = "varchar(10) default 'USER'")
    private Set<Role> roles = new HashSet<>();
 
    public boolean hasRole(String roleName) {
        Iterator<Role> iterator = this.roles.iterator();
        while (iterator.hasNext()) {
            Role role = iterator.next();
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
         
        return false;
    }
     

}
