package io.gjf.service;

import io.gjf.entity.FileBean;

import java.util.List;

/**
 * Creat by GuoJF on
 */
public interface FileService {
    void insertOne(FileBean fileBean);

    void deleteOne(FileBean fileBean);

    void deleteMany(List<FileBean> fileBeanList);

    List<FileBean> findAll();

    void update(FileBean fileBean);
}
