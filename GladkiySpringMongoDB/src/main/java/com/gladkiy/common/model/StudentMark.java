package com.gladkiy.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "studentMarks")
public class StudentMark {
    @Id
    private String _id;
    @DBRef
    private User student;
    private int mark;
    private long date;
    
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public User getStudent() {
        return student;
    }
    public void setStudent(User student) {
        this.student = student;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public long getDate() {
        return date;
    }
    public void setDate(long date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "StudentMark [_id=" + _id + ", student=" + student + ", mark="
                + mark + ", date=" + date + "]";
    }

}
