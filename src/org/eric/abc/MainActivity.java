package org.eric.abc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.LauncherActivity.ListItem;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnItemSelectedListener {

	private Gallery mTestImgLoopGallery;
	private int mIndex = 0;
	private mGalleryAdapter mAdapter;
	private int mCount = 0;
	private Handler mHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initListener();
		initParam();
		loopThread();
		
	}

	private void initView() {
		mTestImgLoopGallery = (Gallery) findViewById(R.id.test_img_loop);
	}

	private void initParam() {
		List<Drawable> listImg = new ArrayList<Drawable>();
		Drawable mDrawable1 = getResources().getDrawable(R.drawable.test_1);
		listImg.add(mDrawable1);
		mDrawable1 = getResources().getDrawable(R.drawable.test_2);
		listImg.add(mDrawable1);
		mDrawable1 = getResources().getDrawable(R.drawable.test_3);
		listImg.add(mDrawable1);
		mDrawable1 = getResources().getDrawable(R.drawable.test_4);
		listImg.add(mDrawable1);
		mDrawable1 = getResources().getDrawable(R.drawable.test_5);
		listImg.add(mDrawable1);
		mDrawable1 = getResources().getDrawable(R.drawable.test_6);
		listImg.add(mDrawable1);
		mAdapter = new mGalleryAdapter(listImg);
		mTestImgLoopGallery.setAdapter(mAdapter);
		mCount = mAdapter.getCount();
	}

	private void initListener() {
		mTestImgLoopGallery.setOnItemSelectedListener(this);
	}
	
	private void loopThread(){
		mHandler.post(mRunnable);
	}
	
	Runnable mRunnable = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
				loopUpdateUI();
				mHandler.postDelayed(mRunnable, 1000);
		}
	};
	
	private void loopUpdateUI(){
		mIndex++;
		if(mIndex == mCount)
			mIndex = 0;
		mTestImgLoopGallery.setSelection(mIndex);
	}

	class mGalleryAdapter extends BaseAdapter {

		private List<Drawable> listImg;

		public mGalleryAdapter(List<Drawable> listImg) {
			this.listImg = listImg;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return listImg.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return listImg.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
//			Log.e("eric", "111111111111111");
			if (listImg.size() > 0) {
				if (convertView == null) {
					convertView = LayoutInflater.from(MainActivity.this)
							.inflate(R.layout.activity_item, null);
				}
				ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
				imageView.setBackgroundDrawable(listImg.get(position));
			}
//			Log.e("eric", "22222222222222222");
			return convertView;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		mIndex = arg2;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
