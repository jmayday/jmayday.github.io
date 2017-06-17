package com.pgssoft.service;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import com.pgssoft.mapper.useprocessoroptions.TreeMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class DefaultService implements Service {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public String result() {

        Tree t = new Tree();
        t.setName("tree");


        TreeDTO treeDTO =
                treeMapper.toTreeDTO(t);


        return treeDTO.getName();


    }
}
