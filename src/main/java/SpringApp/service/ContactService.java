package SpringApp.service;

import SpringApp.dto.ContactDTO;

import java.util.List;

/**
 * Rozhraní pro manipulaci s kontakty
 */
public interface ContactService {

    // Vytvoří kontakt
    ContactDTO createContact(ContactDTO contactDTO);

    // Získá kontakt podle id
    ContactDTO getContactById(Long contactId);

    // Získá všechny kontakty
    List<ContactDTO> getAllContacts();

    // Aktualizuje kontakt
    ContactDTO updateContact(Long contactId, ContactDTO updatedContact);

    // Smaže kontakt
    void deleteContact(Long contactId);
}
