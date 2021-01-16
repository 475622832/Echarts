package service.Impl;

import bean.Echart;
import dao.Dao;
import dao.impl.DaoImpl;
import service.Service;

import java.util.List;

public class ServiceImpl implements Service {
    Dao dao = new DaoImpl();

    @Override
    public List<Echart> getAll() {
        return dao.getAll();
    }
}
