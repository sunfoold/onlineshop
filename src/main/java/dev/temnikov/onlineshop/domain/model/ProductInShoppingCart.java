package dev.temnikov.onlineshop.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products_in_cart")
public class ProductInShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator")
    @JsonIgnore
    private Long id;
    private String productName;
    private int quantity;
    private int price;
    @ManyToOne(cascade= CascadeType.ALL)
    @JsonIgnore
    private ShoppingCart cart;
    private int total;

    public int getTotal() {
        if (this.total == 0) {
            this.total = this.price * this.quantity;
        }
        return this.total;
    }

    public void calculateSum(){
        this.total = this.price * this.quantity;
    }
}
