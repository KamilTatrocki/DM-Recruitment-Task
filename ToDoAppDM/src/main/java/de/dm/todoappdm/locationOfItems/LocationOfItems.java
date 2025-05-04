package de.dm.todoappdm.locationOfItems;

import jakarta.persistence.*;

@Entity
@Table(name="location_of_items")
public class LocationOfItems {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="IDLOCATION")
    private Long idLocation;
    @Column(name="IDITEM")
    private Long idItem;
    @Column(name="IDSHELVES")
    private Long idShelves;

    public LocationOfItems() {}

    public LocationOfItems(Long idItem, Long idShelves) {
        this.idItem = idItem;
        this.idShelves = idShelves;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdShelves() {
        return idShelves;
    }

    public void setIdShelves(Long idShelves) {
        this.idShelves = idShelves;
    }
}