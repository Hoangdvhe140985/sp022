/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import java.util.ArrayList;
import view.AddCourse;
import view.CourseManagement;
import view.ListCourse;
import view.SearchCourse;

/**
 *
 * @author MyPC
 */
public class formController {

    ArrayList<Course> courseList;
    CourseManagement mainFrame;
    AddCourse addCourse;
    ListCourse listCourse;
    SearchCourse searchCourse;
    

    public formController() {
        mainFrame = new CourseManagement();
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        courseList = new ArrayList<>();
        action();
    }

    public void action() {
        mainFrame.getBtAdd().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourse = new AddCourse(mainFrame, true, courseList);
                addCourse.setVisible(true);
            }
        });

        mainFrame.getBtDisplay().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCourse = new ListCourse(mainFrame, true, courseList);
                listCourse.setVisible(true);
            }
        });

        mainFrame.getBtSearch().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCourse = new SearchCourse(mainFrame, true, courseList);
                searchCourse.setVisible(true);
            }
        });

        mainFrame.getBtExit().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
    }
}
