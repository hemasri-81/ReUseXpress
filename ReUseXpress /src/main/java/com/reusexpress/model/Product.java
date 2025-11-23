package com.reusexpress.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="products")
public class Product implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;
    private Double price;
    @Column(name="image_path")
    private String imagePath;
    @ManyToOne
    @JoinColumn(name="seller_id")
    private User seller;
    @Column(name="created_at")
    private Date createdAt = new Date();
    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public String getTitle(){return title;} public void setTitle(String t){this.title=t;}
    public String getDescription(){return description;} public void setDescription(String d){this.description=d;}
    public Double getPrice(){return price;} public void setPrice(Double p){this.price=p;}
    public String getImagePath(){return imagePath;} public void setImagePath(String ip){this.imagePath=ip;}
    public User getSeller(){return seller;} public void setSeller(User s){this.seller=s;}
    public Date getCreatedAt(){return createdAt;} public void setCreatedAt(Date d){this.createdAt=d;}
}
