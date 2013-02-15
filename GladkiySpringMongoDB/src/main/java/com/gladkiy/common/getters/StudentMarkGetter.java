package com.gladkiy.common.getters;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gladkiy.common.model.StudentMark;

public class StudentMarkGetter {

    public static StudentMark getStudentMarkById(String id) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        StudentMark studentMark = mongoOperation.findOne(new Query(Criteria
                .where("_id").is(id)), StudentMark.class, "studentMarks");

        return studentMark;
    }

//    public static List<StudentMark> getStudentMarkByParameters(
//            String studentid, String mark, String date) {
//
//        @SuppressWarnings("resource")
//        ApplicationContext ctx = new GenericXmlApplicationContext(
//                "mongo-config.xml");
//
//        MongoOperations mongoOperation = (MongoOperations) ctx
//                .getBean("mongoTemplate");
//
//        Criteria bigCriteara = new Criteria();
//
//        if (!studentid.equals("any")) {
//            bigCriteara.and("student").is(UserGetter.getUserById(studentid));
//        }
//
//        if (!mark.equals("any")) {
//            bigCriteara.and("mark").is(Integer.parseInt(mark));
//        }
//
//        if (!date.equals("any")) {
//            bigCriteara.and("date").is(Long.parseLong(date));
//        }
//
//        List<StudentMark> studentMarks = mongoOperation.find(new Query(
//                bigCriteara), StudentMark.class, "studentMarks");
//
//        return studentMarks;
//    }
    
    public static List<StudentMark> getStudentMarkByParameters(
            String studentid, String mark, String dateFrom, String dateTo) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Criteria bigCriteara = new Criteria();

        if (!studentid.equals("any")) {
            bigCriteara.and("student").is(UserGetter.getUserById(studentid));
        }

        if (!mark.equals("any")) {
            bigCriteara.and("mark").is(Integer.parseInt(mark));
        }

        if (!dateFrom.equals("any")) {
            bigCriteara.and("date").gt(Long.parseLong(dateFrom));
        }
        
        if (!dateTo.equals("any")) {
            bigCriteara.and("date").lt(Long.parseLong(dateTo));
        }

        List<StudentMark> studentMarks = mongoOperation.find(new Query(
                bigCriteara), StudentMark.class, "studentMarks");

        return studentMarks;
    }
}
