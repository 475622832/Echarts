package utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JsonUtil {
    public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();//获取列数据

        JSONArray jsonArray = new JSONArray();//存放返回的jsonOjbect数组
        while (rs.next()) {
            JSONObject jsonObject = new JSONObject();//将每一个结果集放入到jsonObject对象中
            for (int i = 1; i <= md.getColumnCount(); i++) {
                jsonObject.put(md.getColumnName(i), rs.getObject(i));//列值一一对应
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
