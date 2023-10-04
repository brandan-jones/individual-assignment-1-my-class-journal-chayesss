package edu.uc.cech.soit.myclassjournal.dto;


import lombok.Data;

@Data
public class JournalEntry {

    /**
     * id of journal entry
     */
    private int id;
    /**
     * Journal entry notes
     */
    private String notes;
    /**
     * Date of Journal Entry
     */
    private String date;
}
