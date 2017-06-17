package com.pgssoft.mapper.docodereview.mapstructway;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TreeMapper {

    public final TreeDTO toTreeDTO(Tree tree) {
        TreeDTO dto = new TreeDTO();

        return dto
                .withName(tree.getName())
                .withGroupId(tree.getGroup().getId())
                .withParentId(tree.getParent().getId());
    }
}
