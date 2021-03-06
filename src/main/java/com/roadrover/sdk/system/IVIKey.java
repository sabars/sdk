package com.roadrover.sdk.system;

import com.roadrover.sdk.utils.LogNameUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按键可配置的项的定义类
 */

public class IVIKey {

    /**
     * 长按定义 </br>
     * 例：增加音量按键需要配成长按，可以 add_volume,long_press
     */
    public static class LongKeyDef {
        /** 长按 */
        public static final String LONG_KEY_PRESS = "long_press";
        /** 长按分割符 */
        public static final String LONG_KEY_SPLIT = ",";
    }

    /**
     * mode按键的特殊操作定义类</br>
     * 如果需要mode按键的特殊配置，可以参考该位置 </br>
     * 例：mode按键操作，蓝牙断开，不允许进入蓝牙音乐，可以配置为： </br>
     * [ModeControl] </br>
     * APP0=com.roadrover.music/com.roadrover.music.activity.BTMusicActivity:Bluetooth
     */
    public static class ModeKeySpecialOperation {
        /** 必须存在盘符，才能在mode键打开该app */
        public static final String MUST_HAVE_DISK = ":Disk";
        /** 必须存在U盘，才能在mode键打开该app */
        public static final String MUST_HAVE_UDISK = ":UDisk";
        /** 必须连接蓝牙，才能mode键打开该app */
        public static final String MUST_CONNECT_BLUETOOTH = ":Bluetooth";
    }

    /**
     * 打开app特殊操作定义 </br>
     * 例：如果不在收音机界面，执行打开收音机，如果在收音机界面，执行系统按键87，可配置为： </br>
     * com.roadrover.radio_v2;top:87 </br>
     * 或者不在收音机界面执行打开收音机，在收音机界面执行搜索电台，可配置为：</br>
     * com.roadrover.radio_v2;top:scan </br>
     */
    public static class AppKeyDef {
        /** 是否配置了APP在顶层时的功能 */
        public static final String TOP_KEY_PRESS = ";top:";
    }

    /**
     * power 按键动作定义 </br>
     * 例：短按关屏，暂停媒体，长按重启，可配置为： </br>
     * [Power]
     * LONG_ACTION=9                       #长按重启 9为长按重启，2 关背光，暂停媒体， 5 静音
     * SHORT_ACTION=2                      #关背光、暂停媒体
     */
    public static class PowerKeyAction {
        /** 不动作 */
        public static final int NONE                        = 0;
        /** 关背光 */
        public static final int BKL_OFF                     = 1;
        /** 关背光、暂停媒体 */
        public static final int BKL_OFF_AND_PAUSE_MEDIA     = 2;
        /** 关背光、结束当前媒体应用 */
        public static final int BKL_OFF_AND_QUIT_APP        = 3;
        /** 静音、结束应用、进入时钟界面 */
        public static final int MUTE_AND_QUIT_APP_AND_CLOCK = 4;
        /** 静音 */
        public static final int MUTE                        = 5;
        /** 复位 */
        public static final int REBOOT                      = 9;

        public static String getDesc(int action) {
            return LogNameUtil.getName(action, PowerKeyAction.class);
        }
    }

