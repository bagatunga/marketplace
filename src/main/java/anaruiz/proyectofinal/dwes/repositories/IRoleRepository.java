package anaruiz.proyectofinal.dwes.repositories;

import org.springframework.data.repository.CrudRepository;

import anaruiz.proyectofinal.dwes.entities.Role;

import java.util.Optional;

/**
 * Repositorio de acceso a datos para la entidad Role
 * 
 * Spring Data JPA genera automáticamente la implementación
 * de esta interfaz en tiempo de ejecución
 */
public interface IRoleRepository extends CrudRepository<Role, Long> {
    /**
     * Busca un rol por su nombre
     * 
     * Spring Data JPA genera automáticamente la consulta:
     * 
     * SELECT * FROM roles WHERE name = ?
     * 
     * Se utiliza principalmente para asignar roles a usuarios
     * durante el registro o la creación de usuarios
     *
     * @param name Nombre del rol (ROLE_USER, ROLE_ADMIN, etc.)
     * @return Optional con el rol si existe
     */
    Optional<Role> findByName(String name);
}