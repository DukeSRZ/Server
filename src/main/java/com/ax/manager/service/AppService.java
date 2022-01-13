package com.ax.manager.service;

import com.ax.manager.pojo.AxApp;
import com.ax.manager.dto.AppSearchDTO;
import com.ax.manager.response.PageDataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface AppService {
    PageDataResult getAppList(AppSearchDTO appSearch, Integer pageNum, Integer pageSize);

    Map<String, Object> addApp(AxApp axApp);

    Map<String, Object> updateApp(AxApp axApp);

    Map<String, Object> del(Long id);

    List<AxApp> getApp();

}
