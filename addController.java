/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Validate;
import entity.Course;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.AddCourse;

/**
 *
 * @author Bee
 */
public class addController {

    ArrayList<Course> courseList;
    AddCourse addCourse;
    Validate validate = new Validate();

    public addController(ArrayList<Course> courseList, AddCourse addCourse) {
        this.courseList = courseList;
        this.addCourse = addCourse;
        addCourse.setResizable(false);

        this.addCourse.getBtAdd().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourse();
            }
        });
        this.addCourse.getBtClear().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourse.getTxtCode().setText("");
                addCourse.getTxtName().setText("");
                addCourse.getTxtCredit().setText("");
            }
        });
    }

    // get message when checking input
    public String getMessOfVerifyInput() {
        String check = "";
        String checkEmp = "";
        if (validate.checkString(addCourse.getTxtCode().getText())) {
            checkEmp += "Code is null. ";
        } else {
            if (validate.checkCodeExist(courseList, addCourse.getTxtCode().getText())) {
                check += "\nCode is existed";
            }
        }
        if (validate.checkString(addCourse.getTxtName().getText())) {
            checkEmp += "Name is null. ";
        }
        if (validate.checkString(addCourse.getTxtCredit().getText())) {
            checkEmp += "Credit is null.";
        } else {
            int creValidate = validate.validPosInt(addCourse.getTxtCredit().getText());
            switch (creValidate) {
                case -1:
                    check += "\nCredit must be a positive number";
                    break;
                case 0:
                    check += "\nCredit must be less or equal than 33";
                    break;
            }
        }
        return checkEmp.trim() + check.trim();
    }

    // get infomation from form 
    public Course getInfoForm() {
        String code = addCourse.getTxtCode().getText().trim();
        String name = validate.formatString(validate.formatString(addCourse.getTxtName().getText()));
        String credit = addCourse.getTxtCredit().getText().trim();
        return new Course(code, name, Integer.parseInt(credit));
    }

    public void addCourse() {
        String checkInput = getMessOfVerifyInput();
        // valid input
        if (checkInput.isEmpty()) {
            Course course = getInfoForm();
            courseList.add(course);
            JOptionPane.showMessageDialog(addCourse, "Add successfully");
        } else {
            JOptionPane.showMessageDialog(addCourse, checkInput);
        }
    }

}
