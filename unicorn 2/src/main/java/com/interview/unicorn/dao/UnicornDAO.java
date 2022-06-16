package com.interview.unicorn.dao;

import com.interview.unicorn.domain.UnicornDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnicornDAO extends JpaRepository<UnicornDetails, Integer> {
}
