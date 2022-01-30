package com.example.hotelbookingsystem.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hotelbookingsystem.entity.Reservation;
import com.example.hotelbookingsystem.entity.User;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query("SELECT r FROM Reservation r WHERE r.user.id = ?1")
    public List<Reservation> findByUserId(Long id);
	@Query("SELECT r FROM Reservation r WHERE r.room.id = ?1")
    public List<Reservation> findByRoomId(Long id);
}
