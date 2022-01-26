package com.infodesk.InfoDesk_and_Online_Consultancy.user;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "roles")
// public class Role {
//     @Id
//     @Column(name="role_id")
//     @GeneratedValue(strategy =GenerationType.IDENTITY)
//     private Integer id;
//     private String name;

//         // public Integer getId() {
//         //     return id;
//         // }
//         // public void setId(Integer id) {
//         //     this.id = id;
//         // }
//         // public String getName() {
//         //     return name;
//         // }
//         // public void setName(String name) {
//         //     this.name = name;
//         // }

// }
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
   @Id
   @Column(name = "role_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String name;
   public Integer getId() {
       return id;
   }

   // remaining getters and setters
}