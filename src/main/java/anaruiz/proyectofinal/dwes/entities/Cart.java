package anaruiz.proyectofinal.dwes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


/**
 * Entidad Cart
 * Representa a los productos del carrito
 * Se corresponde con la tabla "cart"
 */
@Entity
@Table(name = "cart")
public class Cart {

    /**
     * Clave primaria del carrito
     * Se genera automáticamente en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        /**
     *  Cantidad del carrito
     * - Obligatorio 
     * - Mayor que 0
     * - Indico el name ya que el atributo lo he llamado de manera distinta
     */
    @NotNull
    @Column(name = "cantidad")
    private Integer quantity;

    @JsonIgnoreProperties({ "password", "roles", "products", "cart", "handler", "hibernateLazyInitializer" })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    // Columna FK en cart que apunta a la PK de users
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties({ "handler", "hibernateLazyInitializer" })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    // Columna FK en cart que apunta a la PK de products
    @JoinColumn(name = "product_id")
    private Product product;

    public Cart() {
    }

    /*
     * ==========================
     * GETTERS & SETTERS
     * ==========================
     */

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}