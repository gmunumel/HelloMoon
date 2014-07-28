package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();
	//private AudioPlayer mPlayerVideo = new AudioPlayer();
	
	//private VideoView mVideoView;
    
	private Button mPlayButton;
	private Button mStopButton;
	private Button mPauseButton;

	//private Button mPlayVideoButton;
	//private Button mStopVideoButton;
	//private Button mPauseVideoButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// When a fragment is retained, the fragment is not
		// destroyed with the activity. Instead, it is preserved
		// and passed along intact to the new activity.
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, 
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
		
		mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.play(getActivity());
			}
		});

		mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.stop();
			}
		});

		mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
		mPauseButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.pause();
			}
		});

		// Challenge 2 play video
		// Comment the following lines because cause an performance error
		/*
		mVideoView = (VideoView)v.findViewById(R.id.play_videoView);
		Uri resourceUri = Uri.parse("android.resource://" + 
				  "com.bignerdranch.android.hellomoon/raw/apollo_17_stroll");
		mVideoView.setVideoURI(resourceUri);
		//mVideoView.start();
		mPlayVideoButton = (Button)v.findViewById(R.id.hellomoon_play_videoButton);
		mPlayVideoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mVideoView.start();
			}
		});

		mStopVideoButton = (Button)v.findViewById(R.id.hellomoon_stop_videoButton);
		mStopVideoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mVideoView.stopPlayback();
			}
		});

		mPauseVideoButton = (Button)v.findViewById(R.id.hellomoon_pause_videoButton);
		mPauseVideoButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mVideoView.pause();
			}
		});
		*/
		// end challenge 2
		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
		//mVideoView.stopPlayback();
	}
}
