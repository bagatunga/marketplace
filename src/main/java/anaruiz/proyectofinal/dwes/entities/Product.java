package anaruiz.proyectofinal.dwes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entidad Product
 * Representa la tabla "products" en la base de datos
 */
@Entity
@Table(name = "products")
public class Product {

    /**
     * Clave primaria del producto
     * Se genera automáticamente (AUTO_INCREMENT en MySQL)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Name del producto
     * - Obligatorio
     * - Maximo 20 caracteres
     */
    @NotBlank
    @Size(max = 20)
    private String name;
    
    /**
     * Price del producto
     * - Obligatorio
     * - Mayor que 0
     */
    @Min(value = 1, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    /**
     * Stock del producto
     * - Obligatorio
     * - Mayor o igual a 0
     */
    @Min(value = 0, message = "{Min.product.stock}")
    @NotNull(message = "{NotNull.product.stock}")
    private Integer stock;

    /**
     * Descriptio del producto
     * - Obligatorio
     * - 255 caracteres
     */
    @NotBlank
    @Size(max = 255)
    private String description;

    // Vendedor
    @JsonIgnoreProperties({ "password", "roles", "products", "cart", "handler", "hibernateLazyInitializer" })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Product() {
    }

    /*
     * ==========================
     * GETTERS & SETTERS
     * ==========================
     */

    public Long getId() {
        return id;
    }

    public Integer getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }
}