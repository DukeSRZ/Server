package com.ax.manager.dao;

import com.ax.manager.dto.AxAppDTO;
import com.ax.manager.pojo.AxApp;
import com.ax.manager.dto.AppSearchDTO;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface AxAppMapper extends MyMapper<AxApp> {
    List<AxAppDTO> getAppList(AppSearchDTO appSearch);

    int addAPP(AxApp axApp);

    int updateApp(AxApp axApp);

    int deleteAppById(Long id);

    List<AxApp> getApp();

    AxApp getAppById(Long id);
}
