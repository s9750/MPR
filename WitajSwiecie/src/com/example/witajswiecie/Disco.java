package com.example.witajswiecie;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Disco extends Activity implements OnClickListener{

  	ImageView image;
  	ImageView bkg;
  	Button button;
  	Button stpButton;
  	ToggleButton black;
  	ToggleButton pink;
  	ToggleButton blue;
  	int number = 0;
	MediaPlayer mediaPlayer;
	AnimationDrawable frameAnimation;
	AnimationDrawable frameAnimation2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.activity_witaj_swiecie);
    	image = (ImageView) findViewById(R.id.imageView1);
    	image.setBackgroundResource(R.drawable.disco_1);
    	
    	bkg = (ImageView) findViewById(R.id.imageView2);
    	bkg.setBackgroundResource(R.drawable.bkg);
    	
    	button = (Button) findViewById(R.id.btnChangeImage);
    	button.setOnClickListener(this);   	
    	
    	stpButton = (Button) findViewById(R.id.btnStopMusic);
    	stpButton.setOnClickListener(this);
    	stpButton.setVisibility(View.GONE);
    	
    	black = (ToggleButton) findViewById(R.id.toggleButton1);
    	black.setOnClickListener(this);
    	pink = (ToggleButton) findViewById(R.id.toggleButton2);
    	pink.setOnClickListener(this);
    	blue = (ToggleButton) findViewById(R.id.toggleButton3);
    	blue.setOnClickListener(this);
    	
 		black.setVisibility(View.GONE);
 		pink.setVisibility(View.GONE);
 		blue.setVisibility(View.GONE);
    	
    }
    
	   public void onClick(View v) {

		      switch (v.getId()) {
		         case R.id.btnStopMusic: 
		        	 new AlertDialog.Builder(this)
		        	    .setTitle("Stop!")
		        	    .setMessage(R.string.tired)
		        	    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
		        	        public void onClick(DialogInterface dialog, int which) { 
		   		        	 if(mediaPlayer.isPlaying())
				        	 {
		   		        		black.setVisibility(View.GONE);
		   		        		pink.setVisibility(View.GONE);
		   		        		blue.setVisibility(View.GONE);

								mediaPlayer.stop();	
				        	 	mediaPlayer.release();
				        	 	mediaPlayer = null;
				        	 	stpButton.setVisibility(View.GONE);
				        	 	frameAnimation.stop();
				        	 	frameAnimation2.stop();
				        	 }
		        	        }
		        	     })
		        	    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
		        	        public void onClick(DialogInterface dialog, int which) { 
		        	            // do nothing
		        	        }
		        	     })
		        	     .show();

		        	 break;
		         case R.id.btnChangeImage:

		        	 if(mediaPlayer==null){
		        		 mediaPlayer = MediaPlayer.create(this , R.raw.disco); 
		        	 }
		        	 if(!mediaPlayer.isPlaying())
		        	 {
		        		 mediaPlayer.start();
		        	 }
		        	 		stpButton.setVisibility(View.VISIBLE);
		        	 		black.setVisibility(View.VISIBLE);
		        	 		pink.setVisibility(View.VISIBLE);
		        	 		blue.setVisibility(View.VISIBLE);
		        	 		image.setBackgroundResource(R.drawable.ani);
		        	 		frameAnimation = (AnimationDrawable) image.getBackground();
		        	 		frameAnimation.start();	
		        	 		
		        	 		bkg.setBackgroundResource(R.drawable.anibkg);
		        	 		frameAnimation2 = (AnimationDrawable) bkg.getBackground();
		        	 		frameAnimation2.start();
		        	 		black.setChecked(true);
		          break;
		         case R.id.toggleButton1:
	        	 	 bkg.setBackgroundResource(R.drawable.anibkg);
	        	 	 frameAnimation2 = (AnimationDrawable) bkg.getBackground();
	        	 	 frameAnimation2.start();
	        	 	 black.setChecked(true);
	        	 	 pink.setChecked(false);
	        	 	 blue.setChecked(false);
		        	 break;
		         case R.id.toggleButton2:
	        	 	 bkg.setBackgroundResource(R.drawable.anibkgpink);
	        	 	 frameAnimation2 = (AnimationDrawable) bkg.getBackground();
	        	 	 frameAnimation2.start();
	        	 	 blue.setChecked(false);
	        	 	 pink.setChecked(true);
	        	 	 black.setChecked(false);
		        	 break;
		         case R.id.toggleButton3:
	        	 	 bkg.setBackgroundResource(R.drawable.anibkgblue);
	        	 	 frameAnimation2 = (AnimationDrawable) bkg.getBackground();
	        	 	 frameAnimation2.start();
	        	 	 pink.setChecked(false);
	        	 	 black.setChecked(false);
	        	 	 blue.setChecked(true);
		        	 break;
		      }
		   }
   

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_witaj_swiecie, menu);
        return true;
    }


}
