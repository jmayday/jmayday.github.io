package com.pgssoft.mapper.useprocessoroptions;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreeMapperComponentModelExplicitlySet {

    TreeDTO toTreeDTO(Tree tree);
}
