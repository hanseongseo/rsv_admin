package com.xcape.rsv_admin.repository;

import com.xcape.rsv_admin.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}