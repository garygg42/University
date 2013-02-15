package com.gladkiy.common.creaters;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.getters.UserGetter;
import com.gladkiy.common.model.Subject;

public class SubjectCreator {

    public static Subject createSubject(String title, String year, String semester,
            String lecturerid) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Subject subject = new Subject();
        subject.set_id(ObjectId.get().toString());
        subject.setLecturer(UserGetter.getUserById(lecturerid));
        subject.setSemester(Integer.parseInt(semester));
        subject.setTitle(title);
        subject.setYear(Integer.parseInt(year));

        mongoOperation.insert(subject);
        
        return subject;

    }

}
