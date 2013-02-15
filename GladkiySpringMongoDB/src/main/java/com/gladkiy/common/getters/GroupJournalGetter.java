package com.gladkiy.common.getters;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.gladkiy.common.model.GroupJournal;

public class GroupJournalGetter {

    public static GroupJournal getGroupJournalById(String id) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        GroupJournal groupJournal = mongoOperation.findOne(new Query(Criteria
                .where("_id").is(id)), GroupJournal.class, "groupJournals");

        return groupJournal;
    }

    public static List<GroupJournal> getGroupJournalByParameters(
            String groupid, String years) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Criteria bigCriteara = new Criteria();

        if (!groupid.equals("any")) {
            bigCriteara.and("group").is(GroupGetter.getGroupById(groupid));
        }

        if (!years.equals("any")) {
            bigCriteara.and("years").is(Integer.parseInt(years));
        }

        List<GroupJournal> groupJournals = mongoOperation.find(new Query(bigCriteara),
                GroupJournal.class, "groupJournals");

        return groupJournals;
    }
}
