package mx.edu.utez.unidadtres.modules.warehouse;

import jakarta.persistence.*;
import mx.edu.utez.unidadtres.modules.cede.CedeEntity;
import mx.edu.utez.unidadtres.modules.cliente.ClientEntity;

import java.util.List;

@Table(name = "warehouse")
@Entity
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private Double sellPrice;

    @Column(nullable = false)
    private Double rentPrice;

    @ManyToOne
    @JoinColumn(name = "id_cede", nullable = false)
    private CedeEntity cede;


    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientEntity client;

    public WarehouseEntity() {
    }

    public WarehouseEntity(Long id, String status, String clave, Double sellPrice, Double rentPrice, CedeEntity cede, ClientEntity client) {
        this.id = id;
        this.status = status;
        this.clave = clave;
        this.sellPrice = sellPrice;
        this.rentPrice = rentPrice;
        this.cede = cede;
        this.client = client;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public CedeEntity getCede() {
        return cede;
    }

    public void setCede(CedeEntity cede) {
        this.cede = cede;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
