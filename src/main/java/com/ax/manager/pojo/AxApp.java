package com.ax.manager.pojo;

import javax.persistence.*;

/**
 * 系统应用
 */
@Table(name = "ax_app")
public class AxApp {

    /**
     * 主键 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 应用名称
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 应用地址
     */
    @Column(name = "app_url")
    private String appUrl;

    /**
     * 应用图标地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 应用介绍
     */
    @Column(name = "app_introduce")
    private String appIntroduce;

    /**
     * 应用创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAppIntroduce() {
        return appIntroduce;
    }

    public void setAppIntroduce(String appIntroduce) {
        this.appIntroduce = appIntroduce;
    }
}
