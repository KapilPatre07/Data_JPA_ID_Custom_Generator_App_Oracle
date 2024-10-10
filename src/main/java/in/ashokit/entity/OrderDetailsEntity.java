package in.ashokit.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import in.ashokit.generator.OrderIdGenerator;

@Entity
@Table(name = "ORDER_DTLS")
public class OrderDetailsEntity {

    @Id
    @Column(name = "ORDER_ID")
    @GenericGenerator(name = "order_id_gen", strategy = "in.ashokit.generator.OrderIdGenerator")
    @GeneratedValue(generator = "order_id_gen")
    private String orderId;

    @Column(name = "ORDER_BY")
    private String orderBy;

    @Column(name = "ORDER_PLACED_DT")
    @Temporal(TemporalType.DATE)
    private Date orderPlacedDate;

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Date getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(Date orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }

    public void getMSg() {
        System.out.println("Hello India");;
    }



}
