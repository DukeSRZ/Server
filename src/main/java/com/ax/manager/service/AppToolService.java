package com.ax.manager.service;

import com.ax.manager.pojo.CmdbOrder;

import java.util.Map;

public interface AppToolService {
    Map uploadExcel(CmdbOrder datas) throws IllegalAccessException;
}
