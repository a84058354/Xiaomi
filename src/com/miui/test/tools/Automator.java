package com.miui.test.tools;

import android.os.RemoteException;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;

public class Automator {
    @SuppressWarnings("deprecation")
	public UiDevice mDevice = null;
    public int mDeviceDisplayWidth = 0;
    public int mDeviceDisplayHeight = 0;

    @SuppressWarnings("deprecation")
	public Automator(UiDevice device) {
        this.mDevice = device;
        this.mDeviceDisplayWidth = mDevice.getDisplayWidth();
        this.mDeviceDisplayHeight = mDevice.getDisplayHeight();
    }

    @SuppressWarnings("deprecation")
	public void WIFI(boolean on) {
        try {
            Utils.excuteCMD("am start -n com.android.settings/.MiuiSettings");
            Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
            @SuppressWarnings("deprecation")
			UiObject wlan = new UiObject(new UiSelector().text("WLAN"));
            if (!wlan.exists()) {
                mDevice.swipe(mDeviceDisplayWidth / 4,
                        mDeviceDisplayHeight / 4, mDeviceDisplayWidth / 4,
                        mDeviceDisplayHeight / 2, 6);
            }
            wlan.click();
            Utils.sleepMs(1000);
            UiObject checkboxWLAN = new UiObject(new UiSelector().className(
                    "android.widget.CheckBox").instance(1));
            if (!checkboxWLAN.exists()) {
                checkboxWLAN = new UiObject(new UiSelector().className(
                        "android.widget.CheckBox").instance(0));
            }
            if (on == true) {
                if (checkboxWLAN.isChecked() == false) {
                    checkboxWLAN.click();
                    Utils.sleepMs(Utils.WAIT_MS);
                }
            } else {
                if (checkboxWLAN.isChecked() == true) {
                    checkboxWLAN.click();
                    Utils.sleepMs(Utils.WAIT_MS);
                }
            }

            mDevice.pressBack();
            mDevice.pressBack();

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
	public void swipe(int startX, int startY, int endX, int endY) {
        mDevice.swipe(startX, startY, endX, endY, Utils.SWIPE_STEPS);
    }

    @SuppressWarnings("deprecation")
	public void home(int times) {
        for (int i = 0; i < times; i++) {
            mDevice.pressHome();
            
        }
    }

    @SuppressWarnings("deprecation")
	public void back(int times) {
        for (int i = 0; i < times; i++) {
            mDevice.pressBack();
        }
    }

    @SuppressWarnings("deprecation")
	public void home() {
        mDevice.pressHome();
    }

    @SuppressWarnings("deprecation")
	public void back() {
        mDevice.pressBack();
    }

    @SuppressWarnings("deprecation")
	public void click(int x, int y) {
        mDevice.click(x, y);
    }

    @SuppressWarnings("deprecation")
	public boolean launchCamera() {
        home(2);
        Utils.excuteCMD("am start -n  com.android.camera/.Camera");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        if (mDevice.getCurrentPackageName().contains("camera")) {
            return true;
        }

        return false;
    }
    @SuppressWarnings("deprecation")
	public boolean fileexplorer() {
        home(2);
        Utils.excuteCMD("am start -n com.android.fileexplorer/.FileExplorerTabActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        if (mDevice.getCurrentPackageName().contains("fileexplorer")) {
            return true;
        }

        return false;
    }
    
    
   
    @SuppressWarnings("deprecation")
	public void Camera2() {
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        // mDevice.click(710, 2316);
        mDevice.click(533, 1746);
    }

    @SuppressWarnings("deprecation")
	public boolean gallery() {
        Utils.excuteCMD("am start -n com.android.gallery3d/.app.GalleryActivity");
        if (mDevice.getCurrentPackageName().contains("gallery")) {
            return true;
        }
        return false;
    }

    public void launchWeChat() {
        home(2);
        Utils.excuteCMD("am start -n com.tencent.mm/.ui.LauncherUI");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
    }

    public void launchEmail() {
        home(2);
        Utils.excuteCMD("am start -n com.android.email/.activity.Welcome");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
    }

    public void launchGame() {
        home(2);
        Utils.excuteCMD("am start -n com.outfit7.mytalkingtomfree/com.outfit7.mytalkingtom.MyTalkingTomNativeActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
    }

    @SuppressWarnings("deprecation")
	public boolean launchMusic() {
        home(2);
        Utils.excuteCMD("am start -n  com.miui.player/.ui.MusicBrowserActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
        if (mDevice.getCurrentPackageName().contains("player")) {
            return true;
        } else {
            Utils.excuteCMD("am start -n com.miui.player/.phone.ui.MusicMainActivity");
            Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
            if (mDevice.getCurrentPackageName().contains("player")) {
                return true;
            }
        }

        return false;
    }

    public void Music() {
        Utils.excuteCMD("am start -n com.android.music/.MusicBrowserActivity");
    }

    @SuppressWarnings("deprecation")
	public boolean launchWeibo() {
        home(2);
        Utils.excuteCMD("am start -n com.sina.weibo/.MainTabActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
        if (mDevice.getCurrentPackageName().contains("weibo")) {
            return true;
        } else {
            Utils.excuteCMD("am start -n com.sina.weibo/.MainTabActivity");
            Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
            if (mDevice.getCurrentPackageName().contains("weibo")) {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("deprecation")
	public boolean launchVideo() {
        home(2);
        Utils.excuteCMD("am start -n com.miui.video/.HomeActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
        if (mDevice.getCurrentPackageName().contains("video")) {
            return true;
        } else {
            Utils.excuteCMD("am start -n com.miui.video/.HomeActivity");
            Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
            if (mDevice.getCurrentPackageName().contains("video")) {
                return true;
            }
        }

        return false;
    }

    public void launchDownload() {
        home(2);
        Utils.excuteCMD("am start -n com.android.providers.downloads.ui/.DownloadList");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
    }

    public void getPowerConsumeRank(String img) {
        home(2);
        Utils.excuteCMD("am start -n com.miui.securitycenter/com.miui.powercenter.PowerConsumeRank");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
        swipe(10, this.mDeviceDisplayHeight / 2, mDeviceDisplayWidth,
                this.mDeviceDisplayHeight / 2);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        Utils.excuteCMD("screencap -p /sdcard/" + img + "_1.png");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        swipe(this.mDeviceDisplayWidth / 2, this.mDeviceDisplayHeight - 100,
                this.mDeviceDisplayWidth / 2, 0);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        Utils.excuteCMD("screencap -p /sdcard/" + img + "_2.png");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        swipe(this.mDeviceDisplayWidth - 10, this.mDeviceDisplayHeight / 2, 0,
                this.mDeviceDisplayHeight / 2);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        Utils.excuteCMD("screencap -p /sdcard/" + img + "_3.png");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        back(3);
    }

    @SuppressWarnings("deprecation")
	public boolean isSleep() {
        try {
            return mDevice.isScreenOn();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return false;
    }

    @SuppressWarnings("deprecation")
	public void wakeUp() {
        try {
            mDevice.wakeUp();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
	public String getCurrentPackageName() {
        return mDevice.getCurrentPackageName();
    }

    @SuppressWarnings("deprecation")
	public void screenOn() {
        try {
            if (mDevice.isScreenOn() == false) {
                mDevice.wakeUp();
            }
        } catch (RemoteException e) {
            Utils.log(e.toString());
        }
    }

    @SuppressWarnings("deprecation")
	public void refresh() {
        mDevice.openNotification();
        Utils.sleepMs(2000);
        mDevice.swipe(300, mDeviceDisplayHeight - 100, 300, 0, 5);
    }

    @SuppressWarnings("deprecation")
	public void killall() throws UiObjectNotFoundException, RemoteException {
        mDevice.pressHome();
        mDevice.pressHome();
        mDevice.pressMenu();
        new UiObject( new UiSelector().resourceId("com.android.systemui:id/clearButton")) .click();
        //H3ZåŽŸç”Ÿ
        /*
        mDevice.pressRecentApps();
        Utils.sleepMs(2000);
        UiObject clickall=new UiObject(new UiSelector().resourceId("com.android.systemui:id/dismiss_task"));
        if(clickall.exists()){
        new UiObject(new UiSelector().resourceId("com.android.systemui:id/dismiss_task")).click();
        }else{
            mDevice.pressBack();
        }
        // X7åŽŸç”Ÿ
        /*
         * mDevice.pressRecentApps(); Utils.sleepMs(2000); mDevice.drag(778,
         * 1731, 625, 1731, 5); Utils.sleepMs(2000); new UiObject(new
         * UiSelector().text("ä»Žåˆ—è¡¨ä¸­åˆ é™¤")).click(); Utils.sleepMs(2000);
         */
        // X5åŽŸç”Ÿ

    }

    public void openguanliqi() {
        home(2);
        Utils.excuteCMD("am start -n com.android.fileexplorer/.FileExplorerTabActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS * 2);
    }

    public void slidingscreen() {
        home(2);
        Utils.excuteCMD("am start -n com.miui.home/com.miui.home.launcher.Lanuncher");
    }

    @SuppressWarnings("deprecation")
	public void swipe2() {
        mDevice.swipe(mDevice.getDisplayWidth() - 10,
                (int) (mDevice.getDisplayHeight() / 2), 0,
                (int) (mDevice.getDisplayHeight() / 2), 6);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        mDevice.swipe(10, (int) (mDevice.getDisplayHeight() / 2),
                mDevice.getDisplayWidth(),
                (int) (mDevice.getDisplayHeight() / 2), 6);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
    }

    public void ebook() {
        home(2);
        Utils.excuteCMD("am start -n com.duokan.reader/.DkMainActivity");
        Utils.sleepMs(2000);
    }

    @SuppressWarnings("deprecation")
	public void lookbroswer() {
        mDevice.swipe((int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 2,
                (int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 4, 6);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        mDevice.swipe((int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 2,
                (int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 4, 6);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        mDevice.swipe((int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 4,
                (int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 2, 6);
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
        mDevice.swipe((int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 4,
                (int) (mDevice.getDisplayWidth() / 2),
                mDevice.getDisplayHeight() / 2, 6);
    }

    public void Browser() {
        home(2);
        // Utils.excuteCMD("am start -n com.android.browser/.BrowserActivity");
        Utils.excuteCMD("am start -n com.android.browser/com.android.browser.BrowserActivity");
        Utils.sleepMs(Utils.LAUNCH_WAIT_MS);
    }

    @SuppressWarnings("deprecation")
	public void SwichScreen() {
        mDevice.swipe(10, (int) (mDevice.getDisplayHeight() / 2),
                mDevice.getDisplayWidth(),
                (int) (mDevice.getDisplayHeight() / 2), 6);
    }

    @SuppressWarnings("deprecation")
	public void FreshView() {
        mDevice.openNotification();
        Utils.sleepMs(1000);
        mDevice.pressBack();
    }

    @SuppressWarnings("deprecation")
	public void ClickButton() throws UiObjectNotFoundException {
        new UiObject(
                new UiSelector().resourceId("com.android.browser:id/close"))
                .click();
    }
    public void getBatteryHistoyDatail(){
        Utils.sleepMs(2000);
        Utils.excuteCMD("screencap -p /sdcard/batterydatail_.png");
    }
    @SuppressWarnings("deprecation")
	public void OpenFlightmode() throws UiObjectNotFoundException{
        Utils.excuteCMD("am start -n com.android.settings/.MiuiSettings");
        Utils.sleepMs(1000);
        new UiObject(new UiSelector().text("å…¶ä»–è¿žæŽ¥æ–¹å¼�")).click();
        new UiObject(new UiSelector().resourceId("android:id/checkbox")).click();
        mDevice.pressBack();
        new UiObject(new UiSelector().text("WLAN")).click();
        new UiObject(new UiSelector().resourceId("android:id/checkbox")).click();
        Utils.sleepMs(2000);
    }

	@SuppressWarnings("deprecation")
	public void launchMessage() throws UiObjectNotFoundException{
		Utils.excuteCMD("am start -n com.android.messages/.Messages");
		Utils.sleepMs(1000);
		
		
	}
}
