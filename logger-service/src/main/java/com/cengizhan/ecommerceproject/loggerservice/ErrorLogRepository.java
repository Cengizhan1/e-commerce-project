package com.cengizhan.ecommerceproject.loggerservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<ErrorLog,Long> {
}
