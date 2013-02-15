package com.gladkiy.common.getters;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gladkiy.common.model.SubjectJournal;

public class SubjectJournalGetter {

    public static SubjectJournal getSubjectJournalById(String id) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        SubjectJournal subjectJournal = mongoOperation.findOne(new Query(
                Criteria.where("_id").is(id)), SubjectJournal.class,
                "subjectJournals");

        return subjectJournal;
    }

    public static List<SubjectJournal> getSubjectJournalByParameters(
            String subjectid) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Criteria bigCriteara = new Criteria();

        if (!subjectid.equals("any")) {
            bigCriteara.and("subject").is(
                    SubjectGetter.getSubjectById(subjectid));
        }

        List<SubjectJournal> subjectJournals = mongoOperation.find(new Query(
                bigCriteara), SubjectJournal.class, "subjectJournals");

        return subjectJournals;
    }
}
