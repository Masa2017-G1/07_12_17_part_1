package com.sheygam.masa_2017_07_12;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener, EmailFragment.EmailFragmentListener, PasswordFragment.PasswordFragmentListener{
    private MainFragment mainFragment;
    private String email = "", password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root_main_container,mainFragment)
                .commit();

    }


    @Override
    public void onLoginPressed() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_main_container,new EmailFragment())
                .addToBackStack("REPLACE_TO_EMAIL_TR")
                .commit();
    }

    @Override
    public void isReady() {
        mainFragment.setData(this.email, this.password);
    }

    @Override
    public void onEmailBackPressed() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onEmailNextPressed(String email) {
        this.email = email;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_main_container,new PasswordFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onPasswordBackPressed() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onPasswordOkPressed(String password) {
        this.password = password;
        getSupportFragmentManager().popBackStack("REPLACE_TO_EMAIL_TR", FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }
}
