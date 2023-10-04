package edu.uc.cech.soit.myclassjournal.service;

import edu.uc.cech.soit.myclassjournal.dto.JournalEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JournalService implements IJournalService{

    private Map<Integer, JournalEntry> allJournalEntries = new HashMap<>();

    /**
     * Save a new Journal Entry
     *
     * @param journalEntry the entry to save.
     */
    @Override
    public void save(JournalEntry journalEntry) {
        allJournalEntries.put(1, journalEntry);
    }

    /**
     * Return all journal entries.
     *
     * @return a collection of all journal entries.
     */
    @Override
    public List<JournalEntry> fetchAll() {
        return new ArrayList<>(allJournalEntries.values());
    }
}
