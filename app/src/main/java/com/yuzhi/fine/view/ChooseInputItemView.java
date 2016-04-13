package com.yuzhi.fine.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.BetterSpinner;
import com.yuzhi.fine.R;


/**
 * TODO: document your custom view class.
 */
public class ChooseInputItemView extends RelativeLayout{


    //private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.com.yuzhi.fine";
    private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private TextView tvTitle;
    private BetterSpinner bSInput;

    private String mTitle;
    private String mHint;
    private String mEditText;


    private ArrayAdapter<String> m_adapter;


    public ChooseInputItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();

    }

    public ChooseInputItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //根据布局属性，取出属性
        mTitle = attrs.getAttributeValue(NAMESPACE, "mtitle_civ");
        mHint = attrs.getAttributeValue(NAMESPACE, "mhint_civ");
        mEditText = attrs.getAttributeValue(NAMESPACE, "mtext_civ");

        initView();

    }

    public ChooseInputItemView(Context context) {
        super(context);
        initView();
    }


    /**
     * 初始化布局
     */
    private void initView(){
        //这个视图添加到，本RelativeLayout容器里面去
        View.inflate(getContext(), R.layout.view_chooseinput_item ,this);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        bSInput = (BetterSpinner) findViewById(R.id.bs_input);





        //设置标题
        tvTitle.setText(mTitle);
        bSInput.setText(mEditText);
        bSInput.setHint(mHint);

    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        tvTitle.setText(title);
    }


    /**
     * 文本框内容
     * @param text
     */
    public void setTextM(String text){
        bSInput.setText(text);
    }

    /**
     * 返回输入的文本
     * @return
     */
    public String getTextM(){
        return bSInput.getText().toString();
    }


    public void setItemsM(String [] items){

        m_adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, items);
        bSInput.setText(items[0]);

        bSInput.setAdapter(m_adapter);
    }





}
