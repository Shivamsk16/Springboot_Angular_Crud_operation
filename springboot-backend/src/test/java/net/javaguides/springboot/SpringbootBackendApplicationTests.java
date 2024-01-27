package net.javaguides.springboot;

//import net.javaguides.springboot.model.Employee;



import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;

import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SpringbootBackendApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testcreate()
    {
        Employee employee=new Employee();
        employee.setId(1);
        employee.setFirstName("jai");
        employee.setLastName("shah");
        employee.setEmailId("jaishah@gmail.com");
        employeeRepository.save(employee);
        assertNotNull(employeeRepository.findById(1L).get());
    }
    @Test
    public  void testReadAll(){

        List<Employee> list=employeeRepository.findAll();
        //AbstractIterableSizeAssert<?, List<? extends Employee>, Employee, ObjectAssert<Employee>> greaterThan = /assertThat(list).size().isGreaterThan(0);
    }
    @Test
    public void testSingleEmployee(){

        Employee employee=employeeRepository.findById(1l).get();
        assertEquals("jai",employee.getFirstName());
    }

    @Test
    public void testUpdate(){

        Employee employee=employeeRepository.findById(1l).get();
        employee.setFirstName("Jai");
        employeeRepository.save(employee);
        assertNotEquals("jai",employeeRepository.findById(1l).get().getFirstName());
    }
    @Test
    public void testDelete(){

        employeeRepository.deleteById(1l);
        assertThat(employeeRepository.existsById(1l)).isFalse();

    }

}
