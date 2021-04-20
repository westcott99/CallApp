package com.example.callapp;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valcall {

    public static boolean validateCall(EditText editText, String errorMessage){
        Pattern pattern = Pattern.compile("^[6-8]{1}[0-9]{3}[0-9]{4}$");
        Matcher matcher = pattern.matcher(editText.getText().toString());
        if(!matcher.find()){
            editText.setError(errorMessage);
            return false;
        }
        return true;
    }
}
