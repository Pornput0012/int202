package sit.int202.week7int202.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.week7int202.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
