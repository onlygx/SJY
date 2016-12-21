package com.elangzhi.sjy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.elangzhi.sjy.R;
import com.elangzhi.sjy.utils.Logger;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * 设置页面
 */
@ContentView(R.layout.activity_settings)
public class SettingsActivity extends AppCompatActivity {

    @ViewInject(R.id.set_remind)
    Switch setRemind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = R.id.set_remind , type = CompoundButton.OnCheckedChangeListener.class)
    private void setRemindCheckedChange(CompoundButton compoundButton,boolean status){
        Logger.i("===========================");
        if(status){
            Logger.i("选中");
        }else{
            Logger.i("未选中");
        }

    }

}
