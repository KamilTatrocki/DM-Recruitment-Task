package de.dm.todoappdm.locationOfItems;

import de.dm.todoappdm.items.Item;
import de.dm.todoappdm.shelves.Shelf;
import jakarta.persistence.*;

@Entity
@Table(name="location_of_items")
public class LocationOfItems {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDLOCATION")
    private Long idLocation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item idItem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SHELF_ID", nullable = false)
    private Shelf idShelves;

    public LocationOfItems() {}

    public LocationOfItems(Item idItem, Shelf idShelves) {
        this.idItem = idItem;
        this.idShelves = idShelves;
    }


    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }


    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }


    public Shelf getIdShelves() {
        return idShelves;
    }

    public void setIdShelves(Shelf idShelves) {
        this.idShelves = idShelves;
    }
}
