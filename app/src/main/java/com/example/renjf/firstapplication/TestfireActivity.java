package com.example.renjf.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TestfireActivity extends AppCompatActivity {

    private TextView test_data;
    private TextView test_time;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testfire);

        iniUI();

        initData();

    }

    private void initData() {
        //构建数据库实例对象，引用为mReference
        mReference = FirebaseDatabase.getInstance().getReference();
        //通过键名，获取数据库实例对象的子节点对象
        DatabaseReference time = mReference.child("time");
        DatabaseReference data = mReference.child("data");

        //注册子第一个节点对象数据变化的监听者对象
        time.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //数据库数据变化时调用此方法
                String value = dataSnapshot.getValue(String.class);
                test_time.setText("time：" + value);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //数据库数据变化时调用此方法
                String value = dataSnapshot.getValue(String.class);
                test_data.setText("data：" + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

    private void iniUI() {
        test_data = (TextView) findViewById(R.id.test_data);
        test_time = (TextView) findViewById(R.id.test_time);
    }


}
