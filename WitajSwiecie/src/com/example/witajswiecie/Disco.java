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
  	Button button;
  	Button stpButton;
  	ToggleButton exitBtn;
  	int number = 0;
	MediaPlayer mediaPlayer;
	AnimationDrawable frameAnimation;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.activity_witaj_swiecie);
    	image = (ImageView) findViewById(R.id.imageView1);
    	image.setBackgroundResource(R.drawable.disco_1);
    	button = (Button) findViewById(R.id.btnChangeImage);
    	button.setOnClickListener(this);   	
    	
    	stpButton = (Button) findViewById(R.id.btnStopMusic);
    	stpButton.setOnClickListener(this);
    	stpButton.setVisibility(View.GONE);
    	
    	exitBtn = (ToggleButton) findViewById(R.id.toggleButton1);
    	exitBtn.setOnClickListener(this);
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
								mediaPlayer.stop();	
				        	 	mediaPlayer.release();
				        	 	mediaPlayer = null;
				        	 	stpButton.setVisibility(View.GONE);
				        	 	frameAnimation.stop();
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
		        	 		
		        	 		image.setBackgroundResource(R.drawable.ani);
		        	 		frameAnimation = (AnimationDrawable) image.getBackground();
		        	 		frameAnimation.start();				
		          break;
		         case R.id.toggleButton1:
		        	 finish();
		        	 break;
		      }
		   }
   

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_witaj_swiecie, menu);
        return true;
    }


}
