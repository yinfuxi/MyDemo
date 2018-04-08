package com.example.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_native)
    Button btn_native;
    @BindView(R.id.btn_VasSonic)
    Button btn_VasSonic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //test
    }

    @OnClick({R.id.btn_native,R.id.btn_VasSonic})
    public void click(View view){
        switch (view.getId()){
            case R.id.btn_native:
                break;
            case R.id.btn_VasSonic:
                break;
        }
    }

}
