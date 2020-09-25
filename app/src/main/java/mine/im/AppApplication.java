package mine.im;

import android.app.Application;

import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IMEventListener;
import com.tencent.qcloud.tim.uikit.config.CustomFaceConfig;
import com.tencent.qcloud.tim.uikit.config.GeneralConfig;
import com.tencent.qcloud.tim.uikit.config.TUIKitConfigs;

import java.util.List;

/**
 * Created by Administrator on 2020/9/22 17:36.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        System.out.println("--- IMEventListener.onCreate ---");
        super.onCreate();



        TUIKitConfigs configs = TUIKit.getConfigs();
        configs.setSdkConfig(new V2TIMSDKConfig());
        configs.setCustomFaceConfig(new CustomFaceConfig());
        configs.setGeneralConfig(new GeneralConfig());


        TUIKit.addIMEventListener(new IMEventListener() {
            @Override
            public void onForceOffline() {
                System.out.println("~~IMEventListener.onForceOffline~~");
                super.onForceOffline();
            }

            @Override
            public void onUserSigExpired() {
                System.out.println("~~IMEventListener.onUserSigExpired~~");
                super.onUserSigExpired();
            }

            @Override
            public void onConnected() {
                System.out.println("~~IMEventListener.onConnected~~");
                super.onConnected();



            }

            @Override
            public void onDisconnected(int code, String desc) {
                System.out.println("~~IMEventListener.onDisconnected~~");
                super.onDisconnected(code, desc);
            }

            @Override
            public void onWifiNeedAuth(String name) {
                System.out.println("~~IMEventListener.onWifiNeedAuth~~");
                super.onWifiNeedAuth(name);
            }

            @Override
            public void onRefreshConversation(List<V2TIMConversation> conversations) {
                System.out.println("~~IMEventListener.onRefreshConversation~~");
                super.onRefreshConversation(conversations);
            }

            @Override
            public void onNewMessage(V2TIMMessage v2TIMMessage) {
                System.out.println("~~IMEventListener.onNewMessage~~");
                super.onNewMessage(v2TIMMessage);
            }
        });

        TUIKit.init(this, GenerateTestUserSig.SDKAPPID, configs);

    }
}
