package com.ax.manager.controller.app;

import com.ax.manager.common.utils.HandleFile;
import com.ax.manager.pojo.CmdbOrder;
import com.ax.manager.service.AppToolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("app")
public class AppToolsController {

    @Autowired
    private AppToolService appToolService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 跳转到上传工具页面
     *
     * @return
     */
    @RequestMapping("/appTools")
    public String appTools() {
        return "app/appTools";
    }

    /**
     * 接收Excel文件传入第三方接口
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadAppList", method = RequestMethod.POST)
    @ResponseBody
    public Map uploudAppList(MultipartFile file) throws Exception {
        Map returnMap = new HashMap();
        try {
            List<CmdbOrder> returnLi = HandleFile.readExcel(file);
            for (CmdbOrder datas : returnLi) {
                Map map = appToolService.uploadExcel(datas);

            }
            returnMap.put("code", 200);
            returnMap.put("msg", "SUCCESS");
            returnMap.put("infos", returnLi);
            return returnMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        returnMap.put("code", 400);
        returnMap.put("msg", "ERROR");
        returnMap.put("infos", "检查参数");
        return returnMap;
    }
}
