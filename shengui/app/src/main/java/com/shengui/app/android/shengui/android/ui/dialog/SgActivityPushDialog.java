package com.shengui.app.android.shengui.android.ui.dialog;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.ui.activity.activity.video.MainActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.video.RecordVideoActivity;
import com.shengui.app.android.shengui.android.ui.activity.activity.video.RingProgressBar;
import com.shengui.app.android.shengui.utils.android.IntentTools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016/7/12.
 */
@SuppressLint("ValidFragment")
public class SgActivityPushDialog extends DialogFragment implements View.OnClickListener {

    private Context context;
    ImageView cancenlImage;
    /**
     * 是否有足够的剩余空间
     */
    private boolean haveEnoughSpace = false;
    private RingProgressBar ringProgressBar;
    RelativeLayout wentiLayout,gongqiuLayout,tieziLayout,videoLayout;

    @SuppressLint("ValidFragment")
    public SgActivityPushDialog(Context context) {
        this.context = context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        WindowManager.LayoutParams localLayoutParams = getDialog().getWindow().getAttributes();
        localLayoutParams.gravity = Gravity.CENTER;
        localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        localLayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        ButterKnife.bind(this, super.onCreateView(inflater, container, savedInstanceState));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = new Dialog(getActivity(), R.style.MyDialogStyleBottom);
        View view = View.inflate(getActivity(), R.layout.activity_main_push, null);
        cancenlImage=(ImageView)view.findViewById(R.id.cancenlImage);
        gongqiuLayout=(RelativeLayout)view.findViewById(R.id.gongqiuLayout);
        tieziLayout=(RelativeLayout)view.findViewById(R.id.tieziLayout);
        videoLayout=(RelativeLayout)view.findViewById(R.id.videoLayout);
        wentiLayout=(RelativeLayout)view.findViewById(R.id.wentiLayout);
        cancenlImage.setOnClickListener(this);
        gongqiuLayout.setOnClickListener(this);
        tieziLayout.setOnClickListener(this);
        videoLayout.setOnClickListener(this);
        wentiLayout.setOnClickListener(this);
        dialog.setContentView(view);
        return dialog;
    }
    private static final int REQUEST_CAMERA = 0;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CAMERA) {
            boolean flag = false;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Toast.makeText(getActivity(), "已授权", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), RecordVideoActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getActivity(), "授权失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancenlImage:
                dismiss();
                break;
            case R.id.gongqiuLayout:
                IntentTools.startPushGongQiu(getActivity());
                dismiss();
                break;
            case R.id.tieziLayout:
                IntentTools.startPushTiezi(getActivity());
                dismiss();
                break;
            case R.id.videoLayout:
//                IntentTools.startPushVideo(getActivity());
                statrtVideo();
                dismiss();
                break;
            case R.id.wentiLayout:
                IntentTools.startPushQuestion(getActivity());
                dismiss();
                break;
        }

    }
    public void statrtVideo(){
        long freeSpace = getFreeSpace();
        haveEnoughSpace = !(freeSpace < 5242880);//TODO 检测剩余空间，限制是5M
        if (haveEnoughSpace) {
            checkCameraPermission();
        } else {
            Toast.makeText(getActivity(), "剩余空间不够充足，请清理一下再试一次", Toast.LENGTH_SHORT).show();
        }

    }
    //视频录制需要的权限(相机，录音，外部存储)
    private String[] VIDEO_PERMISSION = {
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private List<String> NO_VIDEO_PERMISSION = new ArrayList<String>();

    /**
     * 检测摄像头权限，具备相关权限才能继续
     */
    private void checkCameraPermission() {
        NO_VIDEO_PERMISSION.clear();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (int i = 0; i < VIDEO_PERMISSION.length; i++) {
                if (ActivityCompat.checkSelfPermission(getActivity(), VIDEO_PERMISSION[i]) != PackageManager.PERMISSION_GRANTED) {
                    NO_VIDEO_PERMISSION.add(VIDEO_PERMISSION[i]);
                }
            }
            if (NO_VIDEO_PERMISSION.size() == 0) {
                Intent intent = new Intent(getActivity(), RecordVideoActivity.class);
                startActivity(intent);
                dismiss();
            } else {
                ActivityCompat.requestPermissions(getActivity(), NO_VIDEO_PERMISSION.toArray(new String[NO_VIDEO_PERMISSION.size()]), REQUEST_CAMERA);
            }
        } else {
            Intent intent = new Intent(getActivity(), RecordVideoActivity.class);
            startActivity(intent);
            dismiss();
        }
    }

    /**
     * 获得可用存储空间
     *
     * @return 可用存储空间（单位b）
     */
    public long getFreeSpace() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize;//区块的大小
        long totalBlocks;//区块总数
        long availableBlocks;//可用区块的数量
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            blockSize = stat.getBlockSizeLong();
            totalBlocks = stat.getBlockCountLong();
            availableBlocks = stat.getAvailableBlocksLong();
        } else {
            blockSize = stat.getBlockSize();
            totalBlocks = stat.getBlockCount();
            availableBlocks = stat.getAvailableBlocks();
        }
        //String totalSpace = Formatter.formatFileSize(MyApplication.getInstance().getApplicationContext(), blockSize * totalBlocks);
        //String availableSpace = Formatter.formatFileSize(MyApplication.getInstance().getApplicationContext(), blockSize * availableBlocks);
        //Log.e(LOG_TAG, "totalSpace：" + totalSpace + "...availableSpace：" + availableSpace);
        Log.e("sos-sos", "totalSpace：" + blockSize * totalBlocks + "...availableSpace：" + blockSize * availableBlocks);
        return blockSize * availableBlocks;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
