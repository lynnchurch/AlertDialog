## AlertDialog
一个可自定义UI风格的对话框，用法和原生的AlertDialog类似。
## 效果图
下面是一个仿ios风格的对话框效果图：
>![ios风格的效果图](https://github.com/lynnchurch/AlertDialog/blob/master/screenshot/screenshot.jpg)
## 使用
### 用法如下所示：

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
    builder.create().show();

如需使用自定义风格则使用`setContentView(View v)`，v为自定义视图对象，各控件的id须与原布局文件`layout_dialog.xml`保持一致。