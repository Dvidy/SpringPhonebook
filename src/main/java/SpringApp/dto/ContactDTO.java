package SpringApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object pro kontakt
 * Obsahuje informace o kontaktu: ID, jméno, příjmení a telefonní číslo
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
