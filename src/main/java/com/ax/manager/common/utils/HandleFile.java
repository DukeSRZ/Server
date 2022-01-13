package com.ax.manager.common.utils;

import com.ax.manager.pojo.CmdbOrder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel 数据处理工具类
 */
public class HandleFile {
    public static List readExcel(MultipartFile file) throws Exception {
        List<CmdbOrder> excelDatas = new ArrayList<>();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 获取文件流
        InputStream ins = file.getInputStream();
        // 文件类
        Workbook wb = null;
        // 文件流读取
        if (suffix.equals("xlsx")) {
            wb = new XSSFWorkbook(ins);
        } else {
            wb = new HSSFWorkbook(ins);
        }
        // 读取文件流中sheet
        Sheet sheet = wb.getSheetAt(0);
        if (null != sheet) {

            // 读取sheet单元内容，line为行，从第2行开始读取，行编号从0开始
            for (int line = 2; line <= sheet.getLastRowNum(); line++) {
                CmdbOrder datas = new CmdbOrder();
                // 每行行内容
                Row row = sheet.getRow(line);

                //获取上传者 蓝鲸CMDB用户名
                //读取行中列内容，列从0开始编号,
                String userName = row.getCell(0).getStringCellValue();

                // 服务名称
                String title = row.getCell(1).getStringCellValue();

                //关联业务
                row.getCell(2).setCellType(CellType.STRING);
                String bk_biz_id = row.getCell(2).getStringCellValue();
                Integer bk_id = new Integer(bk_biz_id);

                //Vlan
                String VLAN = row.getCell(3).getStringCellValue();

                //由负载设备提供集群服务
                String IT_LB_CLUSTER = row.getCell(4).getStringCellValue();

                //物理IP
                String IT_WLIP = row.getCell(5).getStringCellValue();

                //带外IP地址
                String IT_OUTIP = row.getCell(6).getStringCellValue();

                //运维管理人员
                String IT_OPS = row.getCell(7).getStringCellValue();

                //CPU(C)
                row.getCell(8).setCellType(CellType.STRING);
                String IT_CPUC = row.getCell(8).getStringCellValue();
                Integer cpu = new Integer(IT_CPUC);

                //内存(C)
                row.getCell(9).setCellType(CellType.STRING);
                String IT_MEM = row.getCell(9).getStringCellValue();
                Integer mem = new Integer(IT_MEM);

                //硬盘(G)
                row.getCell(10).setCellType(CellType.STRING);
                String IT_DISK = row.getCell(10).getStringCellValue();
                Integer disk = new Integer(IT_DISK);

                //实机或虚机
                String IT_REORVM = row.getCell(11).getStringCellValue();

                //数量
                row.getCell(12).setCellType(CellType.STRING);
                String IT_UM = row.getCell(12).getStringCellValue();
                Integer um = new Integer(IT_UM);

                //操作系统
                String IT_OS = row.getCell(13).getStringCellValue();

                //内部安装组件和中间件及端口
                String IT_PORTANDPORT = row.getCell(14).getStringCellValue();

                //对外服务端口及协议
                String IT_PORTAG = row.getCell(15).getStringCellValue();

                //互联网IP及端口
                String IT_NETIPPORT = row.getCell(16).getStringCellValue();

                //节点间互通端口
                String IT_PUBPORT = row.getCell(17).getStringCellValue();

                //内部其他端口
                String IT_OTHERPOIRT = row.getCell(18).getStringCellValue();

                //详细说明
                String IT_DOC = row.getCell(19).getStringCellValue();

                datas.setIT_USERNAME(userName);
                datas.setTitle(title);
                datas.setBk_biz_id(bk_id);
                datas.setIT_VLAN(VLAN);
                datas.setIT_LB_CLUSTER(IT_LB_CLUSTER);
                datas.setIT_WLIP(IT_WLIP);
                datas.setIT_OUTIP(IT_OUTIP);
                datas.setIT_OPS(IT_OPS);
                datas.setIT_CPUC(cpu);
                datas.setIT_MEM(mem);
                datas.setIT_DISK(disk);
                datas.setIT_REORVM(IT_REORVM);
                datas.setIT_UM(um);
                datas.setIT_OS(IT_OS);
                datas.setIT_PORTANDPORT(IT_PORTANDPORT);
                datas.setIT_PORTAG(IT_PORTAG);
                datas.setIT_NETIPPORT(IT_NETIPPORT);
                datas.setIT_PUBPORT(IT_PUBPORT);
                datas.setIT_OTHERPOIRT(IT_OTHERPOIRT);
                datas.setIT_DOC(IT_DOC);
                excelDatas.add(datas);
            }
        }
        return excelDatas;
    }
}
