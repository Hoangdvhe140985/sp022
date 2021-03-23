/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Course;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.SearchCourse;

/**
 *
 * @author MyPC
 */
public class searchController {

    ArrayList<Course> courseList;
    SearchCourse searchCourse;

    public searchController(ArrayList<Course> courseList, SearchCourse searchCourse) {
        this.courseList = courseList;
        this.searchCourse = searchCourse;
        searchCourse.setResizable(false);
        searchCourse.getTxtName().setEditable(false);
        searchCourse.getTxtCredit().setEditable(false);
        search();
    }

    public void search() {
        searchCourse.getBtSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchCode = searchCourse.getTxtCode().getText().trim();
                //search code cannot empty
                if (searchCode.isEmpty()) {
                    JOptionPane.showMessageDialog(searchCourse, "You need to enter code");
                    return;
                }
                //for each course in list
                for (Course c : courseList) {
                    //if found search code, show it
                    if (searchCode.equals(c.getCode())) {
                        searchCourse.getTxtName().setText(c.getName());
                        searchCourse.getTxtCredit().setText(c.getCredit() + "");
                        return;
                    }
                }
                // not found course in course list
                searchCourse.getTxtName().setText("<none>");
                searchCourse.getTxtCredit().setText("<none>");
            }
        });

    }
}
