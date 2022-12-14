package com.xcape.rsv_admin.repository;

import com.xcape.rsv_admin.domain.entity.Admin;
import com.xcape.rsv_admin.domain.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    List<Merchant> findAll();

    List<Merchant> findMerchantsByAdmin(Admin admin);

    Merchant findByName(String name);

}