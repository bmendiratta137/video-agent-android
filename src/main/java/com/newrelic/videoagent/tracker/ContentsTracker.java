package com.newrelic.videoagent.tracker;

import com.newrelic.videoagent.NRLog;
import com.newrelic.videoagent.jni.CAL;
import com.newrelic.videoagent.jni.swig.ContentsTrackerCore;

public class ContentsTracker extends ContentsTrackerCore {

    public ContentsTracker() {
        super();

        registerGetter("trackerName", "getTrackerName");
        registerGetter("trackerVersion", "getTrackerVersion");
        registerGetter("playerVersion", "getPlayerVersion");
        registerGetter("playerName", "getPlayerName");
        registerGetter("isAd", "getIsAd");

        registerGetter("contentTitle", "getTitle");
        registerGetter("contentBitrate", "getBitrate");
        registerGetter("contentRenditionName", "getRenditionName");
        registerGetter("contentRenditionBitrate", "getRenditionBitrate");
        registerGetter("contentRenditionWidth", "getRenditionWidth");
        registerGetter("contentRenditionHeight", "getRenditionHeight");
        registerGetter("contentDuration", "getDuration");
        registerGetter("contentPlayhead", "getPlayhead");
        registerGetter("contentLanguage", "getLanguage");
        registerGetter("contentSrc", "getSrc");
        registerGetter("contentIsMuted", "getIsMuted");
        registerGetter("contentCdn", "getCdn");
        registerGetter("contentFps", "getFps");
        registerGetter("contentPlayrate", "getPlayrate");
        registerGetter("contentIsLive", "getIsLive");
        registerGetter("contentIsAutoplayed", "getIsAutoplayed");
        registerGetter("contentPreload", "getPreload");
        registerGetter("contentIsFullscreen", "getIsFullscreen");
    }

    public Object getIsAd() {
        throw new RuntimeException("getIsAd must be overwritten by subclass");
    }

    public Object getPlayerName() {
        throw new RuntimeException("getPlayerName must be overwritten by subclass");
    }

    public Object getPlayerVersion() {
        throw new RuntimeException("getPlayerVersion must be overwritten by subclass");
    }

    public Object getTrackerName() {
        throw new RuntimeException("getTrackerName must be overwritten by subclass");
    }

    public Object getTrackerVersion() {
        throw new RuntimeException("getTrackerVersion must be overwritten by subclass");
    }

    protected void registerGetter(String name, String methodName) {
        long ptr = getCPtr(this);
        try {
            CAL.registerGetter(name, this, this.getClass().getMethod(methodName), new Long(ptr));
        }
        catch (Exception e) {
            NRLog.e("Error registering a getter in ContentsTracker = " + e);
        }
    }
}