package anaruiz.proyectofinal.dwes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad Role
 * Representa los roles de seguridad del sistema (USER, ADMIN, etc.)
 * Se corresponde con la tabla "roles" en la base de datos
 */
@Entity
@Table(name = "roles")
public class Role {

    /**
     * Clave primaria del rol
     * Se genera automáticamente en la BD (AUTO_INCREMENT)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del rol
     * Debe ser único y he considerado que no debe ser nulo (ROLE_USER, ROLE_ADMIN,
     * etc.)
     */
    @Column(unique = true, nullable = false)
    private String name; // ROLE_USER, ROLE_ADMIN

    /**
     * Relación Many-to-Many con User
     * mappedBy indica que la tabla intermedia la gestiona User
     * 
     * @JsonIgnoreProperties evita referencias circulares al serializar JSON
     */
    @JsonIgnoreProperties({ "roles", "products", "cart", "password", "handler", "hibernateLazyInitializer" })
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    /**
     * Constructor por defecto
     * Inicializa la lista de usuarios
     */
    public Role() {
        this.users = new ArrayList<>();
    }

    /**
     * Constructor con nombre
     */
    public Role(String name) {
        this.name = name;
    }

    /*
     * ==========================
     * GETTERS & SETTERS
     * ==========================
     */

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}