package de.dm.todoappdm.tasks;

import de.dm.todoappdm.products.Product;
import de.dm.todoappdm.shelves.Shelf;
import jakarta.persistence.*;

@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTASK")
    private Long idTask;

    @Column(name = "DESCRIPTION", nullable = false, length = 255)
    private String description;

    @ManyToOne(optional = true)
    @JoinColumn(name = "SHELF_FROM_ID", nullable = true)
    private Shelf shelfFrom;

    @ManyToOne(optional = true)
    @JoinColumn(name = "SHELF_TO_ID", nullable = true)
    private Shelf shelfTo;

    @ManyToOne(optional = true)
    @JoinColumn(name = "PRODUCT_ID", nullable = true)
    private Product product;

    public Task() { }

    public Task(String description, Shelf shelfFrom, Shelf shelfTo, Product product) {
        this.description = description;
        this.shelfFrom   = shelfFrom;
        this.shelfTo     = shelfTo;
        this.product     = product;
    }


    public Long getIdTask() { return idTask; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Shelf getShelfFrom() { return shelfFrom; }
    public void setShelfFrom(Shelf shelfFrom) { this.shelfFrom = shelfFrom; }

    public Shelf getShelfTo() { return shelfTo; }
    public void setShelfTo(Shelf shelfTo) { this.shelfTo = shelfTo; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
