package SpringApp.repository;

import SpringApp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Rozhraní, které rozšiřuje funkcionalitu poskytovanou rozhraním JpaRepository
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
