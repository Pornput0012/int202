package sit.int202.week7int202.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sit.int202.week7int202.entities.Office;
import sit.int202.week7int202.repositories.OfficeRepo;

import java.util.List;

@Controller
@RequestMapping("/offices")
public class OfficeController {
    private final OfficeRepo repo;

    @Autowired
    public OfficeController(OfficeRepo repo) {
        this.repo = repo;
    }
    @GetMapping("/all")
    public String getAllOffices(ModelMap model) {
        List<Office> offices = repo.findAll();
        model.addAttribute("offices", offices);
        return "office_list";
    }
    @GetMapping("")
    public String getAllOfficesById(@RequestParam String OfficeCode, ModelMap model) {
        Office office = repo.findById(OfficeCode).orElse(null);
        model.addAttribute("office", office);
        return "office_detail";
    }

    @GetMapping("/json-all")
    public ResponseEntity<List<Office>> getAllOfficesJson() {
        return ResponseEntity.ok(repo.findAll());
    }
}
