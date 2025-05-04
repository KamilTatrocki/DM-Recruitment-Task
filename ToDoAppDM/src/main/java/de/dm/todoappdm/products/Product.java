package de.dm.todoappdm.products;

import de.dm.todoappdm.categories.Category;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name_product", nullable = false, length = 200)
    private String nameProduct;



    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;



    protected Product() { }

    public Product(String nameProduct, Category category) {
        this.nameProduct = nameProduct;
        this.category = category;
    }



    public Long getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product other)) return false;
        return Objects.equals(idProduct, other.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProduct);
    }

    @Override
    public String toString() {
        return "Product{id=%d, name='%s', categoryId=%d}".formatted(
                idProduct, nameProduct,
                category != null ? category.getId() : null);
    }
}
