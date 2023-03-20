package com.test.school.school.service;

import com.test.school.school.dto.ClassDto;
import com.test.school.school.dto.UpdateClassDto;
import com.test.school.school.exception.MyClassNotFoundException;
import com.test.school.school.exception.StudentNotFoundException;
import com.test.school.school.exception.TeacherNotFoundException;
import com.test.school.school.mapper.ClassMapper;
import com.test.school.school.model.MyClass;
import com.test.school.school.repository.ClassRepository;
import com.test.school.school.repository.StudentRepository;
import com.test.school.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository repository;

    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;

    @Override
    public List<ClassDto> receiveClass() {
        List<ClassDto> classDtoList = new ArrayList<>();
        List<MyClass> myClassList = repository.findAll();
        for (var classList : myClassList) {
            classDtoList.add(ClassMapper.toClassDto(classList));
        }
        return classDtoList;
    }

    @Override
    public ClassDto receiveClassById(Long id) {
        checkClass(id);
        return ClassMapper.toClassDto(repository.findById(id).get());
    }

    @Override
    public ClassDto addClass(ClassDto classDto) {
        MyClass myClass = ClassMapper.toMyClass(classDto);
        repository.save(myClass);
        return ClassMapper.toClassDto(myClass);
    }

    @Override
    public ClassDto addClassAndTeacher(Long classId, Long teacherId) {
        checkClass(classId);
        checkTeacher(teacherId);
        MyClass myClass = repository.findById(classId).get();
        myClass.setDirector(teacherRepository.findById(teacherId).get());
        repository.save(myClass);
        return ClassMapper.toClassDto(myClass);
    }

    @Override
    public ClassDto addClassAndStudent(Long classId, Long studentId) {
        checkClass(classId);
        checkStudent(studentId);
        MyClass myClass = repository.findById(classId).get();
        myClass.getClassStudents().add(studentRepository.findById(studentId).get());
        repository.save(myClass);
        return ClassMapper.toClassDto(myClass);
    }

    @Override
    public ClassDto updateClass(Long classId, UpdateClassDto updateClassDto) {
        checkClass(classId);
        MyClass myClass = ClassMapper.toMyClass(receiveClassById(classId));
        MyClass newMyClass = new MyClass();
        try {
            newMyClass = myClass.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (updateClassDto.getYearStudy() != 0) {
            newMyClass.setYearStudy(updateClassDto.getYearStudy());
        }
        if (updateClassDto.getMnemonicCode() != null) {
            newMyClass.setMnemonicCode(updateClassDto.getMnemonicCode());
        }
        if (updateClassDto.getDirector() != null) {
            newMyClass.setDirector(updateClassDto.getDirector());
        }
        if (updateClassDto.getClassStudents() != null) {
            newMyClass.setClassStudents(updateClassDto.getClassStudents());
        }
        repository.save(newMyClass);
        return ClassMapper.toClassDto(newMyClass);
    }

    @Override
    public void deleteAllClass() {
        repository.deleteAll();
    }

    @Override
    public void deleteClass(Long id) {
        checkClass(id);
        repository.findById(id);
    }

    @Override
    public List<ClassDto> getSortedClass(String field) {
        List<ClassDto> classSortedDto = new ArrayList<>();
        List<MyClass> myClassList = repository.findAll();
        Collections.sort(myClassList, new Comparator<MyClass>() {
            public int compare(MyClass o1, MyClass o2) {
                int i = 0;
                Integer y = 0;
                Integer x = 0;
                switch (field) {
                    case ("id"):
                        i = o1.getId().compareTo(o2.getId());
                        break;
                    case ("mnemonicCode"):
                        i = o1.getMnemonicCode().compareTo(o2.getMnemonicCode());
                        break;
                    case ("yearStudy"):
                        x = o1.getYearStudy();
                        y = o2.getYearStudy();
                        i = x.compareTo(y);
                        break;
                    case ("directorId"):
                        i = o1.getDirector().getId().compareTo(o2.getDirector().getId());
                        break;
                    case ("directorSurname"):
                        i = o1.getDirector().getSurname().compareTo(o2.getDirector().getSurname());
                        break;
                    case ("directorFirstName"):
                        i = o1.getDirector().getFirstName().compareTo(o2.getDirector().getFirstName());
                        break;
                    case ("directorPatronymic"):
                        i = o1.getDirector().getPatronymic().compareTo(o2.getDirector().getPatronymic());
                        break;
                    case ("directorYearBirth"):
                        x = o1.getDirector().getYearBirth();
                        y = o2.getDirector().getYearBirth();
                        i = x.compareTo(y);
                        break;
                    case ("directorMainSubject"):
                        i = o1.getDirector().getMainSubject().compareTo(o2.getDirector().getMainSubject());
                        break;
                    case ("directorClassStudents"):
                        x = o1.getClassStudents().size();
                        y = o2.getClassStudents().size();
                        i = x.compareTo(y);
                        break;
                }
                return i;
            }
        });
        for (var classList : myClassList) {
            classSortedDto.add(ClassMapper.toClassDto(classList));
        }
        return classSortedDto;
    }

    @Override
    public List<ClassDto> getSelectionYearStudyClass(int field) {
        List<MyClass> classSelect = new ArrayList<>();
        List<ClassDto> classDtoSelect = new ArrayList<>();
        classSelect = repository.selectionYearStudy(field);
        for (var classList : classSelect) {
            classDtoSelect.add(ClassMapper.toClassDto(classList));
        }
        return classDtoSelect;
    }

    private void checkClass(Long id) {
        repository.findById(id).orElseThrow(() -> new MyClassNotFoundException(id));
    }

    private void checkTeacher(Long id) {
        teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
    }

    private void checkStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }
}
