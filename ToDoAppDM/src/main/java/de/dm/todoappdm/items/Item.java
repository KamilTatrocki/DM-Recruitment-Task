package de.dm.todoappdm.items;

import de.dm.todoappdm.products.Product;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM")
    private Long idItem;

    @Column(name = "EXPIRATION_DATE", nullable = false)
    private LocalDate expirationDate;


    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;



    protected Item() {  }

    public Item(LocalDate expirationDate, Product product) {
        this.expirationDate = expirationDate;
        this.product = product;
    }



    public Long getIdItem() {
        return idItem;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item other)) return false;
        return Objects.equals(idItem, other.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idItem);
    }

    @Override
    public String toString() {
        return "Item{id=%d, exp=%s, productId=%d}".formatted(
                idItem, expirationDate,
                product != null ? product.getIdProduct() : null);
    }
}
