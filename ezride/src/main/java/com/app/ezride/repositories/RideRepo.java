package com.app.ezride.repositories;

import com.app.ezride.pojo.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepo extends JpaRepository<Ride, Integer> {
}
