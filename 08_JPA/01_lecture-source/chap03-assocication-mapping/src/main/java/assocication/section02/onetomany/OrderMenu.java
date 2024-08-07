package assocication.section02.onetomany;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_order_menu")
public class OrderMenu {

    @EmbeddedId
    private OrderMenuPK orderMenuPK;

    @Column(name="ORDER_AMOUNT")
    private int orderAmount;

    public OrderMenu() {}

    public OrderMenu(OrderMenuPK orderMenuPK, int orderAmount) {
        this.orderMenuPK = orderMenuPK;
        this.orderAmount = orderAmount;
    }

    public OrderMenuPK getOrderMenuPK() {
        return orderMenuPK;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderMenuPK=" + orderMenuPK +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
