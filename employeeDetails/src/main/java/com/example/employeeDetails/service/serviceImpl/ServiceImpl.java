package com.example.employeeDetails.service.serviceImpl;

import com.example.employeeDetails.entity.EmployeeDTO;
import com.example.employeeDetails.entity.EmployeeModelMongo;
import com.example.employeeDetails.exception.userNotFoundException;
import com.example.employeeDetails.repository.EmployeeRepo;
import com.example.employeeDetails.repository.EmployeeRepos;
import com.example.employeeDetails.service.EmployeeService;
import com.example.employeeDetails.util.ObjectMapperUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeRepos employeeRepos;

    @Override
    public List<EmployeeDTO> getEmployees() {
        return ObjectMapperUtils.mapAll(employeeRepo.findAll(), EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getLimitedEmployees() throws userNotFoundException {
        List<EmployeeDTO> lim = getEmployees();
        if(lim != null){
            lim = lim.stream()
                    .filter(employeeModel -> employeeModel.getEmp_no() < 10500)
                    .collect(Collectors.toList());
            return lim;
        }
        else {
            throw new userNotFoundException("Users not Found");
        }

    }

    @Override
    public List<EmployeeDTO> getByGender() {
        List<EmployeeDTO> Emp = null;
        try {
            Emp = getLimitedEmployees();
        } catch (userNotFoundException e) {
            throw new RuntimeException(e);
        }
        Emp = Emp.stream()
                .filter(employeeModel -> employeeModel.getGender().equalsIgnoreCase("M"))
                .collect(Collectors.toList());
       Collections.sort(Emp);
        return Emp;
    }

//    @Scheduled(fixedDelay = 10000)
    @Override
    public void saveData() throws userNotFoundException {
//        System.out.println("\nProcess Started");
        List<EmployeeDTO> list1 = getLimitedEmployees();
        List<EmployeeModelMongo> list2 = list1.stream().map(emp ->
                new EmployeeModelMongo(new ObjectId(String.valueOf(emp.getEmp_no())), emp.getBirth_date()
                ,emp.getFirst_name(), emp.getLast_name(), emp.getGender(),
                        emp.getHire_date())).collect(Collectors.toList());

//        employeeRepos.saveAll(list2);
        list2.stream().map(employeeModelMongo -> employeeRepos.save(employeeModelMongo)).collect(Collectors.toList());

//          System.out.println("Process ended");
    }

    @Override
    public List<EmployeeModelMongo> getData(){
        return employeeRepos.findAll();
    }

    @Override
    public void deleteAll() {
        employeeRepos.deleteAll();
    }

}
