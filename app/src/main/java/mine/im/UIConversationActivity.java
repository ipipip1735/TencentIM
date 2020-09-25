package mine.im;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMGroupInfo;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.tencent.qcloud.tim.uikit.component.TitleBarLayout;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;
import com.tencent.qcloud.tim.uikit.modules.chat.ChatLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationListLayout;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationManagerKit;
import com.tencent.qcloud.tim.uikit.modules.conversation.ConversationProvider;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2020/9/22 15:21.
 */
public class UIConversationActivity extends AppCompatActivity {
    ConversationLayout conversationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");
        setContentView(R.layout.activity_conversation);
        conversationLayout = findViewById(R.id.cl);
        conversationLayout.initDefault();


        //设置会话列表
//        ConversationListLayout listLayout = conversationLayout.getConversationList();
//        listLayout.setItemTopTextSize(20); //设置 item 中 top 文字大小
//        listLayout.setItemBottomTextSize(12);//设置 item 中 bottom 文字大小
//        listLayout.setItemDateTextSize(10);//设置 item 中 timeline 文字大小
//        listLayout.setItemAvatarRadius(50); //设置 adapter item 头像圆角大小
//        listLayout.disableItemUnreadDot(true);//设置 item 是否不显示未读红点，默认显示




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

        TitleBarLayout titleBarLayout = conversationLayout.findViewById(R.id.conversation_title);
        titleBarLayout.setTitle("TTTT", TitleBarLayout.POSITION.MIDDLE);
        titleBarLayout.getLeftGroup().setVisibility(View.GONE);
        titleBarLayout.setRightIcon(R.drawable.conversation_more);

    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");


        V2TIMManager.getInstance().getUsersInfo(Arrays.asList(V2TIMManager.getInstance().getLoginUser()), new V2TIMValueCallback<List<V2TIMUserFullInfo>>() {
            @Override
            public void onError(int i, String s) {
                System.out.println("~~V2TIMValueCallback.onError~~");
                System.out.println("i is " + i);
                System.out.println("s is " + s);

            }

            @Override
            public void onSuccess(List<V2TIMUserFullInfo> v2TIMUserFullInfos) {
                System.out.println("~~V2TIMValueCallback.onSuccess~~");

                for (V2TIMUserFullInfo info : v2TIMUserFullInfos) {
                    System.out.println(info);
                }


                V2TIMUserFullInfo info = v2TIMUserFullInfos.get(0);
                info.setFaceUrl("https://www.tencent.com/img/index/icon_wechat.png");
                V2TIMManager.getInstance().setSelfInfo(info, new V2TIMCallback() {
                    @Override
                    public void onError(int i, String s) {
                        System.out.println("~~V2TIMValueCallback.onError~~");
                        System.out.println("i is " + i);
                        System.out.println("s is " + s);

                    }

                    @Override
                    public void onSuccess() {
                        System.out.println("~~V2TIMValueCallback.onSuccess~~");
                    }
                });

            }
        });






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


        V2TIMMessage v2TIMMessage = V2TIMManager.getMessageManager().createTextMessage("ggg");
        V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, "ccc", null, V2TIMMessage.V2TIM_PRIORITY_DEFAULT, false, null, new V2TIMSendCallback<V2TIMMessage>() {
            @Override
            public void onError(int i, String s) {
                System.out.println("~~" + getClass().getSimpleName() + ".onError~~");
                System.out.println("i is " + i);
                System.out.println("s is " + s);

            }

            @Override
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                System.out.println("~~" + getClass().getSimpleName() + ".onSuccess~~");
                System.out.println("v2TIMMessage is " + v2TIMMessage);

            }

            @Override
            public void onProgress(int i) {
                System.out.println("~~" + getClass().getSimpleName() + ".onProgress~~");
                System.out.println("i is " + i);

            }
        });
    }


    public void query(View view) {
        System.out.println("~~button.query~~");


        V2TIMManager.getGroupManager().getJoinedGroupList(new V2TIMValueCallback<List<V2TIMGroupInfo>>() {
            @Override
            public void onError(int i, String s) {
                System.out.println("~~" + getClass().getSimpleName() + ".onError~~");
                System.out.println("i is " + i);
                System.out.println("s is " + s);

            }

            @Override
            public void onSuccess(List<V2TIMGroupInfo> v2TIMGroupInfos) {
                System.out.println("~~V2TIMValueCallback.onSuccess~~");

                for (V2TIMGroupInfo info : v2TIMGroupInfos) {
                    System.out.println("getGroupID is " + info.getGroupID());
                    System.out.println("getGroupType is " + info.getGroupType());
                    System.out.println("getGroupName is " + info.getGroupName());
                    System.out.println("getNotification is " + info.getNotification());
                    System.out.println("getIntroduction is " + info.getIntroduction());
                    System.out.println("getFaceUrl is " + info.getFaceUrl());
                    System.out.println("getOwner is " + info.getOwner());
                    System.out.println("getCreateTime is " + info.getCreateTime());
                    System.out.println("getGroupAddOpt is " + info.getGroupAddOpt());
                    System.out.println("getLastInfoTime is " + info.getLastInfoTime());
                    System.out.println("getLastMessageTime is " + info.getLastMessageTime());
                    System.out.println("getMemberCount is " + info.getMemberCount());
                    System.out.println("getOnlineCount is " + info.getOnlineCount());
                    System.out.println("getRole is " + info.getRole());
                    System.out.println("getRecvOpt is " + info.getRecvOpt());
                    System.out.println("getJoinTime is " + info.getJoinTime());
                }
//                modifyGroup(v2TIMGroupInfos.get(0));

                V2TIMGroupInfo v2TIMGroupInfo = new V2TIMGroupInfo();
                v2TIMGroupInfo.setGroupID(v2TIMGroupInfos.get(0).getGroupID());
                v2TIMGroupInfo.setGroupName("tttt");


                V2TIMManager.getGroupManager().setGroupInfo(v2TIMGroupInfo, new V2TIMCallback() {
                    @Override
                    public void onError(int i, String s) {
                        System.out.println("~~onError~~");
                        System.out.println("i is " + i);
                        System.out.println("s is " + s);
                    }

                    @Override
                    public void onSuccess() {
                        System.out.println("~~onSuccess~~");
                    }
                });


            }
        });



    }


    private void modifyGroup(V2TIMGroupInfo info) {
        V2TIMManager.getGroupManager().setGroupInfo(info, new V2TIMCallback() {
            @Override
            public void onError(int i, String s) {
                System.out.println("~~" + getClass().getSimpleName() + ".onError~~");
                System.out.println("i is " + i);
                System.out.println("s is " + s);
            }

            @Override
            public void onSuccess() {
                System.out.println("~~" + getClass().getSimpleName() + ".onSuccess~~");
            }
        });
    }
}
