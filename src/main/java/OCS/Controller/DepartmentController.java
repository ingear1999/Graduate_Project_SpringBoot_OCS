package OCS.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import OCS.DTO.DepartmentDTO;
import OCS.DTO.RespondDTO.DepartmentInfo;
import OCS.Service.DepartmentService;

@RestController
public class DepartmentController {
	
	private DepartmentService service;
	public DepartmentController(DepartmentService service ) {
		this.service = service;
	}
	
	
	@PostMapping ("/department") // create and return 
	
	public DepartmentInfo createDepartment (
			@RequestBody DepartmentDTO dto) {
		
		return service.createDepartment(dto) ;
	}
	
	
	@GetMapping("/Department/{id}")
	
	public DepartmentInfo department(@PathVariable int id) {
	   
		return service.getDepartmentById(id);
	}
	
	
	@DeleteMapping("/Department/{id}")
	
	public String deleteDepartment(@PathVariable int id) {
		return service.delDepartment(id);
	}
	
	
	@PutMapping("/Department/{id}")
	
    public String upDateDepartment(
            @RequestBody DepartmentDTO dto,
            @PathVariable int id) {

        return service.updDepartment(dto, id);
    }
	// @RequestParam: Receives simple values from the URL query parameter.
	// Example: POST /department?location=Seoul&name=Cardiology
	// Good for small/simple data such as search keywords, filters, page numbers, etc.
	// Not recommended when sending a large object with multiple fields.
	
//	@PostMapping("/department")
//	public DepartmentDTO departmentLocation(@RequestParam String location, @RequestParam String name) {
//		DepartmentDTO department = new DepartmentDTO();
//		department.setDepartmentLocation(location);
//		department.setDepartmentName(name);
//		 return department ;
//	}
	

	
	

}