    /**
     * 按键消息，按键可以配置的动作 {@link Key.Name} </br>
     * 例：251按键，动作为音量+，则可配置为</br>
     * [RemoteControl] </br>
     * 251=add_volume </br>
     */
    public static class Key {
        public static class Id {
            public static final int NONE        = 0;
            /** 音量+ */
            public static final int VOLUME_UP   = 1;
            /** 音量- */
            public static final int VOLUME_DOWN = 2;
            /** mode键切换 */
            public static final int MODE        = 6;
            /** 接听 */
            public static final int ANSWER      = 7;
            /** home键 */
            public static final int HOME        = 8;
            public static final int ODD         = 9;
            /** 收音机 */
            public static final int RADIO       = 10;
            /** 播放暂停 */
            public static final int PLAY_PAUSE  = 11;
            /** 音乐 */
            public static final int MP3         = 13;
            /** 导航 */
            public static final int NAVI        = 14;
            /** dvd */
            public static final int DVD         = 15;
            /** @hide 移除U盘，暂不使用 */
            public static final int EJECT       = 16;
            /** 倒车 */
            public static final int CCD         = 17;
            /** 视频 */
            public static final int MP4         = 18;
            /** TV电视 */
            public static final int TV          = 19;
            /** OSD */
            public static final int OSD         = 20;
            /** (backlight on/off) */
            public static final int DISP        = 22;
            /** ipod */
            public static final int IPOD        = 23;
            /** 摄像头 */
            public static final int CAMERA      = 24;
            /** 确认 */
            public static final int OK          = 25;
            /** aux */
            public static final int AUX         = 28;
            /** 空调 */
            public static final int CLIMATE     = 29;
            /** 收音机FM */
            public static final int FM          = 30;
            /** 收音机AM */
            public static final int AM          = 31;
            /** 下一曲 */
            public static final int NEXT        = 32;
            /** 上一曲 */
            public static final int PREV        = 33;
            /** 挂断 */
            public static final int HANG_UP     = 34;
            /** 上搜索，收音机有效 */
            public static final int SCAN_UP     = 42;
            /** 下搜索，收音机有效 */
            public static final int SCAN_DOWN   = 43;
            /** 搜索全部，收音机有效 */
            public static final int ALL_SCAN    = 47;
            /** 上调一个频率，收音机有效 */
            public static final int SPIN_UP     = 48;
            /** 下调一个频率，收音机有效 */
            public static final int SPIN_DOWN   = 49;
            /** 关闭媒体 */
            public static final int CLOSE_MEDIA = 50;

            /** 上 */
            public static final int UP    = 58;
            /** 下 */
            public static final int DOWN  = 59;
            /** 左 */
            public static final int LEFT  = 60;
            /** 右 */
            public static final int RIGHT = 61;

            /** TUNE旋钮转动，顺时针 */
            public static final int ROTATE_CW  = 62;
            /** TUNE旋钮转动，逆时针 */
            public static final int ROTATE_CCW = 63;

            /** FF */
            public static final int FF = 64;
            /** FB */
            public static final int FB = 65;

            /** 返回 */
            public static final int BACK           = 66;
            /** 选择第几首歌 */
            public static final int SELECT         = 67;
            /** 歌曲循环 */
            public static final int MEDIA_REPEAT   = 70;
            /** 歌曲洗歌 */
            public static final int MEDIA_SHUFFLE  = 71;
            /** 原车设置 */
            public static final int CAR_SET        = 81;
            /** 燃油信息 */
            public static final int FUEL_INFO      = 83;
            /** 时钟 */
            public static final int STANDBY_CLOCK  = 84;
            /** 关背光 */
            public static final int STANDBY_BK_OFF = 85;
            /** pwoer 键 */
            public static final int STANDBY        = 86;
            /** 暂停 */
            public static final int PAUSE          = 87;
            /** 设置 */
            public static final int SET            = 88;

            public static final int BT = 89;
            public static final int KEY_0 = 90;
            public static final int KEY_1 = 91;
            public static final int KEY_2 = 92;
            public static final int KEY_3 = 93;
            public static final int KEY_4 = 94;
            public static final int KEY_5 = 95;
            public static final int KEY_6 = 96;
            public static final int KEY_7 = 97;
            public static final int KEY_8 = 98;
            public static final int KEY_9 = 99;
            public static final int MUTE  = 105;
            public static final int VOICE = 106;
            /** 多功能键 */
            public static final int MULTI_FUNC   = 159;
            /** 收音机按键 */
            public static final int TUNEIN_RADIO = 160;
            /** mode 按键 */
            public static final int DRIVE_MODE   = 161;
            /** app 列表 */
            public static final int APP_LIST     = 162;
            /** power按键 */
            public static final int POWER        = 72;
            /** FM/AM切换 */
            public static final int AM_FM        = 171;
            /** all app 按键 */
            public static final int ALL_APP      = 172;
            /** 启动应用 */
            public static final int START_APP    = 173;
            /** 菜单，目前安卓菜单键建议使用 all_app，因为很多应用已经取消菜单键功能 */
            public static final int MENU         = 176;

