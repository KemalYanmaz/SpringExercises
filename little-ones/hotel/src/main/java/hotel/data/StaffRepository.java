package hotel.data;

import org.springframework.data.jpa.repository.JpaRepository;

import hotel.models.StaffMember;

public interface StaffRepository extends JpaRepository<StaffMember, String> {
}
