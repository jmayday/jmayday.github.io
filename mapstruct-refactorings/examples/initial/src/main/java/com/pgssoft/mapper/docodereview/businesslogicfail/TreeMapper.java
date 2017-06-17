package com.pgssoft.mapper.docodereview.businesslogicfail;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.dto.TreeStatus;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TreeMapper {


    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "groupId", source = "group.id")
    @Mapping(target = "leaves", ignore = true)
    abstract TreeDTO toTreeDTO(Tree tree);

    public final TreeDTO createNewTreeDTO(Tree tree) {
        TreeDTO treeDTO = toTreeDTO(tree);
        treeDTO.withStatus(TreeStatus.NEW);
        return treeDTO;
    }
}
