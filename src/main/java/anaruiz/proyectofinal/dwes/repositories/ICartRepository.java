package anaruiz.proyectofinal.dwes.repositories;

import org.springframework.data.repository.CrudRepository;

import anaruiz.proyectofinal.dwes.entities.Cart;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de acceso a datos para la entidad {@link Cart}.
 *
 * Spring Data JPA genera automáticamente la implementación y las consultas
 * a partir del nombre de los métodos (query derivation).
 *
 * Al extender {@link CrudRepository} se obtienen las operaciones CRUD básicas:
 * guardar, borrar, buscar por id, listar, etc.
 */
public interface ICartRepository extends CrudRepository<Cart, Long> {

    /**
     * Obtiene todos los registros del carrito asociados a un usuario.
     *
     * Spring Data JPA genera automáticamente la consulta:
     * SELECT * FROM cart WHERE user_id = ?
     *
     * Uso mostrar el carrito del usuario autenticado.
     *
     * @param userId id del usuario propietario del carrito
     * @return lista de items del carrito del usuario
     */
    List<Cart> findByUserId(Long userId);

    /**
     * Busca un item del carrito por su id asegurandeose que pertenece al usuario indicado.
     *
     * Spring Data JPA genera automáticamente la consulta:
     * SELECT * FROM cart WHERE id = ? AND user_id = ?
     *
     * Esto ayuda a controlar permisos evita que un usuario acceda o borre items
     * de carritos ajenos simplemente probando IDs.
     *
     * @param id     id del item del carrito
     * @param userId id del usuario propietario
     * @return Optional con el item si existe y pertenece al usuario, o vacío si no
     */
    Optional<Cart> findByIdAndUserId(Long id, Long userId);
}