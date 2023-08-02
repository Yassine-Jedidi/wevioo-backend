package com.trah.awelmara.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExistsResponse {
    private boolean userExists;
    private Long employeeId;
}