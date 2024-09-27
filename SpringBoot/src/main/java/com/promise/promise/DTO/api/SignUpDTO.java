package com.promise.promise.DTO.api;

import com.promise.promise.domain.enumeration.NotificationValue;
import com.promise.promise.domain.enumeration.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDTO {
    private Role role;

    @NotBlank(message = "The name cannot be blank")
    private String name;
    private NotificationValue notificationValue;

    @NotNull(message = "The bottle code cannot be blank")
    @Unique
    private String bottleId;
}