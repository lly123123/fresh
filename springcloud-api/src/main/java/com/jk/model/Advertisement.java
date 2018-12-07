package com.jk.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 6489224310575076774L;

    private Integer aid;
    /*广告名称*/
    private String adName;
    /*广告链接*/
    private String adUrl;
    /*广告位ID*/
    private Integer adPlaceId;
    /*有效时间*/
    private String adTime;
    /*点击数*/
    private Integer adClicks;
    /*广告图片*/
    private String adImage;

}
