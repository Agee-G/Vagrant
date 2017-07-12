package com.vagrant.android.vagrant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by g__agee on 2017/7/10.
 */

public class Register extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);
        Button button1=(Button) findViewById(R.id.register);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1="";
                EditText editText1 =(EditText)findViewById(R.id.username);
                str1=editText1.getText().toString();

                String str2="";
                EditText editText2 =(EditText)findViewById(R.id.np);
                str2=editText2.getText().toString();

                String str3="";
                EditText editText3 =(EditText)findViewById(R.id.call);
                str3=editText3.getText().toString();

                BmobUser bu = new BmobUser();
                bu.setUsername(str1);
                bu.setPassword(str2);
                bu.setMobilePhoneNumber(str3);
//注意：不能用save方法进行注册

                bu.signUp(new SaveListener<Person>()  {
                    @Override
                    public void done(Person s,BmobException e) {
                        if(e==null){
                            Toast.makeText(Register.this,"添加数据成功，返回objectId为："+s,Toast.LENGTH_LONG).show();
                            //toast("添加数据成功，返回objectId为："+
                            Intent intent=new Intent(Register.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this,"创建数据失败：" + e.getMessage(),Toast.LENGTH_LONG).show();
                            //toast("创建数据失败：" + e.getMessage());
                        }
                    }
                });

            }
        });
    }

}
