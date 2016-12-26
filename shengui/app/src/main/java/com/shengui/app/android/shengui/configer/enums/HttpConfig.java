package com.shengui.app.android.shengui.configer.enums;


/**
 * HttpConfig
 */
public enum HttpConfig {
    /**
     * 消息轮询
     */
    yapull(1),
    publish(2),
    audioContent(3),
    pushtiezi(4);  //发帖子

    int type;

    HttpConfig(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
