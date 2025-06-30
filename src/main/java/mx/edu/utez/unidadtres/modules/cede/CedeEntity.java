package mx.edu.utez.unidadtres.modules.cede;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import mx.edu.utez.unidadtres.modules.warehouse.WarehouseEntity;

import java.util.List;

@Table(name = "cede")
@Entity
public class CedeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "cede")
    @JsonIgnore
    private List<WarehouseEntity> warehouseEntities;

    public CedeEntity() {
    }

    public CedeEntity(Long id, String clave, String state, String city, List<WarehouseEntity> warehouseEntities) {
        this.id = id;
        this.clave = clave;
        this.state = state;
        this.city = city;
        this.warehouseEntities = warehouseEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<WarehouseEntity> getWarehouseEntities() {
        return warehouseEntities;
    }

    public void setWarehouseEntities(List<WarehouseEntity> warehouseEntities) {
        this.warehouseEntities = warehouseEntities;
    }
}
