package com.elangzhi.sjy.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.elangzhi.sjy.R;
import com.elangzhi.sjy.beans.Period;
import com.elangzhi.sjy.beans.Tip;
import com.elangzhi.sjy.beans.Trade;
import com.elangzhi.sjy.beans.TradeList;
import com.elangzhi.sjy.beans.Variety;
import com.elangzhi.sjy.utils.DbUtil;
import com.elangzhi.sjy.utils.GsonUtil;
import com.elangzhi.sjy.utils.Logger;
import com.elangzhi.sjy.utils.TypeUtil;
import com.elangzhi.sjy.utils.Urls;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.toolbar)
    Toolbar toolbar;

    @ViewInject(R.id.line_variety)
    LinearLayout lineVariety;

    @ViewInject(R.id.line_period)
    LinearLayout linePeriod;

    @ViewInject(R.id.rg_variety)
    RadioGroup rgVariety;

    @ViewInject(R.id.rg_period)
    RadioGroup rgPeriod;

    List<RadioButton> varietyButtonList = new ArrayList<>();
    List<RadioButton> periodButtonList = new ArrayList<>();

    /*@ViewInject(R.id.tv_show)
    TextView tvShow;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setSupportActionBar(toolbar);

        createType();
    }

    /**
     * 初始化分类标签
     */
    private void createType() {

        for(Variety variety : TypeUtil.getVarietyList()){
            RadioButton rbItem = createTypeButton(variety);
            rgVariety.addView(rbItem);
            varietyButtonList.add(rbItem);
        }

        for(Period period : TypeUtil.getPeriodList()){
            RadioButton rbItem = createTypeButton(period);
            rgPeriod.addView(rbItem);
            periodButtonList.add(rbItem);
        }

    }

    /**
     * 分类按钮创建
     * @param variety 品种
     * @return 按钮
     */
    private RadioButton createTypeButton(Variety variety){
        RadioButton button = (RadioButton) getLayoutInflater().inflate(R.layout.type_menu,null);
        button.setText(variety.getName());
        button.setTag(variety);
        return button;
    }

    /**
     * 分类按钮创建
     * @param period 周期
     * @return 按钮
     */
    private RadioButton createTypeButton(Period period){
        RadioButton button = (RadioButton) getLayoutInflater().inflate(R.layout.type_menu_period,null);
        button.setText(period.getName());
        button.setTag(period);
        return button;
    }




/*
    @Event(R.id.btn_init)
    private void init(View view) {
        RequestParams params = new RequestParams(Urls.TRADE);
        params.addBodyParameter("page","1");
        params.addBodyParameter("len","50");
        x.http().post(params,new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                saveTradeList(result);
                TradeList tradeList = GsonUtil.GsonToBean(result,TradeList.class);
                Logger.i(tradeList.getHasNextPage().toString());
                String tradeImg = "";
                for(Trade trade : tradeList.getTradeList()){
                    tradeImg += DbUtil.getSrc(trade.getImage());
                }
                tvShow.setText(tradeImg);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }*/

    /**
     * 保存历史结果
     * @param tradeList 获取的数据
     */
    private void saveTradeList(String tradeList){
        if(tradeList == null){return ;}
        SharedPreferences sp = getSharedPreferences("trade_list", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("tradeList", tradeList);
        editor.commit();
    }

    /**
     * 添加新数据
     * @param trade 新数据
     */
    private void addToTradeList(Trade trade){
        SharedPreferences sp = getSharedPreferences("trade_list", Context.MODE_PRIVATE);
        //取出来 添加一条
        String tradeListString = sp.getString("tradeList",null);
        List<Trade> tradeList = GsonUtil.GsonToList(tradeListString,Trade.class);
        tradeList.add(trade);
        //重新存进去
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("tradeList", GsonUtil.GsonString(tradeList));
        editor.commit();
    }

    /**
     * 获取指定类型数据
     * @param varietyId
     * @param periodId
     * @return 列表
     */
    private List<Trade> getListByType(String varietyId, String periodId){
        SharedPreferences sp = getSharedPreferences("trade_list", Context.MODE_PRIVATE);
        //取出来 添加一条
        String tradeListString = sp.getString("tradeList",null);
        List<Trade> tradeList = GsonUtil.GsonToList(tradeListString,Trade.class);
        return DbUtil.searchByType(varietyId,periodId,tradeList);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
