package anaruiz.proyectofinal.dwes.repositories;

import org.springframework.data.repository.CrudRepository;

import anaruiz.proyectofinal.dwes.entities.Product;

import java.util.List;

/**
 * Repositorio de acceso a datos para la entidad Product.
 *
 * Spring Data JPA genera automáticamente la implementación 
 * a partir de esta interfaz
 */
public interface IProductRepository extends CrudRepository<Product, Long> {

    /**
     * Obtiene todos los productos que pertenecen al usuario indicado.
     *
     * Spring Data JPA genera automáticamente la consulta:
     * SELECT * FROM products WHERE user_id = ?
     *
     * Uso paralistar mis productos.
     *
     * @param userId id del usuario propietario de los productos
     * @return lista de productos cuyo user.id coincide con el indicado
     */
    List<Product> findByUserId(Long userId);

    /**
     * Obtiene todos los productos que NO pertenecen al usuario indicado.
     *
     * Spring Data JPA genera automáticamente la consulta:
     * SELECT * FROM products WHERE user_id <> ?
     *
     * Uso mostrar marketplace sin incluir los productos del usuario autenticado.
     *
     * @param userId id del usuario a excluir como propietario
     * @return lista de productos cuyo user.id es distinto del indicado
     */
    List<Product> findByUserIdNot(Long userId);
}