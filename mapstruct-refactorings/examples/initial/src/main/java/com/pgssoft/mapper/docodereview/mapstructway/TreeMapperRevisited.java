package com.pgssoft.mapper.docodereview.mapstructway;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TreeMapperRevisited {


    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "groupId", source = "group.id")
    @Mapping(target = "leaves", ignore = true)
    @Mapping(target = "status", ignore = true)
    TreeDTO toTreeDTO(Tree tree);
}
