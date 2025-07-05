package mx.edu.utez.unidadtres.modules.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import mx.edu.utez.unidadtres.modules.user.BeanUser;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "rol")
    @JsonIgnore
    private List<BeanUser> userList = new ArrayList<>();

    public Rol() {
    }

    public Rol(Long id, String name, List<BeanUser> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BeanUser> getUserList() {
        return userList;
    }

    public void setUserList(List<BeanUser> userList) {
        this.userList = userList;
    }
}
