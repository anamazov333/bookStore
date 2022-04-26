package com.company.bookstore.mapper;


import com.company.bookstore.dto.SignUpDto;
import com.company.bookstore.entity.Role;
import com.company.bookstore.entity.User;
import com.company.bookstore.enumeration.RoleEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roleId", source = "roleId", qualifiedByName = "toRoleEnum")
    })
    User signUpDtoToUser(SignUpDto request);


    @Named(value = "toRoleEnum")
    default Role toRoleEnum(Integer roleId) {
        Role role = new Role();
        role.setId(roleId);
return role;

    }
}
