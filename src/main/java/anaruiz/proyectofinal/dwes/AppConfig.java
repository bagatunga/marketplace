package anaruiz.proyectofinal.dwes;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Clase de configuración de la aplicación
 * 
 * @Configuration → indica que es una clase de configuración de Spring
 * @PropertySource → carga un archivo de propiedades externo
 */
@Configuration
@PropertySource("classpath:messages.properties")
public class AppConfig {

}
