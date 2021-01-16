package dao;

import bean.Echart;
import com.mysql.cj.xdevapi.JsonArray;

import java.util.List;

public interface Dao {
    public List<Echart> getAll();
}
