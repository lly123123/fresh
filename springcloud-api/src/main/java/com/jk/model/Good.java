package com.jk.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Good implements Serializable {

    private static final long serialVersionUID = -6748948957079217459L;

    private  Integer goodId;

    private String goodName;

    private Integer goodClassifyId;

    private String goodSketch;

    private String goodImg;

    private Integer goodSpecificationId;

    private String goodPlace;

    private String goodChuCunTiaoJian;

    private String goodUnit;

    private String goodNetContent;

    private String goodSalesVolume;

    private String goodState;

    private String goodImageDetails;


}
