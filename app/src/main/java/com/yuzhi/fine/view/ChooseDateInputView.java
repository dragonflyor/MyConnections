package com.yuzhi.fine.view;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by ZNE on 2016/4/12.
 */
public class ChooseDateInputView extends RelativeLayout {

    //private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.com.yuzhi.fine";
    private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private TextView tvTitle;
    private Button etInput;

    private String mTitle;
    private String mHint;
    private String mEditText;


    private DatePicker datePicker;
    private Date m_date;


    public Date getDate() {
        return m_date;
    }

    public void setDate(Date date) {

        m_date = date;
    }

    public ChooseDateInputView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();

    }

    public ChooseDateInputView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //根据布局属性，取出属性
        mTitle = attrs.getAttributeValue(NAMESPACE, "mtitle_cdv");
        mHint = attrs.getAttributeValue(NAMESPACE, "mhint_cdv");
        mEditText = attrs.getAttributeValue(NAMESPACE, "mtext_cdv");

        initView();

    }

    public ChooseDateInputView(Context context) {
        super(context);
        initView();
    }


    /**
     * 初始化布局
     */
    private void initView(){
        //这个视图添加到，本RelativeLayout容器里面去

//        View.inflate(getContext(), R.layout.view_choosedateinput_item, this);
//        tvTitle = (TextView) findViewById(R.id.tv_title);
//        etInput = (Button)findViewById(R.id.et_input);
//        int e = 0/0;
//
//        etInput.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                View diaglogView =ChooseDateInputView.inflate(getContext(), R.layout.dialog_date, null);
//
//                datePicker = (DatePicker) diaglogView.findViewById(R.id.dp_choosedate);
//
//
//                datePicker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
//                    @Override
//                    public void onDatePicked(String date) {
//                        //选择的日期
//                        mEditText = date;
//                    }
//                });
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder( getContext());
//                builder.setTitle("选择时间").setView(diaglogView).show();
//
//
//            }
//        });




        //设置标题
        tvTitle.setText(mTitle);
        etInput.setText(mEditText);
        etInput.setHint(mHint);

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
        etInput.setText(text);
    }

    /**
     * 返回输入的文本
     * @return
     */
    public String getTextM(){
        return etInput.getText().toString();
    }




}
