package com.gladkiy.common.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groupJournals")
public class GroupJournal {
    @Id
    private String _id;
    @DBRef
    private Group group;
    private String years;
    @DBRef
    private List<SubjectJournal> subjectJournals = new ArrayList<SubjectJournal>();
    
    /*
     * метод для добавления SubjectJournal в список subjectJournals
     */
    public void addSubjectJournal(SubjectJournal subjectJournal) {
        this.subjectJournals.add(subjectJournal);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public List<SubjectJournal> getSubjectJournals() {
        return subjectJournals;
    }

    public void setSubjectJournals(List<SubjectJournal> subjectJournals) {
        this.subjectJournals = subjectJournals;
    }

    @Override
    public String toString() {
        return "GroupJournal [_id=" + _id + ", group=" + group + ", years="
                + years + ", subjectJournals=" + subjectJournals + "]";
    }
    
}
