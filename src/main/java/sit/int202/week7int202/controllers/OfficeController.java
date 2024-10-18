package sit.int202.week7int202.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sit.int202.week7int202.Services.OfficeService;
import sit.int202.week7int202.entities.Office;

import java.util.List;

@Controller
@RequestMapping("/offices")
public class OfficeController {
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/all")
    public String getAllOffices(ModelMap model) {
        List<Office> offices = officeService.getAllOffices();
        model.addAttribute("offices", offices);
        return "office_list";
    }

    @GetMapping("")
    public String getAllOfficesById(@RequestParam String OfficeCode, ModelMap model) {
        Office office = officeService.getOfficeByCode(OfficeCode);
        model.addAttribute("office", office);
        return "office_detail";
    }

    @GetMapping("/delete-office")
    public String deleteOffice(@RequestParam String OfficeCode, ModelMap model) {
        Office office = officeService.deleteOffice(OfficeCode);
        model.addAttribute("office", office);
        return "office_detail";
    }

    @PostMapping("/create-office")
    public String createOffice(Office office, ModelMap model) {
        Office newOffice = officeService.createOffice(office);
        model.addAttribute("office", newOffice);
        return "office_detail";
    }
    @PostMapping("/update-office")
    public String updateOffice(Office office, ModelMap model) {
        Office updatedOffice = officeService.updateOffice(office);
        model.addAttribute("office", updatedOffice);
        return "office_detail";
    }

    @GetMapping("/office_form")
    public String officeForm() {
        return "office_form";
    }

    @GetMapping("update_form")
    public String updateForm(@RequestParam String OfficeCode, ModelMap model) {
        Office office = officeService.getOfficeByCode(OfficeCode);
        model.addAttribute("office", office);
        return "update_form";
    }

}
