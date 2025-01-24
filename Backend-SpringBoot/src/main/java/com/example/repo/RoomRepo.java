package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.Room;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {

    // Custom query to find rooms by hotel_id
    @Query(value="SELECT * FROM room WHERE hotel_id = ?1", nativeQuery = true)
    List<Room> findRoomsByHotelId(@Param("hotelId") int hotelId);
}
