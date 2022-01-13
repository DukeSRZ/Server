package com.ax.manager.controller.app;

import com.ax.manager.dto.AppSearchDTO;
import com.ax.manager.pojo.AxApp;
import com.ax.manager.response.PageDataResult;
import com.ax.manager.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("app")
public class AppController {

    @Autowired
    private AppService appService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 跳转到应用列表
     *
     * @return
     */
    @RequestMapping("/appRegister")
    public String appRegister() {
        return "app/appRegister";
    }

    /**
     * 门户查询应用列表
     *
     * @return
     */
    @RequestMapping(value = "/getApp", method = RequestMethod.GET)
    @ResponseBody
    public List<AxApp> getApp() {
        List data = appService.getApp();
        return data;
    }

    /**
     * 分页查询列表
     *
     * @param pageNum
     * @param pageSize
     * @param appSearch
     * @return
     */
    @RequestMapping(value = "/getAppList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getAppList(@RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     AppSearchDTO appSearch) {
        PageDataResult pdr = new PageDataResult();
        try {
            if (null == pageNum) {
                pageNum = 1;
            }
            if (null == pageSize) {
                pageSize = 10;
            }
            // 获取应用列表
            pdr = appService.getAppList(appSearch, pageNum, pageSize);
            logger.info("应用列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("应用列表查询异常！", e);
        }
        return pdr;
    }

    /**
     * 新增及修改应用
     *
     * @param axApp
     * @return
     */
    @RequestMapping(value = "/setApp", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setApp(AxApp axApp) {
        logger.info("设置应用[新增或更新]！axApp:" + axApp);
        Map<String, Object> data = new HashMap();
        if (axApp.getId() == null) {
            data = appService.addApp(axApp);
        } else {
            data = appService.updateApp(axApp);
        }
        return data;
    }

    /**
     * 图片上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> uploadImg(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            HashMap<Object, Object> map = new HashMap<Object, Object>();
            map.put(0, "图片为空");
            return map;
        } else {
            String filename = file.getOriginalFilename();
            String substring = filename.substring(filename.lastIndexOf("."));
            logger.info("上传图片名称:" + filename + "  后缀名:" + substring);
            //设置图片存储位置
            //win下使用以下路径
            //String filePath = "D:\\img\\";
            String filePath = "/manager/img/";
            String path = filePath + filename;
            File dest = new File(path);
            file.transferTo(dest);//文件写入
            String url = "/image/" + filename;
            HashMap<Object, Object> map = new HashMap<Object, Object>();
            map.put(0, url);
            return map;
        }
    }


    /**
     * 删除应用
     *
     * @param id
     * @return
     */
    @PostMapping("/del")
    @ResponseBody
    public Map<String, Object> del(@RequestParam("id") Long id) {
        logger.info("删除应用！id:" + id);
        Map<String, Object> data = new HashMap<>();
        data = appService.del(id);
        return data;
    }
}
