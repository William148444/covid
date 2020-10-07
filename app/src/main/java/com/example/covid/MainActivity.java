package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.covid.extra.MESSAGE";
    public static final String Fever = "com.example.covid.extra.Fever";

    public EditText mMessageEditText; // helps find errors


    public EditText first; // help me edit the text with a vairable

    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    CheckBox checkbox4;
    CheckBox checkbox5;

    child child = new child(); // example of a child with using the app
    ArrayList<String> listOfS = new ArrayList<>(); // array list in which I can add all the sympotoms the child has

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);

        checkbox1= findViewById(R.id.checkBoxOne); // make checkboxes = the ones on the physical gui
        checkbox2= findViewById(R.id.checkBoxTwo);
        checkbox3= findViewById(R.id.checkBoxThree);
        checkbox4= findViewById(R.id.checkBoxFour);
        checkbox5= findViewById(R.id.checkBoxFive);
    }



    public void launchSecondActivity(View view) { // what I want to launch in the seocnd view
        Log.d(LOG_TAG, "button used"); // to send to next screen
        first = findViewById(R.id.editText_main); // make first equal to the "name" of the user
        String next = first.getText().toString(); // make next = to the string version of their "name"
        Intent intent = new Intent(this, actvivity_second.class); // package this and send to second activity
       String message = mMessageEditText.getText().toString();
       Boolean NAME = false; // this is to check if they have entered a name or not


       if(next.length() > 0){ // make name true if they have entered a letter in the text box
           NAME = true;
       }
       int count = 0; // make this to check ( if count > 0 ) -> they have a symptome and cannot attend
       Boolean school = true;
       if(checkbox1.isChecked() == true) {
           listOfS.add("Fever"); // add to list of symptomes
           child.listOfSymptoms.add("Fever"); // add to specific "child" list of sympotms
       count++;
       }
       if (checkbox2.isChecked() == true){
           listOfS.add("Aches");
           child.listOfSymptoms.add("Aches");
           count++;
       }
        if (checkbox3.isChecked() == true) {
            listOfS.add("Sore throat");
            child.listOfSymptoms.add("Sore throat");
            count++;
        }
        if (checkbox4.isChecked() == true) {
            listOfS.add("Cough");
            child.listOfSymptoms.add("Cough");
            count++;
        }
        if (checkbox5.isChecked() == true) {
            listOfS.add("Thrown up");
            child.listOfSymptoms.add("Thrown up");
            count++;
        }






        if (count > 0){
            school = false;} // if the count is > 0 , they cannot go to school



        System.out.println(findViewById(R.id.textViewTwo).toString());

        child.setName(NAME.toString()); // make the childs name = to NAME
       Log.d(LOG_TAG,findViewById(R.id.textViewTwo).toString()); // display in next activity
       intent.putExtra(EXTRA_MESSAGE, message); // package "message"
        intent.putExtra("name", NAME); // package "name"
        intent.putExtra("School1",school); // package "school" (true or false)
       intent.putExtra("ListOfSymptoms",listOfS); // package lis


      Log.d(LOG_TAG,NAME.toString());
        startActivity(intent);


}

}