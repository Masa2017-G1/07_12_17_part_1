package com.sheygam.masa_2017_07_12;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmailFragment extends Fragment {

    private Button backBtn, nextBtn;
    private EditText inputEmail;
    private EmailFragmentListener listener;


    public EmailFragment() {

        // Required empty public constructor
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof EmailFragmentListener) {
            listener = (EmailFragmentListener) activity;
        } else {
            throw new RuntimeException(activity.getClass().getName() + " must implements EmailFragmentListener!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputEmail = view.findViewById(R.id.input_email);
        view.findViewById(R.id.email_back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEmailBackPressed();
            }
        });

        view.findViewById(R.id.email_next_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEmailNextPressed(inputEmail.getText().toString());
            }
        });
    }

    public interface EmailFragmentListener {
        void onEmailBackPressed();
        void onEmailNextPressed(String email);
    }

}
