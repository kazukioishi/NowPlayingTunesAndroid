package net.kazukioishi.nowplayingtunes.AppSetting;

import android.content.Context;

import net.kazukioishi.nowplayingtunes.Twit.AccountManager.TwiAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazuki on 2014/12/14.
 */
public class SettingContainer implements Serializable{
    List<TwiAccount> accountList = new ArrayList<TwiAccount>();
    boolean enableAutoTweet = false;
    String replaceText = "Nowplaying $Title - $Artist #NowPlaying";

    //設定本体
    transient public static SettingContainer setting = new SettingContainer();

    public static void loadSettings(Context context) throws IOException, ClassNotFoundException {
        //ファイルが存在しなければ何もしない
        File file = context.getFileStreamPath("AppSaveData");
        if(file == null || !file.exists()) {
            return;
        }
        //デシリアライズする
        FileInputStream fis = context.openFileInput("AppSaveData");
        ObjectInputStream ois = new ObjectInputStream(fis);
        setting = (SettingContainer) ois.readObject();
        ois.close();
    }
    public static void saveSettings(Context context) throws IOException {
        FileOutputStream fos = context.openFileOutput("AppSaveData", Context.MODE_PRIVATE);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(setting);
        oos.close();
    }
}
