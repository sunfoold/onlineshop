package dev.temnikov.onlineshop.domain.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart")
public class ShoppingCart {

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    @SequenceGenerator(name = "sequence_generator")
    private Long id;
    private int total;
    @Setter
    @Getter
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<ProductInShoppingCart> products;


    public int getTotal(){
        if (this.total ==0){
            this.total = calculateSum();
        }
        return this.total;
    }

    public int calculateSum() {
        if (this.products == null || this.products.isEmpty()) {
            return 0;
        }
        this.total = this.products.stream().mapToInt(ProductInShoppingCart::getTotal).sum();
        return total;
    }


}
