package com.ltdd.quiz;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class De_So_1 extends AppCompatActivity {
    TextView stt,noiDung;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    Button click;
    int i = 1, n = 0;
    public static int flag = 0, correct = 0, wrong = 0;
    static final String question[] = {
            "Lớp truy cập mạng trong mô hình giao thức TCP/IP tương " +
                    "ứng với lớp/cụm các lớp nào trong mô hình OSI?",
            "Chức năng của lớp mạng trong mô hình TCP/IP là?",
            "Kỹ thuật SCMA/CD thì mỗi nút mạng sẽ thử truy cập ngẫu nhiên và đợi trong " +
                    "khoảng thời gian là bao lâu?",
            "Kỹ thuật chuyển thẻ bài được sử dụng trong cấu trúc mạng nào?",
            "Định dạng đơn vị thông tin tại lớp truy nhập mạng là?",
            "Định dạng đơn vị thông tin tại lớp liên mạng là?",
            "Định dạng đơn vị thông tin tại lớp ứng dụng là?",
            "Giao thức IP hoạt động tại lớp nào trong mô hình TCP/IP?",
            "Chức năng của giao thức IP là?",
            "Chức năng của giao thức thức bản tin điều khiển (ICMP- lệnh ping) là?",


    };

    static final String answer[] = {
            "B.\tLớp vật lý, lớp liên kết dữ liệu",
            "C.\tĐịnh tuyến",
            "B.\tBằng số ngẫu nhiên với khe thời gian",
            "A.\tCấu trúc Ring",
            "D.\tKhung dữ liệu",
            "A.\tGói dữ liệu",
            "A.\tBản tin",
            "B.\tLớp liên mạng",
            "A.\tĐịnh nghĩa cơ chế định địa chỉ trong mạng Internet",
            "C.\tKiểm tra các host ở xa có hoạt động hay không"
    };

    static final String option[] = {
            "A.\tLớp vật lý","B.\tLớp vật lý, lớp liên kết dữ liệu","C.\tLớp mạng","D.\tLớp vật lý, lớp lien kết dữ liệu, lớp mạng",
            "A.\tĐóng gói dữ liệu IP vào khung","B.\tĐiểu khiển luồng","C.\tĐịnh tuyến","D.\tÁnh xạ địa chỉ IP sang địa chỉ vật lý",
            "A.\t102.2µs","B.\tBằng số ngẫu nhiên với khe thời gian","C.\t51.2 µs","D.\t52.1 µs",
            "A.\tCấu trúc Ring","B.\tCấu trúc Bus","C.\tCấu trúc Mesh","D.\tCấu trúc Star",
            "A.\tĐoạn dữ liệu","B.\tGói dữ liệu","C.\tBản tin","D.\tKhung dữ liệu",
            "A.\tGói dữ liệu","B.\tĐoạn dữ liệu","C.\tBản tin","D.\tKhung dữ liệu",
            "A.\tBản tin","B.\tKhung dữ liệu","C.\tĐoạn dữ liệu","D.\tGói dữ liệu",
            "A.\tLớp truy nhập mạng","B.\tLớp liên mạng","C.\tLớp phiên","D.\tLớp truyền tải",
            "A.\tĐịnh nghĩa cơ chế định địa chỉ trong mạng Internet","B.\tPhân đoạn và tái tạo dữ liệu","C.\tĐịnh hướng đường cho các đơn vị dữ liệu đến các host ở xa","D.\tPhân đoạn",
            "A.\tĐịnh tuyến lại","B.\tĐiều khiển luồng, phát hiện sự không đến đích","C.\tKiểm tra các host ở xa có hoạt động hay không","D.\tĐiều khiển luồng"

    };

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thi);
        stt = (TextView) findViewById(R.id.stt);
        noiDung = (TextView) findViewById(R.id.noiDung);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        r1 = (RadioButton) findViewById(R.id.rd1);
        r2 = (RadioButton) findViewById(R.id.rd2);
        r3 = (RadioButton) findViewById(R.id.rd3);
        r4 = (RadioButton) findViewById(R.id.rd4);
        click = (Button) findViewById(R.id.click);

        stt.setText("Câu Hỏi Thứ " + i);
        noiDung.setText(question[flag]);
        r1.setText(option[n]);
        r2.setText(option[n+1]);
        r3.setText(option[n+2]);
        r4.setText(option[n+3]);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String a = bundle.getString("dethi");

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton uans = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(i<=10){
                    if(i<10){
                        if(answer[flag].equals(ansText)){
                            correct++;
                        }
                        else
                            wrong++;
                        n+=4;
                        flag+=1;
                        stt.setText("Câu Hỏi Thứ " + (i+=1));
                        noiDung.setText(question[flag]);
                        r1.setText(option[n]);
                        r2.setText(option[n+1]);
                        r3.setText(option[n+2]);
                        r4.setText(option[n+3]);
                        if(radioGroup.getCheckedRadioButtonId()== -1){
                            Toast.makeText(De_So_1.this, "Please select one choice !", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Log.d("test", "test" + radioGroup.getCheckedRadioButtonId());
                    }
                    else if(i==10){
                        if(answer[flag].equals(ansText)){
                            correct++;
                        }
                        else
                            wrong++;
                        if(radioGroup.getCheckedRadioButtonId()== -1){
                            Toast.makeText(De_So_1.this, "Please select one choice !", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent intent = new Intent(getApplicationContext(),Ket_Qua_Sau_Thi.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("correct", correct);
                        bundle.putInt("wrong", wrong);
                        bundle.putInt("marks",i);
                        bundle.putString("de",a);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        i = 1;
                        n = 0;
                        flag = 0;
                        correct = 0;
                        wrong = 0;
                    }
                }

            }
        });
    }
    }

