package com.example.demo.Controller;

import com.example.demo.Model.Marks;
import com.example.demo.Service.MarksEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksEntryController {

    private final MarksEntryService marksEntryService;

    public MarksEntryController(MarksEntryService marksEntryService) {
        this.marksEntryService = marksEntryService;
    }

    @PostMapping
    public Marks addMarks(@RequestBody Marks marksEntry) {
        return marksEntryService.addMarks(marksEntry);
    }

    @GetMapping
    public List<Marks> getAllMarks() {
        return marksEntryService.getAllMarks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marks> getMarksById(@PathVariable Long id) {
        Marks marksEntry = marksEntryService.getMarksById(id);
        if (marksEntry == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(marksEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarks(@PathVariable Long id) {
        if (marksEntryService.deleteMarks(id)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
