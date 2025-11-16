package com.example.demo.Service;

import com.example.demo.Model.Subject;
import com.example.demo.Repo.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepo subjectRepository;

    public SubjectService(SubjectRepo subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject updateSubject(Long id, Subject subject) {
        Subject existing = getSubjectById(id);
        if (existing == null) return null;

        existing.setName(subject.getName());

        return subjectRepository.save(existing);
    }

    public boolean deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) return false;
        subjectRepository.deleteById(id);
        return true;
    }
}
