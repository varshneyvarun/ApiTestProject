package com.assignment.lib.support;

import com.assignment.utils.JavaUtils;

public class TestData {


    public static int getIdValue(){
        return ((int)(Math.random()*1000));
    }

    public static String getAutoUserName(){
        return "AutoUsername_" + JavaUtils.getDateAndTime();
    }

    public static String getAutoFirstName(){
        return "AutoFirstName_" + JavaUtils.getDateAndTime();
    }

    public static String getAutoLastName(){
        return "AutoLastName_" + JavaUtils.getDateAndTime();
    }

    public static String getAutoPassword(){
        return "AutoPassword_" + JavaUtils.getDateAndTime();
    }

    public static String geAutoPhoneNumber(){
        return String.valueOf((int)(Math.random()*100000));
    }



    public static int getTagIdValue(){
        return ((int)(Math.random()*1000));
    }

    public static String getAutoTagName(){
        return "AutoTag_" + JavaUtils.getDateAndTime();
    }

    public static String getAutoCategoryName(){
        return "AutoCategory_" + JavaUtils.getDateAndTime();
    }

    public static String getAutoPetName(){
        return "AutoPet_" + JavaUtils.getDateAndTime();
    }
}
