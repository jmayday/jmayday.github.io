package com.pgssoft.dto;

import java.util.List;

public class TreeDTO {

    public String getNewField() {
        return newField;
    }

    public void setNewField(String newField) {
        this.newField = newField;
    }

    private String newField;

    private String name;
    private Long parentId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    private Long groupId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public TreeDTO withName(String name) {
        this.name = name;
        return this;
    }

    public TreeDTO withGroupId(Long groupId) {
        this.groupId = groupId;
        return this;
    }

    public TreeDTO withParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public TreeDTO withLeaves(List<LeafDTO> leaves) {
        this.leaves = leaves;
        return this;
    }

    public List<LeafDTO> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<LeafDTO> leaves) {
        this.leaves = leaves;
    }

    private List<LeafDTO> leaves;

}