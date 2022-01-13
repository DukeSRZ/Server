package com.ax.manager.dto;

import lombok.Data;

@Data
public class AxAppDTO {

    private Integer id;

    private String appName;

    private String appUrl;

    private String imgUrl;

    private String createTime;

    private String appIntroduce;
}
