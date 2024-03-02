package SpringApp.mapper;

import SpringApp.dto.ContactDTO;
import SpringApp.entity.Contact;

/**
 * Třída pro mapování mezi objekty tříd Contact a ContactDTO
 */
public class ContactMapper {

    /**
     * Metoda pro mapování objektu typu Contact na objekt typu ContactDTO
     * @param contact - Objekt typu Contact, který má být zmapován na ContactDTO
     * @return Nový objekt typu ContactDTO získaný z objektu Contact
     */
    public static ContactDTO mapToContactDTO(Contact contact) {
        return new ContactDTO(
                contact.getId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber()
        );
    }

    /**
     * Metoda pro mapování objektu typu ContactDTO na objekt typu Contact
     * @param contactDTO - Objekt typu ContactDTO, který má být zmapován na Contact
     * @return Nový Objekt typu Contact získaný z objektu ContactDTO
     */
    public static Contact mapToContact(ContactDTO contactDTO) {
        return new Contact(
                contactDTO.getId(),
                contactDTO.getFirstName(),
                contactDTO.getLastName(),
                contactDTO.getPhoneNumber()
        );
    }
}
