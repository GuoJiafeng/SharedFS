package io.gjf.service.impl;

import io.gjf.dao.FileDao;
import io.gjf.entity.FileBean;
import io.gjf.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creat by GuoJF on
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public void insertOne(FileBean fileBean) {

        fileDao.insertOne(fileBean);

    }

    @Override
    public void deleteOne(FileBean fileBean) {

        fileDao.deleteOne(fileBean);

    }

    @Override
    public void deleteMany(List<FileBean> fileBeanList) {

    }

    @Override
    public List<FileBean> findAll() {
        return fileDao.findAll();
    }

    @Override
    public void update(FileBean fileBean) {

    }
}