            // 后排调节 start
            /** 后排：上 */
            public static final int REAR_UP          = 178;
            /** 后排：下 */
            public static final int REAR_DOWN        = 179;
            /** 后排：左 */
            public static final int REAR_LEFT        = 180;
            /** 后排：右 */
            public static final int REAR_RIGHT       = 181;
            /** 后排：确定 */
            public static final int REAR_OK          = 182;
            /** 后排：音量+ */
            public static final int REAR_VOLUME_UP   = 183;
            /** 后排：音量- */
            public static final int REAR_VOLUME_DOWN = 184;
            /** 后排：MENU */
            public static final int REAR_MENU        = 185;
            /** 后排：Play/Pause */
            public static final int REAR_PLAY_PAUSE  = 186;
            /** 后排：静音 */
            public static final int REAR_MUTE        = 187;
            /** 后排：快进 */
            public static final int REAR_FF          = 188;
            /** 后排：快退 */
            public static final int REAR_FB          = 189;
            /** 后排：下一曲 */
            public static final int REAR_NEXT        = 190;
            /** 后排：上一曲 */
            public static final int REAR_PREV        = 191;
            // 后排调节 end

            /** 选择调节哪个区的音量：前后排 */
            public static final int VOLUME_SEL          = 192;
            /** 双区车型的旋钮，顺时针，由应用处理 */
            public static final int DUAL_ROTATE_CW      = 193;
            /** 双区车型的旋钮，逆时针，由应用处理 */
            public static final int DUAL_ROTATE_CCW     = 194;
            /** 下旋钮短按双区静音，前后台同时MUTE,主要应用在双区媒体的按键控制上 */
            public static final int ALL_MUTE            = 195;
            /** 后排：返回 */
            public static final int REAR_BACK           = 198;
            /** PM2.5打开 */
            public static final int PM_TWO_POINT_FIVE   = 199;
            /** 后排，空调开关 */
            public static final int REAR_CLIMATE_SWITCH = 205;
            /** App 切换 */
            public static final int APP_SWITCH          = 206;
            /** 重启 */
            public static final int REBOOT              = 1000;
            /** 正常状态是上一曲，来电状态是接听 */
            public static final int PREV_ANSWER         = 1001;
            /** 正常状态是下一曲，来电或者通话状态是挂断 */
            public static final int NEXT_HANGUP         = 1002;
            /** EQ均衡器 */
            public static final int EQ                  = 1003;
            /** 启动当前播放的媒体的app，没有播放没作用 */
            public static final int LAUNCHER_APP        = 1004;
            /** 接听并挂断 */
            public static final int ANSWER_HANGUP       = 1005;
            /** waze语音 */
            public static final int WAZE_VOICE          = 1006;
            /** 系统按键 */
            public static final int ANDROID_KEY         = 1999;
            /** 来电(1s内触发一次是接听,二次是挂断)，去电挂断，没有来电，去电点击会进入蓝牙界面 */
            public static final int ANSWER_OR_HANGUP    = 1007;
        }

