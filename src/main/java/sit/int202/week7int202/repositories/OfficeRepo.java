package sit.int202.week7int202.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.week7int202.entities.Office;

public interface OfficeRepo extends JpaRepository<Office, String> {
}
