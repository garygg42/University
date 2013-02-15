package com.gladkiy.common.updaters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.creaters.StudentMarkCreator;
import com.gladkiy.common.getters.SubjectJournalGetter;
import com.gladkiy.common.model.StudentMark;
import com.gladkiy.common.model.SubjectJournal;

public class SubjectJournalUpdater {
    public static SubjectJournal createStudentMark(String subjectJournalid,
            String studentid ,String mark, String date) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");
        
        SubjectJournal subjectJournal = SubjectJournalGetter.getSubjectJournalById(subjectJournalid);
        StudentMark studentMark = StudentMarkCreator.createStudentMark(studentid, mark, date);
        
        subjectJournal.addStudentMark(studentMark);
        
        mongoOperation.save(subjectJournal);

        return subjectJournal;
    }
}
