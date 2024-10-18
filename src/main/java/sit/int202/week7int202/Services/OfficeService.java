package sit.int202.week7int202.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int202.week7int202.entities.Office;
import sit.int202.week7int202.repositories.OfficeRepo;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeRepo officeRepo;

    @Autowired
    public OfficeService(OfficeRepo officeRepo) {
        this.officeRepo = officeRepo;
    }

    public List<Office> getAllOffices() {
        return officeRepo.findAll();
    }

    public Office getOffice(String officeCode) {
        return officeRepo.findById(officeCode).orElse(null);
    }

    public Office createOffice(Office office) {
        Office existingOffice = getOffice(office.getOfficeCode());
        if (existingOffice != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Office with code %s already exists", office.getOfficeCode()));
        }
        return officeRepo.save(office);
    }
    public Office updateOffice(Office office) {
        Office existingOffice = getOffice(office.getOfficeCode());
        if (existingOffice == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Office with code %s does not exist", office.getOfficeCode()));
        }
        return officeRepo.save(office);

    }

    public Office deleteOffice(String officeCode) {
        Office existingOffice = getOffice(officeCode);
        if (existingOffice == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Office with code %s does not exist", officeCode));
        }
        officeRepo.delete(existingOffice);
        return existingOffice;
    }

    public Office getOfficeByCode(String officeCode) {
        return getOffice(officeCode);
    }


}
