package com.example.hotelbookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotelbookingsystem.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	@Query("SELECT r FROM Room r WHERE r.type.name = ?1")
    public List<Room> findAllByRoomType(String roomType);
	@Query("SELECT r FROM Room r WHERE r.unit = ?1")
    public Room findRoomByUnit(String unit);
}
