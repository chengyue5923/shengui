package com.shengui.app.android.shengui.android.ui.activity.activity.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.ui.dialog.SgActivityPushSuccessDialog;
import com.shengui.app.android.shengui.android.ui.utilsview.EditTextMultiLine;
import com.shengui.app.android.shengui.utils.android.IntentTools;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 视频认证上传界面
 * Created by Wood on 2016/4/7.
 */
public class VideoPreviewActivity extends AppCompatActivity implements View.OnClickListener ,View.OnLayoutChangeListener {
    private static final String LOG_TAG = "VideoPreviewActivity";
    private static final int RES_CODE = 111;

    /**
     * 播放进度
     */
    private static final int PLAY_PROGRESS = 110;

    EditTextMultiLine titleEt;
    RelativeLayout quanzilayout;
    private VideoView videoViewShow;
    private ImageView imageViewShow;
    private Button buttonDone;
    private RelativeLayout rlBottomRoot;
    private Button buttonPlay;
    private TextView textViewCountDown,cancelTextView,pushTextView;
    private ProgressBar progressVideo;
    /**
     * 视频路径
     */
    private String path;
    /**
     * 视频时间
     */
    private int time;
    private int currentTime;
    private Timer timer;
    private int screenHeight = 0;
    private int keyHeight = 0;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case PLAY_PROGRESS:
//                    LogUtil.e(LOG_TAG, "getDuration：" + videoViewShow.getDuration() + "...getCurrentPosition：" + videoViewShow.getCurrentPosition());
                    time = (videoViewShow.getDuration() + 1000) / 1000;
                    currentTime = (videoViewShow.getCurrentPosition() + 1500) / 1000;
                    progressVideo.setMax(videoViewShow.getDuration());
//                    LogUtil.e(LOG_TAG, time + "..time：" + currentTime);
                    progressVideo.setProgress(videoViewShow.getCurrentPosition());
                    if (currentTime < 10) {
                        textViewCountDown.setText("00:0" + currentTime);
                    } else {
                        textViewCountDown.setText("00:" + currentTime);
                    }
                    //currentTime++;
                    //达到指定时间，停止播放
                    if (!videoViewShow.isPlaying() && time > 0) {
                        progressVideo.setProgress(videoViewShow.getDuration());
                        if (timer != null) {
                            timer.cancel();
                        }
                    }
                    break;
            }
        }
    };
    /**
     * 要上传的视频文件
     */
    private File file;
    private RelativeLayout rootLayout;
    private RelativeLayout hindlayout;

    private void assignViews() {
        rootLayout=(RelativeLayout)findViewById(R.id.rootlayout);
        hindlayout=(RelativeLayout)findViewById(R.id.hindlayout);
        cancelTextView=(TextView)findViewById(R.id.cancelTextView);
        cancelTextView.setOnClickListener(this);
        pushTextView=(TextView)findViewById(R.id.pushTextView);
        pushTextView.setOnClickListener(this);
        quanzilayout=(RelativeLayout)findViewById(R.id.quanzilayout);
        quanzilayout.setOnClickListener(this);
        titleEt=(EditTextMultiLine)findViewById(R.id.titleEt);
        videoViewShow = (VideoView) findViewById(R.id.videoView_show);
        imageViewShow = (ImageView) findViewById(R.id.imageView_show);
        buttonDone = (Button) findViewById(R.id.button_done);
        rlBottomRoot = (RelativeLayout) findViewById(R.id.rl_bottom_root);
        buttonPlay = (Button) findViewById(R.id.button_play);
        textViewCountDown = (TextView) findViewById(R.id.textView_count_down);
        progressVideo = (ProgressBar) findViewById(R.id.progressBar_loading);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_attestation_upload);
        assignViews();
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        keyHeight = screenHeight/3;
        initView();
        initData();
    }

    public void initView() {
        ((TextView) findViewById(R.id.title)).setText("视频预览");
        findViewById(R.id.title_left).setOnClickListener(this);

        buttonDone.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);

        textViewCountDown.setText("00:00");

        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) videoViewShow.getLayoutParams();
        layoutParams.height = width * 4 / 3;//根据屏幕宽度设置预览控件的尺寸，为了解决预览拉伸问题
        //LogUtil.e(LOG_TAG, "mSurfaceViewWidth:" + width + "...mSurfaceViewHeight:" + layoutParams.height);
        videoViewShow.setLayoutParams(layoutParams);
        imageViewShow.setLayoutParams(layoutParams);

        FrameLayout.LayoutParams rlBottomRootLayoutParams = (FrameLayout.LayoutParams) rlBottomRoot.getLayoutParams();
        rlBottomRootLayoutParams.height = width / 3 * 2;
        rlBottomRoot.setLayoutParams(rlBottomRootLayoutParams);
    }

    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            path = intent.getExtras().getString("path", "");
            file = new File(path);
        }

        //获取第一帧图片，预览使用
        if (file.length() != 0) {
            MediaMetadataRetriever media = new MediaMetadataRetriever();
            media.setDataSource(path);
            Bitmap bitmap = media.getFrameAtTime();
            imageViewShow.setImageBitmap(bitmap);
        }
    }

    /**
     * 播放视频
     */
    private void playVideo() {
        textViewCountDown.setText("00:00");
        progressVideo.setProgress(0);

        //视频控制面板，不需要可以不设置
        //MediaController controller = new MediaController(this);
        //controller.setVisibility(View.GONE);
        //videoViewShow.setMediaController(controller);
        videoViewShow.setVideoPath(path);
        videoViewShow.start();
        videoViewShow.requestFocus();
        videoViewShow.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!videoViewShow.isPlaying()) {
                    buttonPlay.setVisibility(View.VISIBLE);
                }
            }
        });

        currentTime = 0;//时间计数器重新赋值
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(PLAY_PROGRESS);
            }
        }, 0, 100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_done:
                setResult(RES_CODE);
                finish();
                break;
            case R.id.button_play:
                buttonPlay.setVisibility(View.GONE);
                imageViewShow.setVisibility(View.GONE);
                playVideo();
                break;
            case R.id.title_left:
                finish();
                break;
            case R.id.cancelTextView:
                IntentTools.startMain(this);
                finish();
                break;
            case R.id.pushTextView:
                PopUpDialog();
                break;
            case R.id.quanzilayout:
                IntentTools.startquanzilist(this);
                break;
        }
    }

    //发布成功弹窗
    public void PopUpDialog() {   //弹框
        final SgActivityPushSuccessDialog PopUpDialogs = new SgActivityPushSuccessDialog(this);
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        PopUpDialogs.show(fragmentTransaction, "ActivityNoticeDialog");
//        PopUpDialogs.dismiss();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    PopUpDialogs.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        IntentTools.startMain(this);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoViewShow.stopPlayback();
    }

    @Override
    protected void onResume() {
        super.onResume();
        rootLayout.addOnLayoutChangeListener(this);
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if(oldBottom != 0 && bottom != 0 &&(oldBottom - bottom > keyHeight)){
            hindlayout.setVisibility(View.VISIBLE);
        }else if(oldBottom != 0 && bottom != 0 &&(bottom - oldBottom > keyHeight)){
            hindlayout.setVisibility(View.GONE);
        }
    }
}
