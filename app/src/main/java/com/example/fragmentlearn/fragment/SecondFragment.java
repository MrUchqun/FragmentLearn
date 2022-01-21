package com.example.fragmentlearn.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentlearn.R;
import com.example.fragmentlearn.model.User;

public class SecondFragment extends Fragment {

    private SendDataSecond sendListener;

    TextView textViewName;
    TextView textViewAge;
    EditText editTextName;
    EditText editTextAge;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        textViewName = view.findViewById(R.id.tv_name_fragment_second);
        textViewAge = view.findViewById(R.id.tv_age_fragment_second);
        editTextName = view.findViewById(R.id.et_name_fragment_second);
        editTextAge = view.findViewById(R.id.et_age_fragment_second);

        button = view.findViewById(R.id.btn_fragment_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(editTextName.getText());
                String work = String.valueOf(editTextAge.getText());
                sendListener.sendDataSecond(new User(name, work));
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SendDataSecond){
            sendListener = (SendDataSecond) context;
        } else {
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sendListener = null;
    }

    public void updateSecondText(User user){
        textViewName.setText(user.getName());
        textViewAge.setText(user.getWork());
    }

    public interface SendDataSecond {
        void sendDataSecond(User user);
    }

}
