package io.gjf.dao.impl;

import io.gjf.dao.FileDao;
import io.gjf.entity.FileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Creat by GuoJF on
 */

@Repository
public class FileDaoImpl implements FileDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertOne(FileBean fileBean) {

        mongoTemplate.insert(fileBean);

    }

    @Override
    public void deleteOne(FileBean fileBean) {

    }

    @Override
    public void deleteMany(List<FileBean> fileBeanList) {


    }

    @Override
    public List<FileBean> findAll() {
        return mongoTemplate.findAll(FileBean.class);
    }

    @Override
    public void update(FileBean fileBean) {

    }
}
