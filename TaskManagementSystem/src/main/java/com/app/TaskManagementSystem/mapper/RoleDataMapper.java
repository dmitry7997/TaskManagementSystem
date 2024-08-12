package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.RoleDataDto;
import com.app.TaskManagementSystem.entity.RoleData;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleDataMapper {
    RoleDataDto toRoleDataDto(RoleData roleData);

    RoleData toRoleData(RoleDataDto roleDataDto);
}
