package com.example.administrator.rxjavaretrofittest.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.rxjavaretrofittest.R;
import com.example.administrator.rxjavaretrofittest.view.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IActivity{

    private TextView textView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.net_text);
        presenter = new Presenter(this);

        presenter.setData();
    }




    @Override
    public void setTextViewData(String data){
        textView.setText(data);
    }




}
