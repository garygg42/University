package com.gladkiy.common.getters;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gladkiy.common.model.Subject;

public class SubjectGetter {

    public static Subject getSubjectById(String id) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Subject subject = mongoOperation.findOne(new Query(Criteria
                .where("_id").is(id)), Subject.class, "subjects");

        return subject;
    }

    public static List<Subject> getSubjectByParameters(String title,
            String year, String semester, String lecturer) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Criteria bigCriteara = new Criteria();

        if (!title.equals("any")) {
            bigCriteara.and("title").is(title);
        }

        if (!year.equals("any")) {
            bigCriteara.and("year").is(Integer.parseInt(year));
        }

        if (!semester.equals("any")) {
            bigCriteara.and("semester").is(Integer.parseInt(semester));
        }

        if (!semester.equals("any")) {
            bigCriteara.and("lecturer").is(UserGetter.getUserById(lecturer));
        }

        List<Subject> subjects = mongoOperation.find(new Query(bigCriteara),
                Subject.class, "subjects");

        return subjects;
    }
}
