package com.wyb.mvp_demo.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wyb.mvp_demo.Presenter.MainPresenter;
import com.wyb.mvp_demo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IMainView {

    private MainPresenter mMainPresenter; //Presenter
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        findViewById(R.id.button).setOnClickListener(this);
    }


    private void initData() {
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.onCreate();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                mMainPresenter.onBtnClick();
                break;
        }
    }

    @Override
    public void setData(String data) {
        text.setText(data);
    }
}
