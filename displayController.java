/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.ListCourse;

/**
 *
 * @author MyPC
 */
public class displayController {
    
    ArrayList<Course> courseList;
    ListCourse listCourse;
    
    public displayController(ArrayList<Course> courseList, ListCourse listCourse) {
        this.courseList = courseList;
        this.listCourse = listCourse;
        listCourse.setResizable(false);
        listCourse.getTxtDisplay().setEditable(false);
        listCourse.getTxtDisplay().setText("");
        // sort course list by credit
        Collections.sort(courseList, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if (o1.getCredit() < o2.getCredit()) {
                    return -1;
                } else if (o1.getCredit() > o2.getCredit()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        // for each course in list
        for (Course course : courseList) {
            // display info of course list to text area
            listCourse.getTxtDisplay().append(course.toString());
        }
    }
    
}