        /**
         * 名字下定义的按键是可配置的按键，通过ivi-config.ini进行配置功能
         */
        public static class Name {
            /** 无作用 */
            public static final String NONE             = "none";
            /** 下一曲 */
            public static final String NEXT             = "next";
            /** 上一曲 */
            public static final String PREV             = "prev";
            /** 上 */
            public static final String UP               = "up";
            /** 下 */
            public static final String DOWN             = "down";
            /** 左 */
            public static final String LEFT             = "left";
            /** 右 */
            public static final String RIGHT            = "right";
            /** 确定 */
            public static final String ENTER            = "enter";
            /** 收音机搜台 */
            public static final String SCAN             = "scan";
            /** 收音机搜台，上搜索 */
            public static final String SCAN_UP          = "scan_up";
            /** 收音机搜台，下搜索 */
            public static final String SCAN_DOWN        = "scan_down";
            /** am 和 fm 切换 */
            public static final String AM_FM            = "am_fm";
            /** am */
            public static final String AM               = "am";
            /** fm */
            public static final String FM               = "fm";
            /** 模式切换 */
            public static final String MODE             = "mode";
            /** 关屏 */
            public static final String SHUT_DOWN        = "shutdown";
            /** 增加音量 */
            public static final String ADD_VOLUME       = "add_volume";
            /** 减少音量 */
            public static final String DEL_VOLUME       = "del_volume";
            /** 主页 */
            public static final String HOME             = "home";
            /** 返回 */
            public static final String BACK             = "back";
            /** 跳到 allApp页面 */
            public static final String ALL_APP          = "all_app";
            /** 导航 */
            public static final String NAVIGATION       = "navigation";
            /** 禁音 */
            public static final String MUTE             = "mute";
            /** 接听电话 */
            public static final String ANSWER           = "answer";
            /** 挂断 */
            public static final String HANG_UP          = "hang_up";
            /** 来电接听，去电挂断，没有来电，去电点击会进入蓝牙界面 */
            public static final String BT               = "bt";
            /** 来电接听，去电挂断和bt的区别就是没有来电，去电，点击会无效果 */
            public static final String ANSWER_HANGUP    = "answer_hangup";
            /** 来电(1s内触发一次接听,二次挂断)，去电挂断，没有来电，去电点击会进入蓝牙界面 */
            public static final String ANSWER_OR_HANGUP = "answer_or_hangup";
            /** 语音 */
            public static final String VOICE            = "voice";
            /** 播放暂停 */
            public static final String PLAY_PAUSE       = "play_pause";
            /** 多功能按键 */
            public static final String MULTI_FUNC       = "multi_func";
            /** power 按键 */
            public static final String POWER            = "power";
            /** 菜单按键 */
            public static final String MENU             = "menu";
            /** 上一曲，来电状态是接听 */
            public static final String PREV_ANSWER      = "prev_answer";
            /** 下一曲，通话状态是挂断 */
            public static final String NEXT_HANGUP      = "next_hangup";
            /** 旋钮顺时针转动 */
            public static final String ROTATE_CW        = "rotate_cw";
            /** 旋钮逆时针转动 */
            public static final String ROTATE_CCW       = "rotate_ccw";
            /** 后排：上 */
            public static final String REAR_UP          = "rear_up";
            /** 后排：下 */
            public static final String REAR_DOWN        = "rear_down";
            /** 后排：左 */
            public static final String REAR_LEFT        = "rear_left";
            /** 后排：右 */
            public static final String REAR_RIGHT       = "rear_right";
            /** 后排：确定 */
            public static final String REAR_OK          = "rear_ok";
            /** 后排：音量+ */
            public static final String REAR_VOLUME_UP   = "rear_volume_up";
            /** 后排：音量- */
            public static final String REAR_VOLUME_DOWN = "rear_volume_down";
            /** 后排：MENU */
            public static final String REAR_MENU        = "rear_menu";
            /** 后排：Play/Pause */
            public static final String REAR_PLAY_PAUSE  = "rear_pause";
            /** 后排：静音 */
            public static final String REAR_MUTE        = "rear_mute";
            /** 后排：快进 */
            public static final String REAR_FF          = "rear_ff";
            /** 后排：快退 */
            public static final String REAR_FB          = "rear_fb";
            /** 后排：下一曲 */
            public static final String REAR_NEXT        = "rear_next";
            /** 后排：上一曲 */
            public static final String REAR_PREV        = "rear_prev";
            /** 选择调节哪个区的音量：前后排 */
            public static final String VOLUME_SEL       = "select_volume";
            /** 双区车型的旋钮，顺时针，由应用处理 */
            public static final String DUAL_ROTATE_CW   = "dual_rotate_cw";
            /** 双区车型的旋钮，逆时针，由应用处理 */
            public static final String DUAL_ROTATE_CCW  = "dual_rotate_ccw";
            /** 下旋钮短按双区静音，前后台同时MUTE,主要应用在双区媒体的按键控制上 */
            public static final String ALL_MUTE         = "all_mute";
            /** 后排：返回 */
            public static final String REAR_BACK        = "rear_back";
            /** EQ均衡器 */
            public static final String EQ               = "eq";
            /** 启动当前打开的媒体app */
            public static final String LAUNCHER_APP     = "launcher_app";
            /** 系统按键 */
            public static final String ANDROID_KEY      = "android_key";
            /** waze语音 */
            public static final String WAZE_VOICE       = "waze_voice";
        }

