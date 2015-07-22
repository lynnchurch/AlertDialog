package com.lynnchurch.alertdialog;

import com.lynnchurch.alertdialog.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

/**
 * 提示对话框
 * 
 * @author LynnChurch
 * @version 创建时间:2015年7月15日 下午3:53:20
 * 
 */
public class AlertDialog extends Dialog
{

	public AlertDialog(Context context)
	{
		// TODO Auto-generated constructor stub
		super(context);
	}

	public AlertDialog(Context context, int theme)
	{
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 建造者类
	 * 
	 * @author Administrator
	 * 
	 */
	public static class Builder
	{
		private Context context;
		private String title;
		private String message;
		private String positiveButtonText;
		private String negativeButtonText;
		private View contentView;
		private DialogInterface.OnClickListener positiveButtonClickListener;
		private DialogInterface.OnClickListener negativeButtonClickListener;

		public Builder(Context context)
		{
			this.context = context;
		}

		/**
		 * 设置消息内容
		 * 
		 * @param message
		 * @return
		 */
		public Builder setMessage(String message)
		{
			this.message = message;
			return this;
		}

		/**
		 * 设置消息标题
		 * 
		 * @param title
		 * @return
		 */

		public Builder setTitle(String title)
		{
			this.title = title;
			return this;
		}

		public Builder setContentView(View v)
		{
			this.contentView = v;
			return this;
		}

		/**
		 * 设置积极按钮
		 * 
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(String positiveButtonText,
				DialogInterface.OnClickListener listener)
		{
			this.positiveButtonText = positiveButtonText;
			this.positiveButtonClickListener = listener;
			return this;
		}

		/**
		 * 设置消极按钮
		 * 
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setNegativeButton(String negativeButtonText,
				DialogInterface.OnClickListener listener)
		{
			this.negativeButtonText = negativeButtonText;
			this.negativeButtonClickListener = listener;
			return this;
		}

		/**
		 * 创建一个AlertDialog
		 * 
		 * @return
		 */
		public AlertDialog create()
		{
			LayoutInflater inflater = LayoutInflater.from(context);

			final AlertDialog dialog = new AlertDialog(context,
					R.style.DialogStyle);

			View layout = null;
			if (null != contentView)
			{
				layout = contentView;
			} else
			{
				layout = inflater.inflate(R.layout.layout_alert_dialog, null);
			}
			// 设置标题
			TextView titleView = (TextView) layout.findViewById(R.id.title);
			if (null == title)
			{
				titleView.setVisibility(View.GONE);
			} else
			{
				titleView.setText(title);
			}
			// 设置内容
			TextView messageView = (TextView) layout.findViewById(R.id.message);
			if (null == message)
			{
				messageView.setVisibility(View.GONE);
			} else
			{
				messageView.setText(message);
			}

			// 设置积极按钮
			Button positiveButton = (Button) layout
					.findViewById(R.id.positiveButton);
			if (null == positiveButtonText
					|| null == positiveButtonClickListener)
			{
				positiveButton.setVisibility(View.GONE);
			} else
			{
				positiveButton.setText(positiveButtonText);
				positiveButton.setOnClickListener(new View.OnClickListener()
				{

					@Override
					public void onClick(View v)
					{
						// TODO Auto-generated method stub
						dialog.dismiss();
						positiveButtonClickListener.onClick(dialog,
								DialogInterface.BUTTON_POSITIVE);
					}
				});
			}

			// 设置消极按钮
			Button negativeButton = (Button) layout
					.findViewById(R.id.negativeButton);
			if (null == negativeButtonText
					|| null == negativeButtonClickListener)
			{
				negativeButton.setVisibility(View.GONE);
			} else
			{
				negativeButton.setText(negativeButtonText);
				negativeButton.setOnClickListener(new View.OnClickListener()
				{

					@Override
					public void onClick(View v)
					{
						// TODO Auto-generated method stub
						dialog.dismiss();
						negativeButtonClickListener.onClick(dialog,
								DialogInterface.BUTTON_NEGATIVE);
					}
				});
			}
			// 设置对话框的视图
			LayoutParams params = new LayoutParams(550,
					LayoutParams.WRAP_CONTENT);
			dialog.setContentView(layout, params);
			return dialog;
		}
	}
}
