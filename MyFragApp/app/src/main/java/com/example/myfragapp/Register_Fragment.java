package com.example.myfragapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FirebaseAuth mAuth;

    Button buttonReg ;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Register_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Register_Fragment newInstance(String param1, String param2) {
        Register_Fragment fragment = new Register_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_register_, container, false);
        mAuth = FirebaseAuth.getInstance();
        MainActivity mainactivity = (MainActivity) getActivity();

        //create object of every data in users

        buttonReg = v.findViewById(R.id.RegisterBtn);

//        public void regFunc (String email, String password) {
//
//        }

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input_fullname = v.findViewById(R.id.input_fullname);
                String full_name = input_fullname.getText().toString();

                EditText input_email = v.findViewById(R.id.input_email);
                String email = input_email.getText().toString();

                EditText input_password = v.findViewById(R.id.input_password);
                String password = input_password.getText().toString();

                EditText phone_ = v.findViewById(R.id.phone);
                String phone = phone_.getText().toString();

                EditText input_id = v.findViewById(R.id.input_id);
                String id = input_id.getText().toString();

                Users user = new Users(full_name, email,password,phone, id );

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users").child(user.id);

                myRef.setValue(user);

                mainactivity.regFunc(email,password);

            }
        });
        //create a new object




        // Write a message to the database



    return v;
    }
}