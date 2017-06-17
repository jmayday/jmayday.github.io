package com.pgssoft.mapper.docodereview.springwayfail;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {TreeLeavesMapper.class})
public abstract class TreeMapperRevisited {

    @Autowired
    TreeRepository treeRepository;

    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "groupId", source = "group.id")
    @Mapping(target = "status", ignore = true)
    abstract TreeDTO toTreeDTO(Tree tree);

    @Mapping(target = "leaves", ignore = true)
    @Mapping(target = "parent", source = "parentId")
    @Mapping(target = "group", ignore = true)
    @Mapping(target = "id", ignore = true)
    abstract Tree toTree(TreeDTO tree);

    public Tree toTree(Long id) {
        return treeRepository.findOne(id);
    }

}
