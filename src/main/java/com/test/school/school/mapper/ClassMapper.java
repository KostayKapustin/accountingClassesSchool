package com.test.school.school.mapper;

import com.test.school.school.dto.ClassDto;
import com.test.school.school.model.MyClass;

public class ClassMapper {

    public static ClassDto toClassDto(MyClass myClass) {
        return new ClassDto(myClass.getYearStudy(), myClass.getMnemonicCode(), myClass.getDirector(),
                myClass.getClassStudents());
    }

    public static MyClass toMyClass(ClassDto classDto) {
        MyClass myClass = new MyClass();
        myClass.setDirector(classDto.getDirector());
        myClass.setYearStudy(classDto.getYearStudy());
        myClass.setMnemonicCode(classDto.getMnemonicCode());
        myClass.setClassStudents(classDto.getClassStudents());
        return myClass;
    }
}
