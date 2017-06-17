package com.pgssoft.mapper.useprocessoroptions;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;

@Mapper
// see build.gradle for default component model setup
public interface TreeMapper {

    TreeDTO toTreeDTO(Tree tree);
}
