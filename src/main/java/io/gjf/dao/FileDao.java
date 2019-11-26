package io.gjf.dao;

import io.gjf.entity.FileBean;

import java.util.List;

/**
 * Creat by GuoJF on
 */
public interface FileDao {

    void insertOne();
    List<FileBean> findAll();


}
