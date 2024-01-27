package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void isEmployeeiseExitbyName() {
        // Arrange
        Employee employee = new Employee("Roman", "regin", "seio@gmail.com");
        employeeRepository.save(employee);

        // Act
        Boolean actualResult = employeeRepository.isEmployeeiseExitbyName("Roman");

        // Assert
        assertThat(actualResult).isTrue();
        employeeRepository.delete(employee);
    }
}
