package com.jk.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class AdvertPlace implements Serializable {

    private static final long serialVersionUID = -5010025294155234728L;

    private Integer adplaceId;
    /*广告位名称*/
    private String adplaceName;
    /*所属页面*/
    private String adpUrl;
    /*播放方式*/
    private Integer adpPlayingMode;
    /*在线广告数*/
    private String onlineCount;
    /*排期广告数*/
    private Integer schedulingCount;
    /*广告位描述*/
    private String adpDescribe;
    /*广告尺寸*/
    private String adpSize;
    /*广告高度*/
    private String adpHeight;
    /*广告宽度*/
    private String adpWidth;

}
