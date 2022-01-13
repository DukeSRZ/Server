package com.ax.manager.dao;

import com.ax.manager.dto.AxAppDTO;
import com.ax.manager.dto.ProbeDTO;
import com.ax.manager.pojo.Probe;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface ProbeMapper extends MyMapper<Probe> {

    List<AxAppDTO> getProbeList(ProbeDTO probeDTO);
}
