package com.example.sweater.service;

import org.springframework.stereotype.Service;

@Service
public class CheckboxValeChecker {
    public Boolean check(String[] checkboxValue){
        try{
        if (checkboxValue[0] != null) {
            return true;
        } else {
            return false;
        }
        }catch (NullPointerException e){
            return false;
        }
    }
}
