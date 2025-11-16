package com.example.demo.Service;

import com.example.demo.Model.Marks;
import com.example.demo.Repo.MarksRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksEntryService {

    private final MarksRepo marksEntryRepository;

    public MarksEntryService(MarksRepo marksEntryRepository) {
        this.marksEntryRepository = marksEntryRepository;
    }

    public Marks addMarks(Marks marks) {
        return marksEntryRepository.save(marks);
    }

    public List<Marks> getAllMarks() {
        return marksEntryRepository.findAll();
    }

    public Marks getMarksById(Long id) {
        return marksEntryRepository.findById(id).orElse(null);
    }

    public boolean deleteMarks(Long id) {
        if (!marksEntryRepository.existsById(id)) return false;
        marksEntryRepository.deleteById(id);
        return true;
    }
}
