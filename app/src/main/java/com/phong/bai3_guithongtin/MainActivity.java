package com.phong.bai3_guithongtin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        /* dưới đây là hàm khởi tạo một AlertDialog.Builder, thằng này có tác dụng vẽ ra giao diện cho AlertDialog,
        mặc định nó sẽ sử dụng theme dialog mặc định khi show */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");// set tiêu đề cho AlertDialog
        builder.setMessage(edtHoTen.getText().toString() + "\n");//set nội dung bên trong cho Alert
        builder.setMessage(edtCMND.getText().toString() + "\n");//set nội dung bên trong cho Alert
        int id = radGroup.getCheckedRadioButtonId();//Tìm RadioButton trong RadioGroup đang đc Checked
        if (id > 0)
        {
            RadioButton radioButton = (RadioButton) findViewById(id);
            builder.setMessage(radioButton.getText() + "\n");//set nội dung bên trong cho Alert
        }
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
        builder.setMessage(sothich + "\n");//set nội dung bên trong cho Alert
        builder.setMessage("------------------\n");//set nội dung bên trong cho Alert
        builder.setMessage("Thông tin bổ sung\n");//set nội dung bên trong cho Alert
        builder.setMessage(edtThongTinBoSung.getText().toString() + "\n");//set nội dung bên trong cho Alert
        builder.setMessage("------------------\n");//set nội dung bên trong cho Alert
        /*
        đây là thuộc tính nếu set false thì khi show dialog lên người dùng click ra bên ngoài dialog thì nó vẫn không bị mất,
        nếu set true thì sẽ mất khi click vào bất kì đâu ngoài dialog.
         */
        builder.setCancelable(false);
        /*
        thêm một nút Button ở giữa, NeutralB nghĩa là Trung lập, mà trung lập là nằm giữa.
        Ở đây đặt tên cho nó là gì thì tuỳ và phía dưới sẽ bắt sự kiện cho nó
         */
        builder.setNeutralButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
