package com.gladkiy.common.creaters;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.gladkiy.common.model.Group;

public class GroupCreator {

    public static Group createGroup(String title, String year) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new GenericXmlApplicationContext(
                "mongo-config.xml");

        MongoOperations mongoOperation = (MongoOperations) ctx
                .getBean("mongoTemplate");

        Group group = new Group();
        group.set_id(ObjectId.get().toString());
        group.setTitle(title);
        group.setYear(Integer.parseInt(year));

        mongoOperation.insert(group);
        
        return group;
    }

}
