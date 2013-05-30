package se.mah.k3.cards;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartScreen extends Activity {
	Animation startanim1, startanim2,clickanim1,clickanim2;
	MediaPlayer startsound;
	MediaPlayer startmusic;
	ImageView playcard;
	ImageView highscorecard;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// fullscreen
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		startsound=MediaPlayer.create(getApplicationContext(), R.raw.playbutton);
		startmusic=MediaPlayer.create(getApplicationContext(), R.raw.startmusic);
		startanim1= AnimationUtils.loadAnimation(this, R.anim.menuanim1);
		startanim2= AnimationUtils.loadAnimation(this, R.anim.menuanim2);
		clickanim1=AnimationUtils.loadAnimation(this, R.anim.menuanim3);
		clickanim2=AnimationUtils.loadAnimation(this, R.anim.menuanim4);
		setContentView(R.layout.menuscreen);
		// G�r en imageview av playkortet
		playcard = (ImageView) findViewById(R.id.playcard);
		// G�r en imageview av highscorekortet
		highscorecard = (ImageView) findViewById(R.id.highscorecard);
		// Ljud f�r playkortet
		startmusic.setLooping(true);
		startmusic.start();
		playcard.startAnimation(startanim1);
		highscorecard.startAnimation(startanim2);
		playcard.setVisibility(View.VISIBLE);
		playcard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playcard.startAnimation(clickanim1);
				startsound.seekTo(0);
				startsound.start();
				
				
				
				
				startmusic.pause();
				//Intent intent = new Intent(v.getContext(), MainActivity.class);
				//startActivityForResult(intent, 0);
				
				}
		});
		clickanim1.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivityForResult(intent, 0);
				playcard.setVisibility(View.INVISIBLE);
				finish();
			}
		});

		// Ljud f�r highscorekortet
		highscorecard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					
						highscorecard.startAnimation(clickanim2);
						startsound.seekTo(0);
						startsound.start();
					
					
					
				switch (v.getId()) {
				case R.drawable.highscorekort:
					break;
				}

			}
		});

	}
	
		
@Override
protected void onPause(){
	super.onPause();
	startmusic.pause();
	
}
@Override
protected void onResume(){
	super.onResume();
	startmusic.start();	
	playcard.setVisibility(View.VISIBLE);
	
}
@Override
protected void onDestroy(){
	super.onDestroy();
	startmusic.release();
	startsound.release();
}
}

