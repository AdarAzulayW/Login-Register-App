package com.example.myfragapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Welcome_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Welcome_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    FirebaseAuth mAuth;
    Button logoutbtn ;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView maintext;
    public String userName;
    public Welcome_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Welcome_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Welcome_Fragment newInstance(String param1, String param2) {
        Welcome_Fragment fragment = new Welcome_Fragment();
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
        View v = inflater.inflate(R.layout.fragment_welcome_, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        mAuth = FirebaseAuth.getInstance();

        logoutbtn = v.findViewById(R.id.LogoutBtn);
        maintext = v.findViewById(R.id.the_text);
//        userName = mainActivity.getName();
//        maintext.setText("Welcome" + userName );


        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.logoutFunc();
                Navigation.findNavController(v).navigate(R.id.action_welcome_Fragment_to_nav_Fragments);


            }
        });


        return v;
    }

    public void LogOutFunc () {

    }
}