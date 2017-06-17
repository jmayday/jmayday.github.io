package com.pgssoft.mapper.docodereview.businesslogicfail;

import com.pgssoft.dto.LeafDTO;
import com.pgssoft.entity.Leaf;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TreeLeavesMapper {

    List<LeafDTO> toLeafDTO(List<Leaf> leaves);
    LeafDTO toLeafDTO(Leaf leaf);
}
