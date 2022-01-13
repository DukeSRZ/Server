package com.ax.manager.pojo;

public class CmdbOrder {

    //订单上传人 蓝鲸账户
    private String IT_USERNAME;

    //关联业务
    private Integer bk_biz_id;

    //服务名称
    private String title;

    //vlan
    private String IT_VLAN;

    //由负载设备提供集群服务
    private String IT_LB_CLUSTER;

    //物理IP
    private String IT_WLIP;

    //带外IP地址
    private String IT_OUTIP;

    //运维管理人员
    private String IT_OPS;

    //CPU(C)
    private Integer IT_CPUC;

    //内存(C)
    private Integer IT_MEM;

    //硬盘(G)
    private Integer IT_DISK;

    //实机或
    //虚机
    private String IT_REORVM;

    //数量
    private Integer IT_UM;

    //操作系统
    private String IT_OS;

    //内部安装组件和中间件及端口
    private String IT_PORTANDPORT;

    //对外服务端口及协议
    private String IT_PORTAG;

    //互联网IP
    //及端口
    private String IT_NETIPPORT;

    //节点间互通端口
    private String IT_PUBPORT;

    //内部其他端口
    private String IT_OTHERPOIRT;

    //详细说明
    private String IT_DOC;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIT_VLAN() {
        return IT_VLAN;
    }

    public void setIT_VLAN(String IT_VLAN) {
        this.IT_VLAN = IT_VLAN;
    }

    public String getIT_LB_CLUSTER() {
        return IT_LB_CLUSTER;
    }

    public void setIT_LB_CLUSTER(String IT_LB_CLUSTER) {
        this.IT_LB_CLUSTER = IT_LB_CLUSTER;
    }

    public String getIT_WLIP() {
        return IT_WLIP;
    }

    public void setIT_WLIP(String IT_WLIP) {
        this.IT_WLIP = IT_WLIP;
    }

    public String getIT_OUTIP() {
        return IT_OUTIP;
    }

    public void setIT_OUTIP(String IT_OUTIP) {
        this.IT_OUTIP = IT_OUTIP;
    }

    public String getIT_OPS() {
        return IT_OPS;
    }

    public void setIT_OPS(String IT_OPS) {
        this.IT_OPS = IT_OPS;
    }

    public Integer getIT_CPUC() {
        return IT_CPUC;
    }

    public void setIT_CPUC(Integer IT_CPUC) {
        this.IT_CPUC = IT_CPUC;
    }

    public Integer getIT_MEM() {
        return IT_MEM;
    }

    public void setIT_MEM(Integer IT_MEM) {
        this.IT_MEM = IT_MEM;
    }

    public Integer getIT_DISK() {
        return IT_DISK;
    }

    public void setIT_DISK(Integer IT_DISK) {
        this.IT_DISK = IT_DISK;
    }

    public String getIT_REORVM() {
        return IT_REORVM;
    }

    public void setIT_REORVM(String IT_REORVM) {
        this.IT_REORVM = IT_REORVM;
    }

    public Integer getIT_UM() {
        return IT_UM;
    }

    public void setIT_UM(Integer IT_UM) {
        this.IT_UM = IT_UM;
    }

    public String getIT_OS() {
        return IT_OS;
    }

    public void setIT_OS(String IT_OS) {
        this.IT_OS = IT_OS;
    }

    public String getIT_PORTANDPORT() {
        return IT_PORTANDPORT;
    }

    public void setIT_PORTANDPORT(String IT_PORTANDPORT) {
        this.IT_PORTANDPORT = IT_PORTANDPORT;
    }

    public String getIT_PORTAG() {
        return IT_PORTAG;
    }

    public void setIT_PORTAG(String IT_PORTAG) {
        this.IT_PORTAG = IT_PORTAG;
    }

    public String getIT_NETIPPORT() {
        return IT_NETIPPORT;
    }

    public void setIT_NETIPPORT(String IT_NETIPPORT) {
        this.IT_NETIPPORT = IT_NETIPPORT;
    }

    public String getIT_PUBPORT() {
        return IT_PUBPORT;
    }

    public void setIT_PUBPORT(String IT_PUBPORT) {
        this.IT_PUBPORT = IT_PUBPORT;
    }

    public String getIT_OTHERPOIRT() {
        return IT_OTHERPOIRT;
    }

    public void setIT_OTHERPOIRT(String IT_OTHERPOIRT) {
        this.IT_OTHERPOIRT = IT_OTHERPOIRT;
    }

    public String getIT_DOC() {
        return IT_DOC;
    }

    public void setIT_DOC(String IT_DOC) {
        this.IT_DOC = IT_DOC;
    }

    public Integer getBk_biz_id() {
        return bk_biz_id;
    }

    public void setBk_biz_id(Integer bk_biz_id) {
        this.bk_biz_id = bk_biz_id;
    }

    public String getIT_USERNAME() {
        return IT_USERNAME;
    }

    public void setIT_USERNAME(String IT_USERNAME) {
        this.IT_USERNAME = IT_USERNAME;
    }
}
