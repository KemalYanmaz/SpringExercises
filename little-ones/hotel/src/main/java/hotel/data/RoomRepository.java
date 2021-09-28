package hotel.data;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
