package mine.im;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;

import static com.tencent.imsdk.v2.V2TIMSDKConfig.V2TIM_LOG_DEBUG;

/**
 * Created by Administrator on 2020/9/22 15:21.
 */
public class NUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("*********  " + getClass().getSimpleName() + ".onStart  *********");
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


    public void start(View view) {
        System.out.println("~~button.start~~");

        V2TIMSDKConfig config = new V2TIMSDKConfig();
        config.setLogLevel(V2TIM_LOG_DEBUG);
        System.out.println(config);

        int sdkAppID = 0;

        V2TIMManager.getInstance().initSDK(this, sdkAppID, config, new V2TIMSDKListener() {
            @Override
            public void onConnecting() {
                System.out.println("~~ " + getClass().getSimpleName() + ".onConnecting ~~");
                super.onConnecting();
            }

            @Override
            public void onConnectSuccess() {
                System.out.println("~~ " + getClass().getSimpleName() + ".onConnectSuccess ~~");
                super.onConnectSuccess();
                String userID = "";
                String userSig = "";
                V2TIMManager.getInstance().login(userID, userSig, new V2TIMCallback() {
                    @Override
                    public void onError(int i, String s) {
                        System.out.println("~~" + getClass().getSimpleName() + ".onError~~");

                    }

                    @Override
                    public void onSuccess() {
                        System.out.println("~~" + getClass().getSimpleName() + ".onSuccess~~");

                    }
                });
            }

            @Override
            public void onConnectFailed(int code, String error) {
                System.out.println("~~ " + getClass().getSimpleName() + ".onConnectFailed ~~");
                super.onConnectFailed(code, error);
            }

            @Override
            public void onKickedOffline() {
                System.out.println("~~ " + getClass().getSimpleName() + ".onKickedOffline ~~");
                super.onKickedOffline();
            }

            @Override
            public void onUserSigExpired() {
                System.out.println("~~ " + getClass().getSimpleName() + ".onUserSigExpired ~~");
                super.onUserSigExpired();
            }

            @Override
            public void onSelfInfoUpdated(V2TIMUserFullInfo info) {
                System.out.println("~~ " + getClass().getSimpleName() + ".inf ~~");
                super.onSelfInfoUpdated(info);
            }
        });

    }


    public void stop(View view) {
        System.out.println("~~button.stop~~");
    }

    public void bind(View view) {
        System.out.println("~~button.bind~~");

    }

    public void unbind(View view) {
        System.out.println("~~button.unbind~~");

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
