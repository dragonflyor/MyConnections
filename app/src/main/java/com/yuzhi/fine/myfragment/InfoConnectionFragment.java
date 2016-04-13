package com.yuzhi.fine.myfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuzhi.fine.R;
import com.yuzhi.fine.myActivity.TenantConnectionActivity;

/**
 * 信息录入模块
 */
public class InfoConnectionFragment extends Fragment {

    Activity m_activity;
    View m_rootView;

    ImageView ivTop;

    String mItems[] = new String[]{"房客信息采集","社会车辆采集","工人信息采集","其他信息采集"};
    int mPics[] = new int[]{R.drawable.gridview_tenant,R.drawable.gridview_car,
            R.drawable.gridview_worker,R.drawable.gridview_more};
    private GridView gvFunction;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        m_rootView = inflater.inflate(R.layout.fragment_m_infoconnection, container, false);
        return m_rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        m_activity = getActivity();


        initView();


    }

    //初始化界面控件
    void initView(){

        //图片展示
        ivTop = (ImageView)m_rootView.findViewById(R.id.iv_top);
        Display display = m_activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        int heightPixels = metrics.heightPixels;
        ivTop.setMaxHeight(heightPixels/5);
        System.out.println("---------------height:"+heightPixels);
        ivTop.setMinimumHeight(heightPixels / 8);
        ivTop.invalidate();


        gvFunction = (GridView) m_rootView.findViewById(R.id.gv_function);
        gvFunction.setAdapter(new GridAdapter());

        //设置监听
        gvFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int postion,
                                    long id) {
                switch (postion) {
                    case 0:
                        //租客信息
                        Toast.makeText(m_activity, "输入租客信息", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(m_activity, TenantConnectionActivity.class));
                        break;
                    case 1:
                        //务工人员信息
                        Toast.makeText(m_activity, "务工人员信息录入正在开发", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //社会车辆信息
                        Toast.makeText(m_activity, "社会车辆信息录入正在开发", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        //其他信息
                        Toast.makeText(m_activity, "正在开发", Toast.LENGTH_SHORT).show();
                        break;


                }

            }
        });


    }

    class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mItems.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return mItems[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            View view = View.inflate(m_activity,
                    R.layout.item_gridview, null);

            TextView tvItem = (TextView) view.findViewById(R.id.tv_item);
            ImageView imageView = (ImageView)view.findViewById(R.id.iv_item);
            //设置图片
            imageView.setImageResource(mPics[arg0]);
            tvItem.setText(mItems[arg0]);

            System.out.println("创建grid："+arg0);


            return view;

        }
    }

}
