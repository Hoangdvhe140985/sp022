/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class Validate {

    public boolean checkString(String string) {
        return string.trim().isEmpty();
    }

    public String formatString(String string) {
        String result = "";
        String[] words = string.toLowerCase().split("\\s+");
        for (String word : words) {
            String temp = "";
            temp += String.valueOf(word.charAt(0)).toUpperCase();
            for (int i = 1; i < word.length(); i++) {
                temp += word.charAt(i);
            }
            result += temp + " ";
        }
        return result.trim();
    }

    public boolean checkCodeExist(ArrayList<Course> courseList, String code) {
        // for each course in course list
        for (Course course : courseList) {
            // if code is existed in course list => duplicate
            if (code.equals(course.getCode())) {
                return true;
            }
        }
        return false;
    }

    public int validPosInt(String credit) {
        try {
            int cre = Integer.parseInt(credit);
            if (cre < 0 || cre > 33) {
                return 0;
            }
            return 1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
