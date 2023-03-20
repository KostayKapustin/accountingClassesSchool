package com.test.school.school.service;

import com.test.school.school.dto.TeacherDto;
import com.test.school.school.dto.UpdateTeacherDto;
import com.test.school.school.exception.TeacherNotFoundException;
import com.test.school.school.mapper.TeacherMapper;
import com.test.school.school.model.Teacher;
import com.test.school.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    @Override
    public List<TeacherDto> receiveTeacher() {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        List<Teacher> teachersList = repository.findAll();
        for (var teacherList : teachersList) {
            teacherDtos.add(TeacherMapper.toTeacherDto(teacherList));
        }
        return teacherDtos;
    }

    @Override
    public TeacherDto receiveTeacherById(Long id) {
        checkTeacher(id);
        return TeacherMapper.toTeacherDto(repository.findById(id).get());
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher = TeacherMapper.toTeacher(teacherDto);
        repository.save(teacher);
        return TeacherMapper.toTeacherDto(teacher);
    }

    @Override
    public TeacherDto updateTeacher(Long teacherId, UpdateTeacherDto updateTeacherDto) {
        checkTeacher(teacherId);
        Teacher teacher = TeacherMapper.toTeacher(receiveTeacherById(teacherId));
        Teacher newMyTeacher = new Teacher();
        try {
            newMyTeacher = teacher.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (updateTeacherDto.getFirstName() != null) {
            newMyTeacher.setFirstName(updateTeacherDto.getFirstName());
        }
        if (updateTeacherDto.getPatronymic() != null) {
            newMyTeacher.setPatronymic(updateTeacherDto.getPatronymic());
        }
        if (updateTeacherDto.getSurname() != null) {
            newMyTeacher.setSurname(updateTeacherDto.getSurname());
        }
        if (updateTeacherDto.getYearBirth() != 0) {
            newMyTeacher.setYearBirth(updateTeacherDto.getYearBirth());
        }
        if (updateTeacherDto.getMainSubject() != null) {
            newMyTeacher.setMainSubject(updateTeacherDto.getMainSubject());
        }
        repository.save(newMyTeacher);
        return TeacherMapper.toTeacherDto(newMyTeacher);
    }

    @Override
    public void deleteAllTeacher() {
        repository.findAll();
    }

    @Override
    public void deleteTeacherById(Long id) {
        checkTeacher(id);
        repository.deleteById(id);
    }

    @Override
    public List<TeacherDto> getSortedTeacher(String field) {
        List<TeacherDto> teacherDtos = new ArrayList<>();
        List<Teacher> teachersList = repository.findAll();
        Collections.sort(teachersList, new Comparator<Teacher>() {
            public int compare(Teacher o1, Teacher o2) {
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
                    case ("mainSubject"):
                        i = o1.getMainSubject().compareTo(o2.getMainSubject());
                        break;
                }
                return i;
            }
        });
        for (var teacherList : teachersList) {
            teacherDtos.add(TeacherMapper.toTeacherDto(teacherList));
        }
        return teacherDtos;
    }

    @Override
    public List<TeacherDto> getSelectionSurnameTeacher(String field) {
        List<Teacher> teacherList = new ArrayList<>();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherList = repository.selectionSurname(field);
        for (var teacher : teacherList) {
            teacherDtoList.add(TeacherMapper.toTeacherDto(teacher));
        }
        return teacherDtoList;
    }

    @Override
    public List<TeacherDto> getSelectionFirstNameTeacher(String field) {
        List<Teacher> teacherList = new ArrayList<>();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherList = repository.selectionFirstName(field);
        for (var teacher : teacherList) {
            teacherDtoList.add(TeacherMapper.toTeacherDto(teacher));
        }
        return teacherDtoList;
    }

    @Override
    public List<TeacherDto> getSelectionPatronymicTeacher(String field) {
        List<Teacher> teacherList = new ArrayList<>();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherList = repository.selectionPatronymic(field);
        for (var teacher : teacherList) {
            teacherDtoList.add(TeacherMapper.toTeacherDto(teacher));
        }
        return teacherDtoList;
    }

    @Override
    public List<TeacherDto> getSelectionYearBirthTeacher(String field) {
        List<Teacher> teacherList = new ArrayList<>();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherList = repository.selectionYearBirth(field);
        for (var teacher : teacherList) {
            teacherDtoList.add(TeacherMapper.toTeacherDto(teacher));
        }
        return teacherDtoList;
    }

    @Override
    public List<TeacherDto> getSelectionMainSubjectTeacher(String field) {
        List<Teacher> teacherList = new ArrayList<>();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        teacherList = repository.selectionMainSubject(field);
        for (var teacher : teacherList) {
            teacherDtoList.add(TeacherMapper.toTeacherDto(teacher));
        }
        return teacherDtoList;
    }

    private void checkTeacher(Long id) {
        repository.findById(id).orElseThrow(() -> new TeacherNotFoundException(id));
    }

}
