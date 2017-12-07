package com.sheygam.masa_2017_07_12;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class PasswordFragment extends Fragment {

    private EditText inputPassword;
    private PasswordFragmentListener listener;

    public PasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof PasswordFragmentListener){
            listener = (PasswordFragmentListener) activity;
        }else{
            throw  new RuntimeException(activity.getClass().getName()  + " mast implements PasswordFragmentListener!");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputPassword = view.findViewById(R.id.input_password);
        view.findViewById(R.id.password_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPasswordBackPressed();
            }
        });

        view.findViewById(R.id.password_ok_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPasswordOkPressed(inputPassword.getText().toString());
            }
        });
    }

    public interface PasswordFragmentListener{
        void onPasswordBackPressed();
        void onPasswordOkPressed(String password);
    }
}
