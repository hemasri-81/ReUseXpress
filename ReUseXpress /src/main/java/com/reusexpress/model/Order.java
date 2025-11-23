package com.reusexpress.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne @JoinColumn(name="product_id") private Product product;
    @ManyToOne @JoinColumn(name="buyer_id") private User buyer;
    @Column(name="order_date") private Date orderDate = new Date();
    private String status = "PLACED";
    public Integer getId(){return id;} public void setId(Integer id){this.id=id;}
    public Product getProduct(){return product;} public void setProduct(Product p){this.product=p;}
    public User getBuyer(){return buyer;} public void setBuyer(User b){this.buyer=b;}
    public Date getOrderDate(){return orderDate;} public void setOrderDate(Date d){this.orderDate=d;}
    public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
}
