package com.lynnchurch.alertdialogdemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.lynnchurch.alertdialog.AlertDialog;

public class MainActivity extends Activity
{
	private Button mBtn;
	private AlertDialog mDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtn = (Button) findViewById(R.id.btn);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示标题").setMessage("你好，我是提示内容")
				.setPositiveButton("确认", new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						showToast("您点击了确认");
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						// TODO Auto-generated method stub
						showToast("您点击了取消");
					}
				});
		mDialog = builder.create();

		mBtn.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				mDialog.show();
			}
		});

	}

	private void showToast(String msg)
	{
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
}
