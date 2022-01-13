package com.ax.manager.service.impl;

import com.ax.manager.pojo.CmdbOrder;
import com.ax.manager.service.AppToolService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppToolServiceImpl implements AppToolService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 调用蓝鲸 CMDB 流程管理平台创建单据API
     *
     * @param datas
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public Map uploadExcel(CmdbOrder datas) throws IllegalAccessException {
        List<HashMap<String, Object>> orderList = new ArrayList<HashMap<String, Object>>();
        Field[] fieldes = datas.getClass().getDeclaredFields();//通过反射获取到该对象
        for (Field field : fieldes) {
            field.setAccessible(true);//当要读取的属性为私有时，要设置为true
            String key = field.getName();//获取对象的属性名
            Object value = field.get(datas);//获取对象的属性值
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("value", value);
            map.put("key", key);
            orderList.add(map);
        }
        // 安全密钥
        String bk_app_secret = "6df4a888-4377-403b-a7e7-8ea2b5351533";
        // 应用 ID
        String bk_app_code = "bk_itsm";
        // 单据创建人
        String bk_username = datas.getIT_USERNAME();
        // 服务id
        String service_id = "4";
        // 单据创建人
        String creator = datas.getIT_USERNAME();
        // 批量解析完成的Excel数据,集合转json数组处理
        JSONArray fields = JSONArray.fromObject(orderList);
        String json = "{bk_app_secret:\"" + bk_app_secret + "\",bk_app_code:\"" + bk_app_code + "\",bk_username:\"" + bk_username + "\",service_id:" + service_id + ",creator:\"" + creator + "\",fields:" + fields + "}";
        // 将拼接好的字符串转成json对象
        JSONObject data = JSONObject.fromObject(json);
        System.out.println(data);

        // 调用蓝鲸创建单据接口
        String result = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("/api/c/compapi/v2/itsm/create_ticket/");
            if (data != null) {
                StringEntity se = new StringEntity(data.toString(), "utf-8");
                httpPost.setEntity(se); // post方法中，加入json数据
                httpPost.setHeader("Content-Type", "application/json");
            }

            HttpResponse response = httpclient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                }
            }

        } catch (Exception msg) {
            logger.error("调用 CMDB 接口异常", msg);
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("调用接口返回信息", result);
        return resultMap;
    }
}
