package hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hotel.data.StaffRepository;
import hotel.models.StaffMember;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<StaffMember> getAllStaff(){
        return staffRepository.findAll();
    }
}