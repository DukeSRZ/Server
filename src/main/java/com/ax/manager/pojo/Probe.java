package com.ax.manager.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 通信探测记录
 */
@Table(name = "probe_result")
public class Probe {
    /**
     * 主键 ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 状态码
     */
    @Column(name = "code")
    private Integer code;

    /**
     * 探测返回信息
     */
    @Column(name = "results_msg")
    private String results_msg;

    /**
     * 帮助
     */
    @Column(name = "help_msg")
    private String help_msg;

    /**
     * 源IP
     */
    @Column(name = "source_ip")
    private String source_ip;

    /**
     * 源端口
     */
    @Column(name = "source_port")
    private String source_port;

    /**
     * 目标IP
     */
    @Column(name = "target_ip")
    private String target_ip;

    /**
     * 目标IP
     */
    @Column(name = "target_port")
    private String target_port;

    /**
     * SessionId
     */
    @Column(name = "session_id")
    private String session_id;

    /**
     * 开始时间
     */
    @Column(name = "create_time")
    private String create_time;

    /**
     * 结束时间
     */
    @Column(name = "update_time")
    private String update_time;

    /**
     * 通信状态
     */
    @Column(name = "probe_results")
    private String probe_results;

    /**
     * 探测方式
     */
    @Column(name = "detection_mode")
    private String detection_mode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResults_msg() {
        return results_msg;
    }

    public void setResults_msg(String results_msg) {
        this.results_msg = results_msg;
    }

    public String getHelp_msg() {
        return help_msg;
    }

    public void setHelp_msg(String help_msg) {
        this.help_msg = help_msg;
    }

    public String getSource_ip() {
        return source_ip;
    }

    public void setSource_ip(String source_ip) {
        this.source_ip = source_ip;
    }

    public String getSource_port() {
        return source_port;
    }

    public void setSource_port(String source_port) {
        this.source_port = source_port;
    }

    public String getTarget_ip() {
        return target_ip;
    }

    public void setTarget_ip(String target_ip) {
        this.target_ip = target_ip;
    }

    public String getTarget_port() {
        return target_port;
    }

    public void setTarget_port(String target_port) {
        this.target_port = target_port;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getProbe_results() {
        return probe_results;
    }

    public void setProbe_results(String probe_results) {
        this.probe_results = probe_results;
    }

    public String getDetection_mode() {
        return detection_mode;
    }

    public void setDetection_mode(String detection_mode) {
        this.detection_mode = detection_mode;
    }
}