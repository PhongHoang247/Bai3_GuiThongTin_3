package com.phong.bai3_guithongtin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtHoTen, edtCMND, edtThongTinBoSung;
    RadioGroup radGroup;
    RadioButton radTrungCap, radCaoDang, radDaiHoc;
    CheckBox chkDocSach, chkDocBao, chkDocCoding;
    Button btnGuiThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }


    private void addEvents() {
        btnGuiThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyGuiThongTin();
            }
        });
    }

    private void XuLyGuiThongTin() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.itemfordialog);
        dialog.setCanceledOnTouchOutside(false);

        TextView txtTen =(TextView)  dialog.findViewById(R.id.txtTen);
        txtTen.setText(edtHoTen.getText().toString());

        TextView txtCMT = (TextView) dialog.findViewById(R.id.txtCMT);
        txtCMT.setText(edtCMND.getText().toString());

        TextView txtBangCap = (TextView) dialog.findViewById(R.id.txtBangCap);
        /*if(radDaiHoc.isChecked())
        {
            txtBangCap.setText(radDaiHoc.getText());
        }
        else if (radCaoDang.isChecked())
        {
            txtBangCap.setText(radCaoDang.getText());
        }
        else if (radTrungCap.isChecked())
        {
            txtBangCap.setText(radTrungCap.getText());
        }*/
        //Tìm RadioButton trong trong group mà đang đc Checked:
        int id = radGroup.getCheckedRadioButtonId();
        if (id>0)
        {
            RadioButton radioButton=(RadioButton) findViewById(id);
            txtBangCap.setText(radioButton.getText());
        }
        TextView txtSoThich = (TextView) dialog.findViewById(R.id.txtSoThich);
        String sothich = "";
        if (chkDocBao.isChecked())
        {
            sothich += chkDocBao.getText().toString() + " - ";
        }
        if (chkDocSach.isChecked())
        {
            sothich += chkDocSach.getText().toString() + " - ";
        }
        if (chkDocCoding.isChecked())
        {
            sothich += chkDocCoding.getText().toString() + " - ";
        }
        txtSoThich.setText(sothich);

        TextView txtThongTinBS = (TextView) dialog.findViewById(R.id.txtThongTinBS);
        txtThongTinBS.setText(edtThongTinBoSung.getText().toString());

        Button btnDong = (Button) dialog.findViewById(R.id.btnDong);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void addControls() {
        edtHoTen = (EditText) findViewById(R.id.edtHoTen);
        edtCMND = (EditText) findViewById(R.id.edtCMND);
        edtThongTinBoSung = (EditText) findViewById(R.id.edtThongTinBoSung);

        radGroup = (RadioGroup) findViewById(R.id.radGroup);
        radTrungCap = (RadioButton) findViewById(R.id.radTrungCap);
        radCaoDang = (RadioButton) findViewById(R.id.radCaoDang);
        radDaiHoc = (RadioButton) findViewById(R.id.radDaiHoc);

        chkDocSach = (CheckBox) findViewById(R.id.chkDocSach);
        chkDocBao = (CheckBox) findViewById(R.id.chkDocBao);
        chkDocCoding = (CheckBox) findViewById(R.id.chkDocCoding);

        btnGuiThongTin = (Button) findViewById(R.id.btnGuiThongTin);
    }
}
