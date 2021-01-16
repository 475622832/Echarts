package dao.impl;

import bean.Echart;
import com.mysql.cj.xdevapi.JsonArray;
import dao.Dao;

import java.util.List;

public class DaoImpl extends BasicDao implements Dao {

    @Override
    public List<Echart> getAll() {
        String sql = "select * from statistics";
        Object[] obj= {};
        return getBeanList(Echart.class, sql, obj);
    }
}
