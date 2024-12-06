package com.yaman.mtenancy.repository.bat;

import com.yaman.mtenancy.entity.bat.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
