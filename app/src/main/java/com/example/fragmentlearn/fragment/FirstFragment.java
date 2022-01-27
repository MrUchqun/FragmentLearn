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
import com.example.fragmentlearn.model.UserCopy;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FirstFragment extends Fragment {

//    private SendDataFirst sendListener;

    TextView textViewName;
    TextView textViewAge;
    EditText editTextName;
    EditText editTextAge;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        textViewName = view.findViewById(R.id.tv_name_fragment_first);
        textViewAge = view.findViewById(R.id.tv_age_fragment_first);
        editTextName = view.findViewById(R.id.et_name_fragment_first);
        editTextAge = view.findViewById(R.id.et_age_fragment_first);

        button = view.findViewById(R.id.btn_fragment_first);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String work = editTextAge.getText().toString();
                EventBus.getDefault().post(new User(name, work));
//                sendListener.sendDataFirst(new User(name, work));
            }
        });
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof SendDataFirst){
//            sendListener = (SendDataFirst) context;
//        } else {
//            throw new RuntimeException(context.toString());
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        sendListener = null;
//    }
//
//    public void updateFirstText(User user){
//        textViewName.setText(user.getName());
//        textViewAge.setText(user.getWork());
//    }
//

//    public interface SendDataFirst {
//        void sendDataFirst(User user);
//    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateFirstText(UserCopy user){
        textViewName.setText(user.getName());
        textViewAge.setText(user.getWork());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
