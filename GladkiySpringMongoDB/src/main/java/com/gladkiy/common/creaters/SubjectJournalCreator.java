package com.gladkiy.common.creaters;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.getters.SubjectGetter;
import com.gladkiy.common.model.SubjectJournal;

public class SubjectJournalCreator {

    public static SubjectJournal createSubjectJournal(String subjectid) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        SubjectJournal subjectJournal = new SubjectJournal();
        subjectJournal.set_id(ObjectId.get().toString());
        subjectJournal.setSubject(SubjectGetter.getSubjectById(subjectid));

        mongoOperation.insert(subjectJournal);

        return subjectJournal;
    }

}