package com.example.zheey.kilasi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zheey.kilasi.R;
import com.example.zheey.kilasi.adapter.RegisterDataBaseAdapter;


public class RegisterActivity1 extends Activity {


    private RegisterDataBaseAdapter registerDataBaseAdapter;

    public static final String EXTRA_STUDENT_SURNAME= "extraStudentSurname";
    public static final String EXTRA_STUDENT_FIRSTNAME = "extraStudentFirstname";
    public static final String EXTRA_STUDENT_PHONE_NO = "extraStudentPhoneno";
    public static final String EXTRA_STUDENT_EMAIL = "extraStudentEmail";
    public static final String EXTRA_STUDENT_LEVEL = "extraStudentLevel";
    private String surname;
    private String firstname;
    private String email;
    private String phoneNo;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        final EditText etSurname = (EditText) findViewById(R.id.et_surname);
        final EditText etFirstname = (EditText) findViewById(R.id.et_firstname);
        final EditText etPhoneNo = (EditText) findViewById(R.id.et_phoneno);
        final EditText etEmail = (EditText) findViewById(R.id.et_email);
        final EditText etLevel = (EditText) findViewById(R.id.et_level);

        /*Button submitbtn = (Button) findViewById(R.id.save);

        submitbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                surname = etSurname.getText().toString();
                firstname = etFirstname.getText().toString();
                phoneNo = etPhoneNo.getText().toString();
                email = etEmail.getText().toString();
                level = etLevel.getText().toString();



                }

        });*/

        Button reg = (Button) findViewById(R.id.next);
        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),RegisterActivity2.class);
                intent.putExtra(EXTRA_STUDENT_SURNAME,surname);
                intent.putExtra(EXTRA_STUDENT_FIRSTNAME,firstname);
                intent.putExtra(EXTRA_STUDENT_EMAIL,email);
                intent.putExtra(EXTRA_STUDENT_LEVEL,level);
                intent.putExtra(EXTRA_STUDENT_PHONE_NO,phoneNo);
                startActivity(intent);
            }
        });






    }
}
