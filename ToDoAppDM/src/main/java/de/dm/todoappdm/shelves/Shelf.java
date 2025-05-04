package de.dm.todoappdm.shelves;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "SHELVES")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSHELVES")
    private Long id;
    @Column(name = "DESCRIPTION",  length = 255)
    private String description;

    protected Shelf() { }

    public Shelf(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shelf other)) return false;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Shelf{id=" + id + ", description='" + description + "'}";
    }
}
