package com.phong.bai3_guithongtin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuiThongTin extends Dialog{
    //Khai báo controls trong layout custom
    TextView txtTen, txtCMT, txtBangCap, txtSoThich, txtThongTinBS;
    Button btnDong;
    Activity context;
    public GuiThongTin(Activity context) {
        super(context);
        this.context = context;
        setContentView(R.layout.itemfordialog);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void addControls() {
        txtTen = (TextView) findViewById(R.id.txtTen);
        txtCMT = (TextView) findViewById(R.id.txtCMT);
        txtBangCap = (TextView) findViewById(R.id.txtBangCap);
        txtSoThich = (TextView) findViewById(R.id.txtSoThich);
        txtThongTinBS = (TextView) findViewById(R.id.txtThongTinBS);
        btnDong = (Button) findViewById(R.id.btnDong);
        setTitle("Thông tin cá nhân");
        setCanceledOnTouchOutside(false);
    }
}
