package com.pgssoft.mapper.docodereview.springwayfail;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {TreeLeavesMapper.class})
public interface TreeMapperRevisited {

    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "groupId", source = "group.id")
    TreeDTO toTriggerDTO(Tree tree);
}
