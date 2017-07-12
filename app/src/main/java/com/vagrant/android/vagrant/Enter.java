package com.vagrant.android.vagrant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by g__agee on 2017/7/10.
 */

public class Enter extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        Bmob.initialize(this, "468eb33bbfd25d0426c7617626bb8be1");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.enter);
        Button button1=(Button) findViewById(R.id.login);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String str1="";
                EditText editText1 =(EditText)findViewById(R.id.username);
                str1=editText1.getText().toString();

                String str2="";
                EditText editText2=(EditText)findViewById(R.id.password);
                str2=editText2.getText().toString();

                BmobUser bu2 = new BmobUser();
                bu2.setUsername(str1);
                bu2.setPassword(str2);
                bu2.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e==null){
                            Toast.makeText(Enter.this,"登录成功:",Toast.LENGTH_LONG).show();
                            //toast("登录成功:");
                            //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                            //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                            Intent intent=new Intent(Enter.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Enter.this,"登录error:",Toast.LENGTH_LONG).show();
                            //loge(e);
                        }
                    }
                });
            }
        });

        Button button2=(Button) findViewById(R.id.register);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Enter.this,Register.class);
                startActivity(intent);
            }
        });
    }



}
