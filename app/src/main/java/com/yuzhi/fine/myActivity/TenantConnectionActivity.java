package com.yuzhi.fine.myActivity;


import android.app.Activity;
import android.os.Bundle;

import com.yuzhi.fine.R;
import com.yuzhi.fine.view.ChooseInputItemView;
import com.yuzhi.fine.view.EditInputItemView;

public class TenantConnectionActivity extends Activity {

    EditInputItemView eiv_name ;
    ChooseInputItemView civ_gender;
    ChooseInputItemView civ_cardtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_connection);
        initView();



    }


    public void initView(){

        eiv_name = (EditInputItemView)findViewById(R.id.eiv_name);

        civ_gender = (ChooseInputItemView)findViewById(R.id.civ_gender);
        civ_gender.setItemsM(new String[]{"男","女"});

        civ_cardtype = (ChooseInputItemView)findViewById(R.id.civ_cardtype);
        civ_cardtype.setItemsM(new String[]{"二代身份证","护照","港澳通行证","暂住证"});




    }

}
