package cn.xyj.ssm.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Edwin on 2016/6/1 0001.
 */
public class CommonUtil {
    public static int QUERY=0;
    public static int ADD=1;
    public static int DEL=2;
    public static int UPDATE=3;


    public static String[] opMsg={"查询","新增","删除","更新"};


    /**
     * 返回数据封装
     * @param data
     * @param resultMsg
     * @param isSuc
     * @return
     */
    public  static Map<String, Object> wrapData(Object data, String resultMsg, boolean isSuc){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("resultMsg", resultMsg);
        resultMap.put("result", isSuc?1:0);
        resultMap.put("data", data==null?new ArrayList():data);
        return resultMap;
    }

    /**
     * 返回数据封装
     * @param data
     * @param isSuc
     * @return
     */
    public  static Map<String, Object> wrapData(Object data, int type, boolean isSuc){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("resultMsg", opMsg[type]+(isSuc?"成功":"失败"));
        resultMap.put("result", isSuc?1:0);
        resultMap.put("data", data==null?new ArrayList():data);
        return resultMap;
    }

    /**
     * 返回数据封装
     * @param type
     * @param isSuc
     * @return
     */
    public  static Map<String, Object> wrapData(int type, boolean isSuc){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("resultMsg", opMsg[type]+(isSuc?"成功":"失败"));
        resultMap.put("result", isSuc?1:0);
        resultMap.put("data", new ArrayList());
        return resultMap;
    }


    /**
     * 字符串转为List<String>
     * @Author: xuyangjian
     * @Date: 2017/2/6 17:01
     */
    public static List<String> changeStringToList(String str){
        List<String> idArray = new ArrayList<>();
        if (str.indexOf(",") > -1) {//批量移除
            String[] idstr = str.split(",");
            if (idstr != null && idstr.length > 0) {
                for (int i = 0; i < idstr.length; i++) {
                    idArray.add(String.valueOf(idstr[i]));
                }
            }
        }else {
            idArray.add(String.valueOf(str));
        }
        return idArray;
    }

}
