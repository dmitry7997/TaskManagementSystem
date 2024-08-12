package com.app.TaskManagementSystem.mapper;

import com.app.TaskManagementSystem.dto.RoleDataDto;
import com.app.TaskManagementSystem.entity.RoleData;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T17:55:41+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class RoleDataMapperImpl implements RoleDataMapper {

    @Override
    public RoleDataDto toRoleDataDto(RoleData roleData) {
        if ( roleData == null ) {
            return null;
        }

        RoleDataDto roleDataDto = new RoleDataDto();

        roleDataDto.setId( roleData.getId() );
        roleDataDto.setRoleName( roleData.getRoleName() );

        return roleDataDto;
    }

    @Override
    public RoleData toRoleData(RoleDataDto roleDataDto) {
        if ( roleDataDto == null ) {
            return null;
        }

        RoleData roleData = new RoleData();

        roleData.setId( roleDataDto.getId() );
        roleData.setRoleName( roleDataDto.getRoleName() );

        return roleData;
    }
}
