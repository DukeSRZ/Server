package com.ax.manager.service;

import com.ax.manager.dto.ProbeDTO;
import com.ax.manager.response.PageDataResult;


public interface ProbeService {
    PageDataResult getProbeList(ProbeDTO probeDTO, Integer pageNum, Integer pageSize);
}
