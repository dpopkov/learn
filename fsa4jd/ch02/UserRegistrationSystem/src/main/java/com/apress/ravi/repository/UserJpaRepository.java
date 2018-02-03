package com.apress.ravi.repository;

import com.apress.ravi.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserDTO, Long> {
    UserDTO findByName(String name);
}
