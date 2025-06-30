package mx.edu.utez.unidadtres.modules.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import mx.edu.utez.unidadtres.modules.warehouse.WarehouseEntity;

import java.util.List;

@Table(name = "client")
@Entity

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<WarehouseEntity> warehouseEntities;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String fullName, String phone, String email, List<WarehouseEntity> warehouseEntities) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.warehouseEntities = warehouseEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
