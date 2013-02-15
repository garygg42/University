package com.gladkiy.common.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subjectJournals")
public class SubjectJournal {
    @Id
    private String _id;
    @DBRef
    private Subject subject;
    @DBRef
    private List<StudentMark> studentMarks = new ArrayList<StudentMark>();
    
    /*
     * метод для добавления StudentMark в список studentMarks
     */
    public void addStudentMark(StudentMark studentMark) {
        this.studentMarks.add(studentMark);
    }
    
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public List<StudentMark> getStudentMarks() {
        return studentMarks;
    }
    public void setStudentMarks(List<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        return "SubjectJournal [_id=" + _id + ", subject=" + subject
                + ", studentMarks=" + studentMarks + "]";
    }
    
}
