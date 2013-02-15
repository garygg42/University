package com.gladkiy.common.test;

import java.util.List;

import com.gladkiy.common.creaters.GroupCreator;
import com.gladkiy.common.creaters.GroupJournalCreator;
import com.gladkiy.common.creaters.SubjectCreator;
import com.gladkiy.common.creaters.UserCreator;
import com.gladkiy.common.model.Group;
import com.gladkiy.common.model.GroupJournal;
import com.gladkiy.common.model.Subject;
import com.gladkiy.common.model.SubjectJournal;
import com.gladkiy.common.model.User;
import com.gladkiy.common.updaters.GroupJournalUpdater;
import com.gladkiy.common.updaters.SubjectJournalUpdater;

public class CreateAllTables {

    public static void main(String[] args) {
        /*
         * Создаём 3 группы и 1 группу преподавателей
         */
        Group PIGroup = GroupCreator.createGroup("PI", Integer.valueOf(2009)
                .toString());
        Group KIGroup = GroupCreator.createGroup("KI", Integer.valueOf(2009)
                .toString());
        Group INFGroup = GroupCreator.createGroup("INF", Integer.valueOf(2009)
                .toString());
        Group lecturersGroup = GroupCreator.createGroup("lecturers", Integer
                .valueOf(2000).toString());

        /*
         * Создаём по 10 юзеров для каждой группы
         */
        final int USER_COUNT = 10;
        User[] PIStudents = new User[USER_COUNT];
        User[] KIStudents = new User[USER_COUNT];
        User[] INFStudents = new User[USER_COUNT];
        User[] lecturers = new User[USER_COUNT];

        for (int i = 0; i < USER_COUNT; i++) {
            PIStudents[i] = UserCreator.createUser(Integer.valueOf(i)
                    .toString(), Integer.valueOf(i).toString(), Integer
                    .valueOf(i).toString(), PIGroup.get_id());

            KIStudents[i] = UserCreator.createUser(Integer.valueOf(i)
                    .toString(), Integer.valueOf(i).toString(), Integer
                    .valueOf(i).toString(), KIGroup.get_id());

            INFStudents[i] = UserCreator.createUser(Integer.valueOf(i)
                    .toString(), Integer.valueOf(i).toString(), Integer
                    .valueOf(i).toString(), INFGroup.get_id());

            lecturers[i] = UserCreator.createUser(Integer.valueOf(i).toString()
                    + "L", Integer.valueOf(i).toString() + "L", Integer
                    .valueOf(i).toString() + "L", lecturersGroup.get_id());
        }

        /*
         * Создаём 10 предметов
         */
        Subject[] subjects = new Subject[USER_COUNT];
        for (int i = 0; i < USER_COUNT; i++) {
            subjects[i] = SubjectCreator.createSubject("S" + i, 2010 + "",
                    1 + "", lecturers[i].get_id());
        }

        /*
         * Создаём 3 журнала группы
         */
        GroupJournal PIJournal = GroupJournalCreator.createGroupJournal(
                PIGroup.get_id(), "2010-2011");
        GroupJournal KIJournal = GroupJournalCreator.createGroupJournal(
                KIGroup.get_id(), "2010-2011");
        GroupJournal INFJournal = GroupJournalCreator.createGroupJournal(
                INFGroup.get_id(), "2010-2011");

        for (int i = 0; i < USER_COUNT; i++) {
            PIJournal = GroupJournalUpdater.createSubjectJournal(
                    PIJournal.get_id(), subjects[i].get_id());
            KIJournal = GroupJournalUpdater.createSubjectJournal(
                    KIJournal.get_id(), subjects[i].get_id());
            INFJournal = GroupJournalUpdater.createSubjectJournal(
                    INFJournal.get_id(), subjects[i].get_id());
        }

        List<SubjectJournal> PISubjects = PIJournal.getSubjectJournals();
        List<SubjectJournal> KISubjects = KIJournal.getSubjectJournals();
        List<SubjectJournal> INFSubjects = INFJournal.getSubjectJournals();

        for (int i = 0; i < PISubjects.size(); i++) {
            for (int j = 0; j < PIStudents.length; j++) {
                PISubjects.set(
                        i,
                        SubjectJournalUpdater.createStudentMark(
                                PISubjects.get(i).get_id(),
                                PIStudents[j].get_id(), "95", "this"));
            }

        }
        for (int i = 0; i < KISubjects.size(); i++) {
            for (int j = 0; j < KIStudents.length; j++) {
                KISubjects.set(
                        i,
                        SubjectJournalUpdater.createStudentMark(
                                KISubjects.get(i).get_id(),
                                KIStudents[j].get_id(), "95", "this"));
            }
        }
        for (int i = 0; i < INFSubjects.size(); i++) {
            for (int j = 0; j < INFStudents.length; j++) {
                INFSubjects.set(i, SubjectJournalUpdater.createStudentMark(
                        INFSubjects.get(i).get_id(), INFStudents[j].get_id(),
                        "95", "this"));
            }
        }
    }
}
