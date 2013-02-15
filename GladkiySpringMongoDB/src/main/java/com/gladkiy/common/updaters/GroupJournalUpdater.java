package com.gladkiy.common.updaters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.creaters.SubjectJournalCreator;
import com.gladkiy.common.getters.GroupJournalGetter;
import com.gladkiy.common.model.GroupJournal;
import com.gladkiy.common.model.SubjectJournal;

public class GroupJournalUpdater {

    public static GroupJournal createSubjectJournal(String groupJournalid,
            String subjectid) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        GroupJournal groupJournal = GroupJournalGetter
                .getGroupJournalById(groupJournalid);
        SubjectJournal subjectJournal = SubjectJournalCreator
                .createSubjectJournal(subjectid);


        groupJournal.addSubjectJournal(subjectJournal);
        
        mongoOperation.save(groupJournal);
        
        return groupJournal;
    }

}
