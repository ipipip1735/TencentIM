package mine.im;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.component.NoticeLayout;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.base.BaseInputFragment;
import com.tencent.qcloud.tim.uikit.modules.chat.base.ChatInfo;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.input.InputLayout;
import com.tencent.qcloud.tim.uikit.modules.chat.layout.message.MessageLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationProvider;

/**
 * Created by Administrator on 2020/9/23 3:46.
 */
public class UIChatActivity extends AppCompatActivity {
    ChatLayout chatLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_chat);
        chatLayout = findViewById(R.id.cl);
        chatLayout.initDefault();



        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setType(V2TIMConversation.V2TIM_C2C);
        chatInfo.setId("ccc");
        chatInfo.setChatName("xxxx");
        chatLayout.setChatInfo(chatInfo);


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

        final NoticeLayout noticeLayout =  chatLayout.getNoticeLayout();
        noticeLayout.setVisibility(View.VISIBLE);
        noticeLayout.getContent().setText("现在插播一条广告");
        noticeLayout.getContentExtra().setTextColor(getResources().getColor(R.color.DEEPPINK, null));
        noticeLayout.getContentExtra().setText("参看有奖");

        noticeLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                noticeLayout.setVisibility(View.GONE);
            }
        }, 1000L);

    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");

        MessageLayout messageLayout =  chatLayout.getMessageLayout();
        messageLayout.setBackgroundColor(Color.argb(255,255,255,125));
        messageLayout.setAvatarRadius(250);

//        messageLayout.setRightBubble(ResourcesCompat.getDrawable(getResources(), R.drawable.popu_dialog_bg, null));
//        messageLayout.setLeftBubble(getResources().getDrawable(R.drawable.chat_other_bg, null));
//        messageLayout.setNameFontSize(12);
        messageLayout.setChatTimeBubble(new ColorDrawable(Color.argb(255,255,255,0)));

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

        InputLayout inputLayout =  chatLayout.getInputLayout();
        inputLayout.disableCaptureAction(true);
        inputLayout.disableSendFileAction(true);
        inputLayout.disableSendPhotoAction(true);
        inputLayout.disableVideoRecordAction(true);

//        inputLayout.replaceMoreInput(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("~~onClick~~");
//                System.out.println(v);
//            }
//        });


        inputLayout.replaceMoreInput(new CustomInputFragment());
    }


    public void reloading(View view) {
        System.out.println("~~button.reloading~~");
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


    public void del(View view) {
        System.out.println("~~button.del~~");

    }


    public void query(View view) {
        System.out.println("~~button.query~~");

    }

    public static class CustomInputFragment extends BaseInputFragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            System.out.println("---- " + getClass().getSimpleName() + ".onCreateView ----");
            return inflater.inflate(R.layout.fragment_input_more, container, false);
        }
    }
}

