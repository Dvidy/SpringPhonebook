package SpringApp.service.impl;

import SpringApp.dto.ContactDTO;
import SpringApp.entity.Contact;
import SpringApp.exception.ResourceNotFoundException;
import SpringApp.mapper.ContactMapper;
import SpringApp.repository.ContactRepository;
import SpringApp.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    /**
     * Vytvoří nový kontakt a uloží jej do databáze
     * @param contactDTO - Informace o novém kontaktu
     * @return Vytvořený kontakt
     */
    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.mapToContact(contactDTO);
        Contact savedContact = contactRepository.save(contact);
        return ContactMapper.mapToContactDTO(savedContact);
    }

    /**
     * Získá kontakt z databáze podle zadaného id
     * @param contactId - id hlednaného kontaktu
     * @return Hledaný kontakt
     * @throws ResourceNotFoundException - Pokud kontakt s daným Id neexsituje
     */
    @Override
    public ContactDTO getContactById(Long contactId) {
        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Kontakt s tímto id neexsituje : " + contactId));
        return ContactMapper.mapToContactDTO(contact);
    }

    /**
     * Získá seznam všech kontaktů uložených v databázi
     * @return Seznam všech kontaktů
     */
    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map((contact) -> ContactMapper.mapToContactDTO(contact)).collect(Collectors.toList());
    }

    /**
     * Aktualizuje existující kontakt v databázi na základě poskytnutých informací
     * @param contactId - Id aktualizovaného kontaktu
     * @param updatedContact - Nové informace o kontaktu
     * @return Aktualizovaný kontakt
     * @throws ResourceNotFoundException - Pokud kontakt s daným Id neexistuje
     */
    @Override
    public ContactDTO updateContact(Long contactId, ContactDTO updatedContact) {
        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Kontakt s tímto id neexsituje : " + contactId)
        );
        contact.setFirstName(updatedContact.getFirstName());
        contact.setLastName(updatedContact.getLastName());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        Contact updatedContactObj = contactRepository.save(contact);

        return ContactMapper.mapToContactDTO(updatedContactObj);
    }

    /**
     * Odstraní kontakt z databáze na základě zadaného identifikátoru
     * @param contactId - Id kontaktu k odstranění
     * @throws ResourceNotFoundException - Pokud kontakt s daným Id neexsituje
     */
    @Override
    public void deleteContact(Long contactId) {

        Contact contact = contactRepository.findById(contactId).orElseThrow(
                () -> new ResourceNotFoundException("Kontakt s tímto id neexsituje : " + contactId)
        );
        contactRepository.deleteById(contactId);
    }
}
