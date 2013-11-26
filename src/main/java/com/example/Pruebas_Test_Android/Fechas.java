package com.example.Pruebas_Test_Android;

import android.app.Activity;
import android.os.Bundle;

public class Fechas extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public static String rebuilt_date(String date){
        String [] splidate=date.split("/");
        String new_date;

        if(splidate.length!=3) {new_date= date+" is illegal"; return new_date;}

        String day = splidate[1];
        String month = splidate[0];
        String year = splidate[2];

        if(day.length()==1) day="0"+day;
        if(month.length()==1) month="0"+month;
        if(year.length()==1) year="200"+year;
        else if(year.length()==2) year="20"+year;

        int year_int=Integer.parseInt(year);
        int month_int= Integer.parseInt(month);
        int day_int= Integer.parseInt(day);


        new_date=year+"-"+month+"-"+day;

        //Parte ilegal
        if(day.length()>2 || day.length()==0 || month.length()>2 || month.length()==0 || year.length()>4 || year.length()==0 || year.length()==3)  new_date= date+" is illegal";

        if(2000>year_int || year_int>2999) new_date= date+" is illegal";
        if(month_int<1 || month_int>12) new_date=date +" is illegal";

        switch (month_int){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                if(day_int>31 || day_int<1) new_date=date +" is illegal";
                break;
            case 2:
                if(year_int%4==0) {if(day_int>29 || day_int<1) new_date=date +" is illegal";}
                else {if(day_int>28 || day_int<1) new_date=date +" is illegal"; }
                break;
            default:
                if(day_int>30 || day_int<1) new_date=date +" is illegal";
                break;
        }


        return new_date;
    }
}
