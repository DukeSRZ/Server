package com.ax.manager.dto;

import lombok.Data;

@Data
public class ProbeDTO {
    /**
     * 主键 ID
     */
    private Integer id;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 探测返回信息
     */
    private String results_msg;

    /**
     * 帮助
     */
    private String help_msg;

    /**
     * 源IP
     */
    private String source_ip;

    /**
     * 源端口
     */
    private String source_port;

    /**
     * 目标IP
     */
    private String target_ip;

    /**
     * 目标IP
     */
    private String target_port;

    /**
     * SessionId
     */
    private String session_id;

    /**
     * 开始时间
     */
    private String create_time;

    /**
     * 结束时间
     */
    private String update_time;

    /**
     * 通信状态
     */
    private String probe_results;

    /**
     * 探测方式
     */
    private String detection_mode;
}
