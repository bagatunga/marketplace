package anaruiz.proyectofinal.dwes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad User
 * Representa a los usuarios del sistema
 * Se corresponde con la tabla "users"
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Clave primaria del usuario
     * Se genera automáticamente en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del usuario
     * - Obligatorio
     * - Longitud 20 caracteres
     */

    @NotBlank
    @Size(max = 20)
    private String name;

    /**
     * Apellidos de usuario
     * - Obligatorio
     * - Longitud 50 caracteres
     * - Debe ser único en la base de datos
     */
    @NotBlank
    @Size(max = 50)
    private String lastname;

    /**
     * Username
     * - Obligatorio
     * - Longitud 12 caracteres
     * - Debe ser único en la base de datos
     */
    @NotBlank
    @Size(max = 12)
    @Column(unique = true)
    private String username;

    /**
     * Email
     * - Obligatorio
     * - formato valido
     */
    @NotBlank
    @Column(unique = true)
    private String email;

    /**
     * Contraseña
     * - Obligatorio
     * - Longitud minima 4
     */
    @NotBlank
    @Size(min = 4)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * Enabled
     * - Obligatorio
     */

    @NotBlank
    private boolean enabled = true;

    /**
     * Indica si el usuario es administrador
     * - NO se guarda en base de datos (@Transient)
     * - Solo se usa durante el registro
     * - No se devuelve en respuestas JSON
     */
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    /**
     * Se ejecuta antes de guardar el usuario por primera vez
     * Activa el usuario automáticamente
     */
    @PrePersist
    public void prePersist() {
        enabled = true;
    }

    @JsonIgnoreProperties({ "users", "handler", "hibernateLazyInitializer" })
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
            "user_id", "role_id" }))
    private List<Role> roles = new ArrayList<>();

    @JsonIgnoreProperties({ "user", "cart", "handler", "hibernateLazyInitializer" })
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @JsonIgnoreProperties({ "user", "handler", "hibernateLazyInitializer" })
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cart = new ArrayList<>();

    public User() {
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

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}