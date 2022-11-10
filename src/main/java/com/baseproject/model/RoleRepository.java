package com.baseproject.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baseproject.enumeration.Roles;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(Roles roleName);

}
