package SpringApp.controller;

import SpringApp.dto.ContactDTO;
import SpringApp.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private ContactService contactService;

    /**
     * Metoda pro vytvoření nového kontaktu pomocí HTTP POST požadavku
     * @param contactDTO - Informace o novém kontaktu
     * @return ResponseEntity s vytvořeným kontaktem a status kodem 201 CREATED
     */
    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@RequestBody ContactDTO contactDTO) {
        ContactDTO savedContact = contactService.createContact(contactDTO);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    /**
     * Metoda pro získání kontaktu podle ID pomocí HTTP GET požadavku
     * @param contactId - ID kontaktu
     * @return ResponseEntity s nalezeným kontaktem a status kodem 200 OK
     */
    @GetMapping("{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable("id") Long contactId) {
        ContactDTO contactDTO = contactService.getContactById(contactId);
        return ResponseEntity.ok(contactDTO);
    }


    /**
     * Metoda pro získání seznamu všech kontaktů pomocí HTTP GET požadavku
     * @return ResponseEntity se seznamem kontaktů a status kodem 200 OK
     */
    @GetMapping
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        List<ContactDTO> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    /**
     * Metoda pro aktualizaci kontaktu pomocí HTTP PUT požadavku
     * @param contactId - ID kontaktu
     * @param updatedContact - Aktualizované informace o kontaktu
     * @return ResponseEntity s aktualizovaným kontaktem a status kodem 200OK
     */
    @PutMapping("{id}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable("id") Long contactId,
                                                    @RequestBody ContactDTO updatedContact) {
        ContactDTO contactDTO = contactService.updateContact(contactId, updatedContact);
        return ResponseEntity.ok(contactDTO);
    }

    /**
     * Metoda pro smazání kontaktu pomocí HTTP DELETE požadavku
     * @param contactId - ID kontaktu
     * @return ResponseEntity s textovou zprávou o úspěšném smazání a status kodem 200 OK
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.ok("Kontakt byl úspěšně smazán.");
    }
}
