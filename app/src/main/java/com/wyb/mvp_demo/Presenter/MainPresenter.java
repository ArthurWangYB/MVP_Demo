package com.wyb.mvp_demo.Presenter;

import com.wyb.mvp_demo.Model.MainModel;
import com.wyb.mvp_demo.View.IMainView;
import com.wyb.mvp_demo.View.MainActivity;

import static android.os.AsyncTask.execute;

/**
 * Created by Arthur_Wang on 2016/11/18.
 */
public class MainPresenter implements IMainPresenter {

    private MainModel mMainModel;   //Model
    private IMainView mMainView;     //View

    public MainPresenter(IMainView mMainView) {
        this.mMainView = mMainView;
        mMainModel = new MainModel();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onBtnClick() {
        execute(new Runnable() {
            @Override
            public void run() {
                final String data = mMainModel.getData();
                ((MainActivity) mMainView).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mMainView.setData(data);
                    }
                });
            }
        });
    }
}
