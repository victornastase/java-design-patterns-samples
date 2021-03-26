package com.java.learn.design.patterns.structural.proxy;

import java.util.HashMap;

/**
 * Caching Proxy
 */
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    //Ref to remote service
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTube();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if(this.cachePopular.isEmpty()) {
            this.cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieve list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if(video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
