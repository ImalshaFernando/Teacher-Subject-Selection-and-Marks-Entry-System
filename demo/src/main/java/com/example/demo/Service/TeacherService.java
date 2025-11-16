package com.example.demo.Service;

import com.example.demo.Model.Teacher;
import com.example.demo.Repo.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepo teacherRepository;

    public TeacherService(TeacherRepo teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existing = getTeacherById(id);
        if (existing == null) return null;

        existing.setName(teacher.getName());
        existing.setEmail(teacher.getEmail());

        return teacherRepository.save(existing);
    }

    public boolean deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) return false;
        teacherRepository.deleteById(id);
        return true;
    }
}
