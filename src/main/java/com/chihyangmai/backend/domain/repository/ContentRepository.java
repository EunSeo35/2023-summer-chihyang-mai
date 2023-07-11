package com.chihyangmai.backend.domain.repository;

import com.chihyangmai.backend.domain.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