        public static class Type {
            /** 按键下压 */
            public static final int DOWN = 1;
            /** 按键抬起 */
            public static final int UP   = 0;
            /** 不分下压和抬起，只处理一次 */
            public static final int ONCE = 2;
        }

        public int mId;
        public int mType;
        public String mParams; // 有些按键需要带参数走，比如遥控器配置打开哪个应用，配置了包名，需要将包名带过去

        private static Map<String, Integer> sNameToIdMap;

        static {
            // 初始化Name的字符串到ID的映射
            sNameToIdMap = new HashMap<>();
            sNameToIdMap.put(Name.NEXT,         Id.NEXT);
            sNameToIdMap.put(Name.PREV,         Id.PREV);
            sNameToIdMap.put(Name.UP,           Id.UP);
            sNameToIdMap.put(Name.DOWN,         Id.DOWN);
            sNameToIdMap.put(Name.LEFT,         Id.LEFT);
            sNameToIdMap.put(Name.RIGHT,        Id.RIGHT);
            sNameToIdMap.put(Name.ENTER,        Id.OK);
            sNameToIdMap.put(Name.SCAN,         Id.ALL_SCAN);
            sNameToIdMap.put(Name.SCAN_UP,      Id.SCAN_UP);
            sNameToIdMap.put(Name.SCAN_DOWN,    Id.SCAN_DOWN);
            sNameToIdMap.put(Name.AM_FM,        Id.AM_FM);
            sNameToIdMap.put(Name.AM,           Id.AM);
            sNameToIdMap.put(Name.FM,           Id.FM);
            sNameToIdMap.put(Name.MODE,         Id.MODE);
            sNameToIdMap.put(Name.SHUT_DOWN,    Id.POWER);
            sNameToIdMap.put(Name.ADD_VOLUME,   Id.VOLUME_UP);
            sNameToIdMap.put(Name.DEL_VOLUME,   Id.VOLUME_DOWN);
            sNameToIdMap.put(Name.HOME,         Id.HOME);
            sNameToIdMap.put(Name.ALL_APP,      Id.ALL_APP);
            sNameToIdMap.put(Name.NAVIGATION,   Id.NAVI);
            sNameToIdMap.put(Name.BACK,         Id.BACK);
            sNameToIdMap.put(Name.MUTE,         Id.MUTE);
            sNameToIdMap.put(Name.DEL_VOLUME,   Id.VOLUME_DOWN);
            sNameToIdMap.put(Name.ANSWER,       Id.ANSWER);
            sNameToIdMap.put(Name.HANG_UP,      Id.HANG_UP);
            sNameToIdMap.put(Name.BT,           Id.BT);
            sNameToIdMap.put(Name.ANSWER_HANGUP,Id.ANSWER_HANGUP);
            sNameToIdMap.put(Name.VOICE,        Id.VOICE);
            sNameToIdMap.put(Name.PLAY_PAUSE,   Id.PLAY_PAUSE);
            sNameToIdMap.put(Name.MULTI_FUNC,   Id.MULTI_FUNC);
            sNameToIdMap.put(Name.POWER,        Id.POWER);
            sNameToIdMap.put(Name.MENU,         Id.MENU);
            sNameToIdMap.put(Name.PREV_ANSWER,  Id.PREV_ANSWER);
            sNameToIdMap.put(Name.NEXT_HANGUP,  Id.NEXT_HANGUP);
            sNameToIdMap.put(Name.ROTATE_CW,    Id.ROTATE_CW);
            sNameToIdMap.put(Name.ROTATE_CCW,   Id.ROTATE_CCW);

            sNameToIdMap.put(Name.REAR_UP,      Id.REAR_UP);
            sNameToIdMap.put(Name.REAR_DOWN,    Id.REAR_DOWN);
            sNameToIdMap.put(Name.REAR_LEFT,    Id.REAR_LEFT);
            sNameToIdMap.put(Name.REAR_RIGHT,   Id.REAR_RIGHT);
            sNameToIdMap.put(Name.REAR_OK,      Id.REAR_OK);
            sNameToIdMap.put(Name.REAR_VOLUME_UP,    Id.REAR_VOLUME_UP);
            sNameToIdMap.put(Name.REAR_VOLUME_DOWN,  Id.REAR_VOLUME_DOWN);
            sNameToIdMap.put(Name.REAR_MENU,         Id.REAR_MENU);
            sNameToIdMap.put(Name.REAR_PLAY_PAUSE,   Id.REAR_PLAY_PAUSE);
            sNameToIdMap.put(Name.REAR_MUTE,    Id.REAR_MUTE);
            sNameToIdMap.put(Name.REAR_FF,      Id.REAR_FF);
            sNameToIdMap.put(Name.REAR_FB,      Id.REAR_FB);
            sNameToIdMap.put(Name.REAR_NEXT,    Id.REAR_NEXT);
            sNameToIdMap.put(Name.REAR_PREV,    Id.REAR_PREV);
            sNameToIdMap.put(Name.VOLUME_SEL,   Id.VOLUME_SEL);
            sNameToIdMap.put(Name.DUAL_ROTATE_CW,    Id.DUAL_ROTATE_CW);
            sNameToIdMap.put(Name.DUAL_ROTATE_CCW,   Id.DUAL_ROTATE_CCW);
            sNameToIdMap.put(Name.ALL_MUTE,   Id.ALL_MUTE);
            sNameToIdMap.put(Name.REAR_BACK,    Id.REAR_BACK);
            sNameToIdMap.put(Name.EQ,         Id.EQ);
            sNameToIdMap.put(Name.ANDROID_KEY, Id.ANDROID_KEY);
            sNameToIdMap.put(Name.LAUNCHER_APP, Id.LAUNCHER_APP);
            sNameToIdMap.put(Name.WAZE_VOICE, Id.WAZE_VOICE);
            sNameToIdMap.put(Name.ANSWER_OR_HANGUP, Id.ANSWER_OR_HANGUP);
        }

