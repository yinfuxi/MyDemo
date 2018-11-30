package jiguang.chat.utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.api.BasicCallback;
import jiguang.chat.BuildConfig;

/**
 * @Author yinfx
 * @Date 2018/11/9
 * @Description
 */
public class JIMHelp {
    private Context mContext;
    private boolean once = true;
    private String userId;
    private String password;

    public static List<Message> forwardMsg = new ArrayList<>();

    private static final String JCHAT_CONFIGS = "JChat_configs";

    private static class Holder {
        private static final JIMHelp instance = new JIMHelp();
    }

    public static JIMHelp getInstance() {
        return Holder.instance;
    }

    public void init(Context context, String userId, String password) {
        if (once) {
            Log.i("JMessage", "init() 初始化JPush");
            JMessageClient.setDebugMode(BuildConfig.DEBUG);    // 设置是否开启日志
            JMessageClient.init(context);            // 初始化 JPush
            this.userId = userId;
            this.password = password;
            once = false;
        }
        SharePreferenceManager.init(context, JCHAT_CONFIGS);
        login();
    }

    /**
     * 登录
     */
    private void login() {

        Log.i("JMessage", "1111111");
        JMessageClient.login(userId, password, new BasicCallback() {
            @Override
            public void gotResult(int responseCode, String responseMessage) {
                Log.i("JMessage", responseMessage);
                if (responseCode == 0) {
                    UserInfo myInfo = JMessageClient.getMyInfo();
                    File avatarFile = myInfo.getAvatarFile();
                    //登陆成功,如果用户有头像就把头像存起来,没有就设置null
                    if (avatarFile != null) {
                        avatarFile.getAbsolutePath();
                    }
                    String username = myInfo.getUserName();
                    String appKey = myInfo.getAppKey();
                    //ToastUtil.getInstance(mContext).show("登陆成功");
                    Log.i("JMessage", username + "==" + appKey);
                } else {
                    //ToastUtil.getInstance(mContext).show("登陆失败");
                }
            }
        });

    }
}
