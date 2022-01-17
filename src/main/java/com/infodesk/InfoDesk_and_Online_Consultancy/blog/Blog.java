package com.infodesk.InfoDesk_and_Online_Consultancy.blog;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="blogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String heading;
    private String blogger;
    private String blogContent;
    private Date bloggedDate;

}
