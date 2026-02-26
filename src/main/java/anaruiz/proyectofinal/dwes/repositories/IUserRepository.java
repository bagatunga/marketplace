package anaruiz.proyectofinal.dwes.repositories;

import org.springframework.data.repository.CrudRepository;

import anaruiz.proyectofinal.dwes.entities.User;

import java.util.Optional;

/**
 * Repositorio de acceso a datos para la entidad User
 * 
 * Spring Data JPA se encarga de crear automáticamente
 * la implementación de esta interfaz
 */
public interface IUserRepository extends CrudRepository<User, Long> {
    /**
     * Comprueba si existe un usuario con el nombre indicado
     * 
     * Spring Data JPA genera automáticamente la consulta:
     * 
     * SELECT COUNT(*) > 0 FROM users WHERE username = ?
     * 
     * Se usa en la validación personalizada @ExistsByUsername
     *
     * @param username nombre de usuario
     * @return true si ya existe, false en caso contrario
     */
    boolean existsByUsername(String username);

    /**
     * Comprueba si existe un usuario con el email indicado
     * 
     * Spring Data JPA genera automáticamente la consulta:
     * 
     * SELECT COUNT(*) > 0 FROM users WHERE email = ?
     * 
     * Se usa en la validación personalizada @ExistsByEmail
     *
     * @param email email de usuario
     * @return true si ya existe, false en caso contrario
     */
    boolean existsByEmail(String email);

    /**
     * Busca un usuario por su nombre de usuario
     * 
     * Spring Data JPA genera automáticamente la consulta:
     * 
     * SELECT * FROM users WHERE username = ?
     * 
     * Se utiliza para:
     * - Autenticación
     * - Asignación de roles
     * - Consultas personalizadas
     *
     * @param username nombre de usuario
     * @return Optional con el usuario si existe
     */
    Optional<User> findByUsername(String username);
}