package com.shengui.app.android.shengui.android.ui.activity.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.base.view.view.dialog.factory.DialogFacory;
import com.shengui.app.android.shengui.R;
import com.shengui.app.android.shengui.android.base.BaseActivity;
import com.shengui.app.android.shengui.android.ui.dialog.SgActivityPushSuccessDialog;
import com.shengui.app.android.shengui.android.ui.utilsview.EditTextMultiLine;
import com.shengui.app.android.shengui.android.ui.utilsview.GridAdapter;
import com.shengui.app.android.shengui.android.ui.utilsview.MultiImageSelectorActivity;
import com.shengui.app.android.shengui.android.ui.utilsview.NoScrollGridView;
import com.shengui.app.android.shengui.utils.android.IntentTools;
import com.shengui.app.android.shengui.utils.android.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by User on 2016/8/9.
 */
public class SgPushTieziDetailActivity extends BaseActivity implements View.OnClickListener,View.OnLayoutChangeListener {

    @Bind(R.id.cancelTextView)
    TextView cancelTextView;
    @Bind(R.id.pushTextView)
    TextView pushTextView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.titleEt)
    EditTextMultiLine titleEt;
    @Bind(R.id.mGridView)
    NoScrollGridView mGridView;
    @Bind(R.id.imageCount)
    TextView imageCount;
    @Bind(R.id.quanzilayout)
    RelativeLayout quanzilayout;
    @Bind(R.id.faceimage)
    ImageView faceimage;
