package com.springMvc.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "licenses")
public class License {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String number;
    
    private Date expirationDate;
    
    private String state;
    
    @Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User owner;

}
