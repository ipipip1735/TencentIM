package mine.im;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMGroupInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMSimpleMsgListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMUserInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.config.CustomFaceConfig;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationProvider;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static com.tencent.imsdk.v2.V2TIMSDKConfig.V2TIM_LOG_DEBUG;

/**
 * Created by Administrator on 2020/9/22 15:21.
 */
public class UIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_main);


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


    public void login(View view) {
        System.out.println("~~button.login~~");

//        AppApplication appApplication = (AppApplication) getApplication();
//        System.out.println(appApplication.SDKAPPID);
//
//        appApplication = (AppApplication) getApplicationContext();
//        System.out.println(appApplication.SDKAPPID);


        String userid = "ddd";
        String usersig = GenerateTestUserSig.genTestUserSig(userid);

        TUIKit.login(userid, usersig, new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                System.out.println("~~~" + getClass().getSimpleName() + ".onSuccess~~~");
                System.out.println("data is " + data);
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                System.out.println("~~~" + getClass().getSimpleName() + ".onError~~~");
                System.out.println("module is " + module);
                System.out.println("errCode is " + errCode);
                System.out.println("errMsg is " + errMsg);

            }
        });


    }


    public void start(View view) {
        System.out.println("~~button.start~~");

        startActivity(new Intent(this, UIConversationActivity.class));
//        startActivity(new Intent(this, UIChatActivity.class));
//        startActivity(new Intent(this, UIContactActivity.class));
    }


    public void bind(View view) {
        System.out.println("~~button.bind~~");

        //发送C2C信息
//        String loginUser = V2TIMManager.getInstance().getLoginUser();
//        String targetUser = "ccc";
//        String msg = "msg[" + loginUser + "->" + targetUser + "] - " + System.currentTimeMillis();
//        V2TIMMessage v2TIMMessage = V2TIMManager.getMessageManager().createTextMessage("ggg");
//        V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, "ccc", null, V2TIMMessage.V2TIM_PRIORITY_DEFAULT, false, null, new V2TIMSendCallback<V2TIMMessage>() {
//            @Override
//            public void onError(int i, String s) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onError~~");
//                System.out.println("i is " + i);
//                System.out.println("s is " + s);
//            }
//
//            @Override
//            public void onSuccess(V2TIMMessage v2TIMMessage) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onSuccess~~");
//                System.out.println("v2TIMMessage is " + v2TIMMessage);
//
//            }
//
//            @Override
//            public void onProgress(int i) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onProgress~~");
//                System.out.println("i is " + i);
//
//            }
//        });



        //遍历群列表
//        V2TIMManager.getGroupManager().getJoinedGroupList(new V2TIMValueCallback<List<V2TIMGroupInfo>>() {
//            @Override
//            public void onError(int i, String s) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onError~~");
//                System.out.println("i is " + i);
//                System.out.println("s is " + s);
//            }
//
//            @Override
//            public void onSuccess(List<V2TIMGroupInfo> v2TIMGroupInfos) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onSuccess~~");
//                System.out.println("v2TIMGroupInfos is " + v2TIMGroupInfos);
//
//                for (V2TIMGroupInfo info : v2TIMGroupInfos) {
//                    System.out.println("getGroupID is " + info.getGroupID());
//                    System.out.println("getGroupType is " + info.getGroupType());
//                    System.out.println("getGroupName is " + info.getGroupName());
//                    System.out.println("getNotification is " + info.getNotification());
//                    System.out.println("getIntroduction is " + info.getIntroduction());
//                    System.out.println("getFaceUrl is " + info.getFaceUrl());
//                    System.out.println("getOwner is " + info.getOwner());
//                    System.out.println("getCreateTime is " + info.getCreateTime());
//                    System.out.println("getGroupAddOpt is " + info.getGroupAddOpt());
//                    System.out.println("getLastInfoTime is " + info.getLastInfoTime());
//                    System.out.println("getLastMessageTime is " + info.getLastMessageTime());
//                    System.out.println("getMemberCount is " + info.getMemberCount());
//                    System.out.println("getOnlineCount is " + info.getOnlineCount());
//                    System.out.println("getRole is " + info.getRole());
//                    System.out.println("getRecvOpt is " + info.getRecvOpt());
//                    System.out.println("getJoinTime is " + info.getJoinTime());
//                }
//            }
//        });

//        String msg = "msg - " + System.currentTimeMillis();
//        V2TIMMessage v2TIMMessage = V2TIMManager.getMessageManager().createTextMessage(msg);
//        String gid = "@TGS#2VXRT3WGG";
//        V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, null, gid, V2TIMMessage.V2TIM_PRIORITY_DEFAULT, false, null, new V2TIMSendCallback<V2TIMMessage>() {
//            @Override
//            public void onError(int i, String s) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onError~~");
//                System.out.println("i is " + i);
//                System.out.println("s is " + s);
//            }
//
//            @Override
//            public void onSuccess(V2TIMMessage v2TIMMessage) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onSuccess~~");
//                System.out.println("v2TIMMessage is " + v2TIMMessage);
//
//            }
//
//            @Override
//            public void onProgress(int i) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onProgress~~");
//                System.out.println("i is " + i);
//
//            }
//        });

    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

        ConversationManagerKit.getInstance().loadConversation(new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                System.out.println("~~~IUIKitCallBack.onSuccess~~~");
                System.out.println("data is " + data);
                ConversationProvider conversationProvider = (ConversationProvider) data;
                System.out.println(conversationProvider.getDataSource());
            }

            @Override
            public void onError(String module, int errCode, String errMsg) {
                System.out.println("~~~IUIKitCallBack.onError~~~");
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

        V2TIMManager.getInstance().addSimpleMsgListener(new V2TIMSimpleMsgListener() {
            @Override
            public void onRecvC2CTextMessage(String msgID, V2TIMUserInfo sender, String text) {
                System.out.println("~~V2TIMSimpleMsgListener.onRecvC2CTextMessage~~");
                System.out.println("msgID is " + msgID);
                System.out.println("sender is " + sender);
                System.out.println("text is " + text);

                super.onRecvC2CTextMessage(msgID, sender, text);

            }

            @Override
            public void onRecvC2CCustomMessage(String msgID, V2TIMUserInfo sender, byte[] customData) {
                System.out.println("~~V2TIMSimpleMsgListener.onRecvC2CCustomMessage~~");System.out.println("msgID is " + msgID);
                System.out.println("msgID is " + msgID);
                System.out.println("sender is " + sender);
                System.out.println("customData is " + customData.length);

                super.onRecvC2CCustomMessage(msgID, sender, customData);
            }

            @Override
            public void onRecvGroupTextMessage(String msgID, String groupID, V2TIMGroupMemberInfo sender, String text) {
                System.out.println("~~V2TIMSimpleMsgListener.onRecvGroupTextMessage~~");
                System.out.println("msgID is " + msgID);
                System.out.println("sender is " + sender);
                System.out.println("text is " + text);

                super.onRecvGroupTextMessage(msgID, groupID, sender, text);
            }

            @Override
            public void onRecvGroupCustomMessage(String msgID, String groupID, V2TIMGroupMemberInfo sender, byte[] customData) {
                System.out.println("~~V2TIMSimpleMsgListener.onRecvGroupCustomMessage~~");
                System.out.println("msgID is " + msgID);
                System.out.println("sender is " + sender);
                System.out.println("customData is " + customData.length);

                super.onRecvGroupCustomMessage(msgID, groupID, sender, customData);
            }
        });


    }


    public void query(View view) {
        System.out.println("~~button.query~~");

        //获取配置信息
//        GeneralConfig generalConfig = TUIKitConfigs.getConfigs().getGeneralConfig();
//        System.out.println("getUserNickname is " + generalConfig.getUserNickname());
//        System.out.println("getUserFaceUrl is " + generalConfig.getUserFaceUrl());
//        System.out.println("getLogLevel is " + generalConfig.getLogLevel());
//        System.out.println("getAppCacheDir is " + generalConfig.getAppCacheDir());
//        System.out.println("getAudioRecordMaxTime is " + generalConfig.getAudioRecordMaxTime());
//        System.out.println("getVideoRecordMaxTime is " + generalConfig.getVideoRecordMaxTime());
//        System.out.println("getSDKAppId is " + generalConfig.getSDKAppId());
//        System.out.println("getUserId is " + generalConfig.getUserId());
//        System.out.println("getUserSig is " + generalConfig.getUserSig());

        final String userId = "ccc";
        final V2TIMMessage v2TIMMessage = null;
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(userId, 2, null, new V2TIMValueCallback<List<V2TIMMessage>>() {
            @Override
            public void onError(int i, String s) {
                System.out.println("~~V2TIMValueCallback.onError~~");
                System.out.println("i is " + i);
                System.out.println("s is " + s);
            }

            @Override
            public void onSuccess(List<V2TIMMessage> v2TIMMessages) {
                System.out.println("~~V2TIMValueCallback.onSuccess~~");


                for (V2TIMMessage msg : v2TIMMessages) {
                    System.out.println("msg.getMsgID is " + msg.getMsgID());
                }
                System.out.println(v2TIMMessage);
//                v2TIMMessage = v2TIMMessages.get(v2TIMMessages.size() - 1);
            }
        });





    }
}
