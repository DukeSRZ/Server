package com.ax.manager.service.impl;

import com.ax.manager.common.utils.DateUtils;
import com.ax.manager.dao.AxAppMapper;
import com.ax.manager.dto.AxAppDTO;
import com.ax.manager.pojo.AxApp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ax.manager.dto.AppSearchDTO;
import com.ax.manager.response.PageDataResult;
import com.ax.manager.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppServiceImpl implements AppService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AxAppMapper axAppMapper;

    @Override
    public PageDataResult getAppList(AppSearchDTO appSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<AxAppDTO> appList = axAppMapper.getAppList(appSearch);
        if (appList.size() != 0) {
            PageInfo<AxAppDTO> pageInfo = new PageInfo<>(appList);
            pageDataResult.setList(appList);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }
        return pageDataResult;
    }

    @Override
    public Map<String, Object> addApp(AxApp axApp) {
        Map<String, Object> data = new HashMap();
        axApp.setCreateTime(DateUtils.getCurrentDate());
        int result = axAppMapper.addAPP(axApp);
        try {
            if (result == 0) {
                data.put("code", 0);
                data.put("msg", "新增失败！");
                logger.error("应用[新增]，结果=新增失败！");
                return data;
            }
            data.put("code", 1);
            data.put("msg", "新增成功！");
            logger.info("应用[新增]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("应用[新增]异常！", e);
            return data;
        }
        return data;
    }

    @Override
    public Map<String, Object> updateApp(AxApp axApp) {
        Map<String, Object> data = new HashMap();

        int result = axAppMapper.updateApp(axApp);
        if (result == 0) {
            data.put("code", 0);
            data.put("msg", "更新失败！");
            logger.error("应用[更新]，结果=更新失败！");
            return data;
        }
        data.put("code", 1);
        data.put("msg", "更新成功！");
        logger.info("应用[更新]，结果=更新成功！");
        return data;
    }

    @Override
    public Map<String, Object> del(Long id) {
        Map<String, Object> data = new HashMap<>();
        try {
            //根据id获取本地图片名称并将本地图片删除
            AxApp appById = axAppMapper.getAppById(id);
            String imgStr = appById.getImgUrl();
            File file = new File("D:/img/" + imgStr.replace("/image/", ""));
            file.delete();
            // 删除权限菜单
            int result = axAppMapper.deleteAppById(id);
            if (result == 0) {
                data.put("code", 0);
                data.put("msg", "删除失败");
                logger.error("删除失败");
                return data;
            }
            data.put("code", 1);
            data.put("msg", "删除成功");
            logger.info("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除应用异常！", e);
        }
        return data;
    }

    @Override
    public List<AxApp> getApp() {
        return axAppMapper.getApp();
    }
}
