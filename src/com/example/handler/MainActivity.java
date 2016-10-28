package com.example.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView myText;
	private Handler myHandler;
	public void onCreate(Bundle saveIntanceState){
		super.onCreate(saveIntanceState);
			setContentView(R.layout.activity_main);
			myText=(TextView)findViewById(R.id.myText);
			myText.setText("生成的随机数为："+Math.random());
			myHandler=new Handler(){
				public void hanleMessage(Message msg){
					super.handleMessage(msg);
					if(msg.what==0x12){
					myText.setText("生成的随机数为：\n"+Math.random());
					
				}
		}
	};
new Thread (new Runnable(){
	public void run (){
		try{
			while(true){
				Thread.sleep(300);
				Message msg=new Message();
				msg.what=0x12;
				myHandler.sendMessage(msg);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	};
}).start();
	}
}
	

