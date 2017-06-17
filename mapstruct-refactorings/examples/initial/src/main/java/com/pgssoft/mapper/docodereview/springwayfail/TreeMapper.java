package com.pgssoft.mapper.docodereview.springwayfail;

import com.pgssoft.dto.TreeDTO;
import com.pgssoft.entity.Tree;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class TreeMapper {

    @Autowired
    private TreeLeavesMapper treeLeavesMapper;

    public final TreeDTO toTriggerDTO(Tree tree) {
        TreeDTO dto = new TreeDTO();

        return dto
                .withName(tree.getName())
                .withGroupId(tree.getGroup().getId())
                .withParentId(tree.getParent().getId())
                .withLeaves(treeLeavesMapper.toLeafDTO(tree.getLeaves()));
    }
}
