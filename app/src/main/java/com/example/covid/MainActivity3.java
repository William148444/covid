package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity3 extends AppCompatActivity {


    private static final String LOGTAG ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Stack<Object> children = new LinkedList<>();
        TextView textView_third = findViewById(R.id.admin);
        Intent intent = getIntent();
        ArrayList kids = new ArrayList();
        String name = intent.getStringExtra("name");
        child1.setName(name);
        ArrayList<String> listOfSymptoms = intent.getStringArrayListExtra("ListOfSymptoms");
        children.push("");
        for (int i = 0; i< children.size(); i++) {
            child child1 = new child();
            child1.setName(name);
            children.poll();
            for (int i = 0; i < listOfSymptoms.size(); i++) {
                child1.setSymptoms(listOfSymptoms.get(i));

            }
            children.add(child1);
            Log.d(LOGTAG,children.peek().toString() );
        }




/* public Void peek{
                Node first = head;
                head = first.next;
                return first.data;
            }

        */

/* public void pop{
   Node first = head;
   first = children.peek{} // return top node

   head = head.link; // link to second node


}
 */

     /*   public void display(){
            Node first = head;
            if(head == null){

            }
            else if (first.next != null) {
                while (first.next != null) {
                    System.out.println(first.data);
                    first = first.next;
                }
                System.out.println(first.data);
            }


*/

        }







    }



















}