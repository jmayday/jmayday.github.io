package com.pgssoft.mapper.useprocessoroptions;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
// see build.gradle for default component model setup
public interface TreeMapper {

    @Mapping(target = "leaves", ignore = true)
    @Mapping(target = "groupId", ignore = true)
    @Mapping(target = "parentId", ignore = true)
    @Mapping(target = "status", ignore = true)
    TreeDTO toTreeDTO(Tree tree);
}
