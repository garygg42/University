package com.gladkiy.common.creaters;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.getters.UserGetter;
import com.gladkiy.common.model.StudentMark;

public class StudentMarkCreator {

    public static StudentMark createStudentMark(String studentid, String mark,
            String date) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        StudentMark studentMark = new StudentMark();
        studentMark.set_id(ObjectId.get().toString());
        
        if(date.equals("this")) {
            studentMark.setDate(System.currentTimeMillis());
        } else {
            studentMark.setDate(Long.parseLong(date));
        }
        
        studentMark.setMark(Integer.parseInt(mark));
        studentMark.setStudent(UserGetter.getUserById(studentid));

        mongoOperation.insert(studentMark);

        return studentMark;
    }

}