        public Key(int id, int type) {
            mId = id;
            mType = type;
        }

        public Key(int id, boolean down) {
            mId = id;
            mType = down ? Type.DOWN : Type.UP;
        }

        public static String getName(int id) {
            String ret = "Key " + id;
            for (Map.Entry<String, Integer> entry : sNameToIdMap.entrySet()) {
                if (id == entry.getValue()) {
                    ret = entry.getKey();
                    break;
                }
            }
            return ret;
        }

        public static String getType(int type) {
            return LogNameUtil.getName(type, Type.class);
        }

        public static int getId(String name) {
            Integer id = sNameToIdMap.get(name);
            if (id == null) {
                return Id.NONE;
            } else {
                return id;
            }
        }

        /**
         * 获取所有按键名称
         * @return 返回按键名字列表
         */
        public static List<String> getNames() {
            List<String> ret = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : sNameToIdMap.entrySet()) {
                ret.add(entry.getKey());
            }
            return ret;
        }

        /**
         * 获取所有按键的id值
         * @return 按键表
         */
        public static List<Integer> getIds() {
            List<Integer> ret = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : sNameToIdMap.entrySet()) {
                ret.add(entry.getValue());
            }
            return ret;
        }

        public String getName() {
            return getName(mId);
        }

        public Key(int id, int type, String params) {
            this(id, type);
            mParams = params;
        }
    }

}
