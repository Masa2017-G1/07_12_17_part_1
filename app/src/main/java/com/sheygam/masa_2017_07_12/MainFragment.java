package com.sheygam.masa_2017_07_12;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private TextView emailTxt;
    private TextView passwordTxt;
    private Button loginBtn;
    private MainFragmentListener listener;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof MainFragmentListener){
            listener = (MainFragmentListener) activity;
        }else{
            throw new RuntimeException(activity.getClass().getName() +
            " must implements MainFragmentListener!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailTxt = view.findViewById(R.id.email_txt);
        passwordTxt = view.findViewById(R.id.password_txt);
        view.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLoginPressed();
            }
        });

        listener.isReady();
    }

    public void setData(String email, String password){
        if(emailTxt != null){
            emailTxt.setText(email);
        }

        if(passwordTxt != null){
            passwordTxt.setText(password);
        }
    }

    public interface MainFragmentListener{
        void onLoginPressed();
        void isReady();
    }

}
