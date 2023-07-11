package com.chihyangmai.backend.domain.repository;

import com.chihyangmai.backend.domain.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