//    @Bind(R.id.scrollView)
//    ScrollView scrollView;
    @Bind(R.id.rootlayout)
    RelativeLayout rootlayout;
    @Bind(R.id.inputlayout)
    RelativeLayout inputlayout;
    private GridAdapter gridAdapter;
    public static ArrayList<String> bmp;
    private String type = "";
    private Dialog dialog;
    private int screenHeight = 0;
    private int keyHeight = 0;
    @Override
    protected void initView() {
        ButterKnife.bind(this);
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        keyHeight = screenHeight/3;
    }

    @Override
    protected void initEvent() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (arg2 == bmp.size()) {
                    IntentTools.openImageChooseActivity(SgPushTieziDetailActivity.this, bmp);
                }
            }
        });
        cancelTextView.setOnClickListener(this);
        pushTextView.setOnClickListener(this);
        quanzilayout.setOnClickListener(this);
    }

    public void deleteImage(String path) {
        if (bmp.contains(path))
            bmp.remove(path);
        imageCount.setText(bmp.size() + "/9");
        gridAdapter.setBitmaps(bmp);
    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("type");
        dialog = DialogFacory.getInstance().createRunDialog(this, "正在提交。。");
        bmp = new ArrayList<String>();
        gridAdapter = new GridAdapter(this, bmp, 9);
        mGridView.setAdapter(gridAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback_detail;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case MultiImageSelectorActivity.REQUEST_CODE:
                    List<String> selectImages = data.getStringArrayListExtra("select_result");
                    bmp.clear();
                    bmp.addAll(selectImages);
                    imageCount.setText(bmp.size() + "/9张");
                    gridAdapter.setBitmaps(bmp);
                    break;

            }
        }
    }

    @Override
    public void onData(Serializable result, int flag, boolean fromNet, Object o, Map<String, Object> param) {

    }

    //发布成功弹窗
    public void PopUpDialog() {   //弹框
        final SgActivityPushSuccessDialog PopUpDialogs = new SgActivityPushSuccessDialog(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
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
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.pushTextView:
                PopUpDialog();
                break;
            case R.id.cancelTextView:
                finish();
                break;
            case R.id.quanzilayout:
                IntentTools.startquanzilist(this);
                break;
//            case R.id.feedbackTextView:
//                if (StringTools.isNullOrEmpty(titleEt.getText().toString())){
//                    ToastTool.show("请输入反馈内容");
//                    return;
//                }
//                List<NameValuePair> httpParams = new ArrayList<>();
//                httpParams.add(new BasicNameValuePair("type", type));
//                httpParams.add(new BasicNameValuePair("content", titleEt.getText().toString()));
//                httpParams.add(new BasicNameValuePair("mobile", editText.getText().toString()));
//                HttpConfigBean config = HttpManager.getInstance().getConifgById(HttpConfig.pushtiezi);
//                new UploadAnswerImageTask(httpParams).execute(bmp,
//                        UrlRes.getInstance().getUrl() + config.getActioin());
//                break;
//        }
        }


//    public class UploadAnswerImageTask extends AsyncTask<Object, Void, Integer> {
//        JSONObject mJson;
//        ResponseHandler mResponseHandler;
//        List<NameValuePair> mHttpParams;
//
//        public UploadAnswerImageTask(List<NameValuePair> params) {
//
//            mHttpParams = params;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            if (null != dialog && !dialog.isShowing()) {
//                dialog.show();
//            }
//        }
//
//        @Override
//        protected Integer doInBackground(Object... params) {
//            try {
//                ArrayList<File> imgFiles = new ArrayList<File>();
//                if (params[0] instanceof String) {
//                    File f = new File((String) params[0]);
//                    if (f.exists()) {
//                        imgFiles.add(f);
//                    }
//                } else if (params[0] instanceof List) {
//                    List<String> imgFns = (List<String>) params[0];
//                    for (String fn : imgFns) {
//                        File f = new File(fn);
//                        if (f.exists()) {
//                            imgFiles.add(f);
//                        }
//                    }
//                }
//
//
//                final String url = (String) params[1];
//                PostMethod method = new PostMethod(url);
//                method.addRequestHeader("ACCEPT", "application/json");
//
//                if (!StringTools.isNullOrEmpty(PreferceManager.getInsance().getValueBYkey(Constans.jseesion))) {
//                    String session = PreferceManager.getInsance().getValueBYkey(Constans.jseesion);
//                    method.addRequestHeader("Cookie", "JSESSIONID=" + session);
//                    com.base.platform.utils.android.Logger.e("session = " + session);
//                }
//
//
//                HttpClient client = new HttpClient();
//                client.getHttpConnectionManager().getParams().setConnectionTimeout(100000);
//                Part[] parts = new Part[mHttpParams.size() + imgFiles.size()];
//
//                for (int i = 0; i < mHttpParams.size(); ++i) {
//                    NameValuePair pair = mHttpParams.get(i);
//                    parts[i] = new StringPart(pair.getName(), pair.getValue(), "UTF-8");
//                }
//
//                for (int i = 0; i < imgFiles.size(); ++i) {
//                    parts[mHttpParams.size() + i] = new FilePart("payload", "jpg", imgFiles.get(i), "image/jpeg", null);
//                }
//
//                method.setRequestEntity(new MultipartRequestEntity(parts, method.getParams()));
//                client.executeMethod(method);
//                String responseString = method.getResponseBodyAsString();
//                method.releaseConnection();
//
//                if (responseString != null) {
//                    mJson = new JSONObject(responseString);
//                    return method.getStatusCode();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            return HttpStatus.SC_BAD_REQUEST;
//        }
//
//        @Override
//        protected void onPostExecute(Integer statusCode) {
//            if (null != dialog && dialog.isShowing()) {
//                dialog.dismiss();
//            }
//            if (statusCode == HttpStatus.SC_OK && mJson != null) {
//                ToastTool.show("反馈成功");
//                finish();
//            } else if (mJson != null) {
//                try {
//                    ToastTool.show(mJson.getString("message"));
//                } catch (Exception e) {
//                }
//
//            }
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        rootlayout.addOnLayoutChangeListener(this);
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if(oldBottom != 0 && bottom != 0 &&(oldBottom - bottom > keyHeight)){
            inputlayout.setVisibility(View.VISIBLE);
        }else if(oldBottom != 0 && bottom != 0 &&(bottom - oldBottom > keyHeight)){
            inputlayout.setVisibility(View.GONE);
        }
    }
}
