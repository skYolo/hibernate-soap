package com.demo.springbootsoaphibernate.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootsoaphibernate.aop.LoggableService;
import com.demo.springbootsoaphibernate.entity.Employee;
import com.demo.springbootsoaphibernate.repository.EmployeeRepository;

import payroll.bestpay.employee.EmployeeInfo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private EmployeeTransformer convertor;

	@LoggableService
	public EmployeeInfo employeeLookup(String employeeId) {

		Employee employee = empRepo.findOne(Long.parseLong(employeeId));
		if (employee != null) {
			return convertor.convert(employee);
		}

		return null;
	}

}
