package com.ax.manager.controller.tool;

import com.ax.manager.dto.ProbeDTO;

import com.ax.manager.response.PageDataResult;
import com.ax.manager.service.ProbeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("tool")
public class ProbeController {

    @Autowired
    private ProbeService probeService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 通信探测列表
     *
     * @return
     */
    @RequestMapping("/probe")
    public String probeList() {
        return "tool/probe";
    }

    /**
     * 分页查询通信探测列表
     *
     * @param pageNum
     * @param pageSize
     * @param probeDTO
     * @return
     */
    @RequestMapping(value = "/getProbeList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getProbeList(@RequestParam("pageNum") Integer pageNum,
                                       @RequestParam("pageSize") Integer pageSize,
                                       ProbeDTO probeDTO) {
        PageDataResult pdr = new PageDataResult();
        try {
            if (null == pageNum) {
                pageNum = 1;
            }
            if (null == pageSize) {
                pageSize = 10;
            }
            // 获取通信探测列表
            pdr = probeService.getProbeList(probeDTO, pageNum, pageSize);
            logger.info("通信探测列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("通信探测列表查询异常！", e);
        }
        return pdr;
    }
}