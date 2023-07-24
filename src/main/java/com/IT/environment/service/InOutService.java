package com.IT.environment.service;

import com.IT.environment.dto.in_out_door.InOutDto;
import com.IT.environment.entity.Employee;
import com.IT.environment.entity.InOut;
import com.IT.environment.exceptions.ItemNotFoundException;
import com.IT.environment.repository.EmployeeRepository;
import com.IT.environment.repository.InOutRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InOutService {

    private final InOutRepo inOutRepo;


    private final EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;


    public InOutDto InDoor(Integer id) {

        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ItemNotFoundException("bu Id topilmadi");
        }


        InOutDto inOutDto = new InOutDto();

        inOutDto.setEmployee(employeeService.entityToDto(byId.get()));
        inOutDto.setInTime(LocalDateTime.now());
        InOut inOut = new InOut();
        inOut.setInTime(inOutDto.getInTime());
        inOut.setEmployee(byId.get());
        inOutRepo.save(inOut);
        return inOutDto;
    }

    public InOutDto OutDoor(Integer id) {

        Optional<InOut> byEmployee_id = inOutRepo.findTopByEmployee_IdOrderByIdDesc(id);
        if (byEmployee_id.get().getInTime()==null){
            System.out.println("Mazgi hali kemasdan turib qande ketmoqcisan!");
            throw new ItemNotFoundException("Mazgi hali kemasdan turib qande ketmoqcisan!");
        }
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isEmpty()) {
            throw new ItemNotFoundException("bu Id topilmadi");
        }
        InOutDto inOutDto = new InOutDto();
        inOutDto.setEmployee(employeeService.entityToDto(byId.get()));
        inOutDto.setOutTime(LocalDateTime.now());
        inOutDto.setInTime(byEmployee_id.get().getInTime());
        byEmployee_id.get().setEmployee(byId.get());
        byEmployee_id.get().setOutTime(inOutDto.getOutTime());
        inOutRepo.save(byEmployee_id.get());
        return inOutDto;
    }

    public List<InOutDto> getAllObjects() {
        List<InOutDto> inOutDtos = new ArrayList<>();
        List<InOut> all = inOutRepo.findAll();
        for (int i = 0; i < all.size(); i++) {
            InOutDto inOutDto = new InOutDto();
            inOutDto.setOutTime(all.get(i).getOutTime());
            inOutDto.setEmployee(employeeService.entityToDto(all.get(i).getEmployee()));
            inOutDto.setInTime(all.get(i).getInTime());
            inOutDtos.add(inOutDto);
        }
        return inOutDtos;
    }
}
