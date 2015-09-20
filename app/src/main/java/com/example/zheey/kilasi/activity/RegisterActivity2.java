package com.example.zheey.kilasi.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zheey.kilasi.R;
import com.example.zheey.kilasi.adapter.RegisterDataBaseAdapter;

public class RegisterActivity2 extends ActionBarActivity {

    private String surname;
    private String firstname;
    private String email;
    private String phoneNo;
    private String level;
    private String username;
    private String password;
    private String confirmPassword;
    private String matricNo;
    private String securityAnswer;

    private RegisterDataBaseAdapter registerDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        registerDataBaseAdapter=new RegisterDataBaseAdapter(this);
        registerDataBaseAdapter=registerDataBaseAdapter.open();

        surname = getIntent().getStringExtra(RegisterActivity1.EXTRA_STUDENT_SURNAME);
        firstname = getIntent().getStringExtra(RegisterActivity1.EXTRA_STUDENT_FIRSTNAME);
        email = getIntent().getStringExtra(RegisterActivity1.EXTRA_STUDENT_EMAIL);
        phoneNo = getIntent().getStringExtra(RegisterActivity1.EXTRA_STUDENT_PHONE_NO);
        level = getIntent().getStringExtra(RegisterActivity1.EXTRA_STUDENT_LEVEL);

        final EditText etUsername = (EditText) findViewById(R.id.et_username);
        final EditText etPassword = (EditText) findViewById(R.id.et_password);
        final EditText etConfirmPassword = (EditText) findViewById(R.id.et_confirmPassword);
        final EditText etMatricNo = (EditText) findViewById(R.id.et_matricno);
        final EditText etSurityAnswer = (EditText) findViewById(R.id.et_securityAnswer);

        Button submitbtn = (Button) findViewById(R.id.submit);

        submitbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                matricNo = etMatricNo.getText().toString();
                securityAnswer = etSurityAnswer.getText().toString();

                if (password.equals(confirmPassword)){

                    registerDataBaseAdapter.insertEntry(matricNo, surname, firstname, email, level, phoneNo, username, password, securityAnswer);
                }else{

                    Toast.makeText(RegisterActivity2.this,"Passwords don't match!",Toast.LENGTH_LONG).show();
                }


            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
