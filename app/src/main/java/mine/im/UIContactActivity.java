package mine.im;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactLayout;
import com.tencent.qcloud.tim.uikit.modules.contact.ContactListView;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationProvider;

/**
 * Created by Administrator on 2020/9/23 4:29.
 */
public class UIContactActivity extends AppCompatActivity {
    ContactLayout contactLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_contact);
        contactLayout = findViewById(R.id.cl);
        contactLayout.initDefault();

        TitleBarLayout titleBar = contactLayout.getTitleBar();
        ContactListView contactListView = contactLayout.getContactListView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("*********  " + getClass().getSimpleName() + ".onStart  *********");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onRestoreInstanceState  *********");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("*********  " + getClass().getSimpleName() + ".onRestart  *********");

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("*********  " + getClass().getSimpleName() + ".onResume  *********");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("*********  " + getClass().getSimpleName() + ".onPause  *********");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("*********  " + getClass().getSimpleName() + ".onBackPressed  *********");
    }


    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("*********  " + getClass().getSimpleName() + ".onStop  *********");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onSaveInstanceState  *********");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("*********  " + getClass().getSimpleName() + ".onDestroy  *********");
    }


    public void start(View view) {
        System.out.println("~~button.start~~");
        startActivity(new Intent(this, UIContactNewFriendActivity.class));

    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");


    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

        GeneralConfig generalConfig = TUIKitConfigs.getConfigs().getGeneralConfig();
        System.out.println("getUserNickname is " + generalConfig.getUserNickname());
        System.out.println("getUserFaceUrl is " + generalConfig.getUserFaceUrl());
        System.out.println("getLogLevel is " + generalConfig.getLogLevel());
        System.out.println("getAppCacheDir is " + generalConfig.getAppCacheDir());
        System.out.println("getAudioRecordMaxTime is " + generalConfig.getAudioRecordMaxTime());
        System.out.println("getVideoRecordMaxTime is " + generalConfig.getVideoRecordMaxTime());
        System.out.println("getSDKAppId is " + generalConfig.getSDKAppId());
        System.out.println("getUserId is " + generalConfig.getUserId());
        System.out.println("getUserSig is " + generalConfig.getUserSig());
    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

        ConversationManagerKit.getInstance().loadConversation(new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                System.out.println("~~~ " + getClass().getSimpleName() + ".onSuccess ~~~");
                System.out.println("data is " + data);
                ConversationProvider conversationProvider = (ConversationProvider) data;
                System.out.println(conversationProvider.getDataSource());
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                System.out.println("~~~ " + getClass().getSimpleName() + ".onError ~~~");
                System.out.println("module is " + module);
                System.out.println("errCode is " + errCode);
                System.out.println("errMsg is " + errMsg);
            }
        });

    }

    public void reloading(View view) {
        System.out.println("~~button.reloading~~");

    }


    public void del(View view) {
        System.out.println("~~button.del~~");

    }


    public void query(View view) {
        System.out.println("~~button.query~~");

    }
}
