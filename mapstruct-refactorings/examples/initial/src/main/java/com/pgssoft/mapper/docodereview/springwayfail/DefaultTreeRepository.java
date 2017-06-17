package com.pgssoft.mapper.docodereview.springwayfail;

import com.pgssoft.entity.Tree;

public class DefaultTreeRepository implements TreeRepository{
    @Override
    public Tree findOne(Long id) {
        return null;
    }
}
