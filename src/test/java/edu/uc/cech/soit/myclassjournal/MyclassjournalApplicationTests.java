package edu.uc.cech.soit.myclassjournal;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import edu.uc.cech.soit.myclassjournal.service.IJournalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MyclassjournalApplicationTests {

    @Autowired
    IJournalService journalService;

    @Test
    void contextLoads() {
    }

    /**
     * Validate that the DTO properties can be set and retrieved.
     */
    @Test
    void verifyJournalEntryProperties() {
        int id = 1;
        String notes =  "I am running a unit test";
        String date = "September 2021";

        JournalEntry journalEntry = new JournalEntry();

        journalEntry.setId(id);
        assertEquals(id, journalEntry.getId());

        journalEntry.setNotes(notes);
        assertEquals(notes, journalEntry.getNotes());

        journalEntry.setDate(date);
        assertEquals(date, journalEntry.getDate());
    }

    /**
     * Validate that the JournalService can save and return Journal Entries.
     */
    @Test
    void verifyAddAndRemoveJournalEntries() {
        int id = 2;
        String notes =  "My first entry!";
        String date = "October 2021";

        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setId(id);
        journalEntry.setNotes(notes);
        journalEntry.setDate(date);

        journalService.save(journalEntry);

        List<JournalEntry> journalEntries = journalService.fetchAll();
        boolean journalEntryPresent = false;
        for (JournalEntry je : journalEntries) {
            if (je.getNotes().equals(notes) && je.getDate().equals(date) &&je.getId() == id) {
                journalEntryPresent = true;
                break;
            }
        }

        assertTrue(journalEntryPresent);


    }

}
