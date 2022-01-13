package com.ax.manager.service.impl;

import com.ax.manager.dao.ProbeMapper;
import com.ax.manager.dto.AxAppDTO;
import com.ax.manager.dto.ProbeDTO;
import com.ax.manager.response.PageDataResult;
import com.ax.manager.service.ProbeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProbeServiceImpl implements ProbeService {

    @Autowired
    private ProbeMapper probeMapper;

    @Override
    public PageDataResult getProbeList(ProbeDTO probeDTO, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        PageHelper.startPage(pageNum, pageSize);
        List<AxAppDTO> probeList = probeMapper.getProbeList(probeDTO);
        if (probeList.size() != 0) {
            PageInfo<ProbeDTO> pageInfo = new PageInfo(probeList);
            pageDataResult.setList(probeList);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }
        return pageDataResult;
    }
}
