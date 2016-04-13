package com.yuzhi.fine.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuzhi.fine.R;


public class EditInputItemView extends RelativeLayout {

	//private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.com.yuzhi.fine";
	private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
	private TextView tvTitle;
	private EditText etInput;
	
	private String mTitle;
	private String mHint;
	private String mEditText;



	public EditInputItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
		
	}

	public EditInputItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		//根据布局属性，取出属性
		mTitle = attrs.getAttributeValue(NAMESPACE, "mtitle");
		mHint = attrs.getAttributeValue(NAMESPACE, "mhint");
		mEditText = attrs.getAttributeValue(NAMESPACE, "mtext");
		
		initView();

	}

	public EditInputItemView(Context context) {
		super(context);
		initView();
	}
	
	
	/**
	 * 初始化布局
	 */
	private void initView(){
		//这个视图添加到，本RelativeLayout容器里面去
		View.inflate(getContext(), R.layout.view_editinput_items ,this);
		tvTitle = (TextView) findViewById(R.id.tv_title);
		etInput = (EditText) findViewById(R.id.et_input);
		
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
