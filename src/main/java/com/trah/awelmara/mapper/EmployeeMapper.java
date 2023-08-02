package com.trah.awelmara.mapper;


import com.trah.awelmara.dto.EmployeeDto;
import com.trah.awelmara.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );
    EmployeeDto employeeToEmployeeDto(Employee employee);
}
