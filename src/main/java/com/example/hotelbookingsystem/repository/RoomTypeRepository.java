package com.example.hotelbookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotelbookingsystem.entity.Room;
import com.example.hotelbookingsystem.entity.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

	@Query("SELECT rt FROM RoomType rt WHERE rt.name = ?1")
    public RoomType findRoomTypeByname(String name);

}
