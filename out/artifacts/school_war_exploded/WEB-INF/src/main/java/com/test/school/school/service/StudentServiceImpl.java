package com.test.school.school.service;

import com.test.school.school.dto.StudentDto;
import com.test.school.school.dto.UpdateStudentDto;
import com.test.school.school.exception.StudentNotFoundException;
import com.test.school.school.mapper.StudentMapper;
import com.test.school.school.model.Student;
import com.test.school.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<StudentDto> receiveStudent() {
        List<StudentDto> studentDto = new ArrayList<>();
        List<Student> studentsList = repository.findAll();
        for (var studentList : studentsList) {
            studentDto.add(StudentMapper.toStudentDto(studentList));
        }
        return studentDto;
    }

    @Override
    public StudentDto receiveStudentById(Long id) {
        checkStudent(id);
        return StudentMapper.toStudentDto(repository.findById(id).get());
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = StudentMapper.toStudent(studentDto);
        repository.save(student);
        return StudentMapper.toStudentDto(student);
    }

    @Override
    public StudentDto updateStudent(Long studentId, UpdateStudentDto updateStudentDto){
        checkStudent(studentId);
        Student student = StudentMapper.toStudent(receiveStudentById(studentId));
        Student newMyStudent = new Student();
        try {
            newMyStudent = student.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (updateStudentDto.getFirstName() != null) {
            newMyStudent.setFirstName(updateStudentDto.getFirstName());
        }
        if (updateStudentDto.getPatronymic() != null) {
            newMyStudent.setPatronymic(updateStudentDto.getPatronymic());
        }
        if (updateStudentDto.getSurname() != null) {
            newMyStudent.setSurname(updateStudentDto.getSurname());
        }
        if (updateStudentDto.getYearBirth() != 0) {
            newMyStudent.setYearBirth(updateStudentDto.getYearBirth());
        }
        if (updateStudentDto.getGender() != null) {
            newMyStudent.setGender(updateStudentDto.getGender());
        }
        repository.save(newMyStudent);
        return StudentMapper.toStudentDto(newMyStudent);
    }



    @Override
    public void deleteAllStudent() {
        repository.deleteAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        checkStudent(id);
        repository.deleteById(id);
    }

    @Override
    public List<StudentDto> getSortedStudent(String field) {
        List<StudentDto> studentsDto = new ArrayList<>();
        List<Student> studentsList = repository.findAll();
        Collections.sort(studentsList, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                int i = 0;
                switch (field) {
                    case ("id"):
                        i = o1.getId().compareTo(o2.getId());
                        break;
                    case ("surname"):
                        i = o1.getSurname().compareTo(o2.getSurname());
                        break;
                    case ("firstName"):
                        i = o1.getFirstName().compareTo(o2.getFirstName());
                        break;
                    case ("patronymic"):
                        i = o1.getPatronymic().compareTo(o2.getPatronymic());
                        break;
                    case ("yearBirth"):
                        Integer j = o1.getYearBirth();
                        Integer l = o2.getYearBirth();
                        i = j.compareTo(l);
                        break;
                    case ("gender"):
                        i = o1.getGender().compareTo(o2.getGender());
                        break;
                }
                return i;
            }
        });
        for (var studentList : studentsList) {
            studentsDto.add(StudentMapper.toStudentDto(studentList));
        }
        return studentsDto;
    }

    @Override
    public List<StudentDto> getSelectionSurnameStudent(String field) {
        List<Student> studentList = new ArrayList<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentList = repository.selectionSurname(field);
        for (var student : studentList) {
            studentDtoList.add(StudentMapper.toStudentDto(student));
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> getSelectionFirstNameStudent(String field) {
        List<Student> studentList = new ArrayList<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentList = repository.selectionFirstName(field);
        for (var student : studentList) {
            studentDtoList.add(StudentMapper.toStudentDto(student));
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> getSelectionPatronymicStudent(String field) {
        List<Student> studentList = new ArrayList<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentList = repository.selectionPatronymic(field);
        for (var student : studentList) {
            studentDtoList.add(StudentMapper.toStudentDto(student));
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> getSelectionYearBirthStudent(String field) {
        List<Student> studentList = new ArrayList<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentList = repository.selectionYearBirth(field);
        for (var student : studentList) {
            studentDtoList.add(StudentMapper.toStudentDto(student));
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> getSelectionGenderStudent(String field) {
        List<Student> studentList = new ArrayList<>();
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentList = repository.selectionGender(field);
        for (var student : studentList) {
            studentDtoList.add(StudentMapper.toStudentDto(student));
        }
        return studentDtoList;
    }

    private void checkStudent(Long id) {
        repository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }
}
