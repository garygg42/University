package com.gladkiy.common.creaters;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.getters.GroupGetter;
import com.gladkiy.common.model.GroupJournal;

public class GroupJournalCreator {
    
    public static GroupJournal createGroupJournal(String groupid,
             String years) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");
        
        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");
        
        GroupJournal groupJournal = new GroupJournal();
        groupJournal.set_id(ObjectId.get().toString());
        groupJournal.setGroup(GroupGetter.getGroupById(groupid));
        groupJournal.setYears(years);
        
        mongoOperation.insert(groupJournal);
        
        return groupJournal;
    }

}
