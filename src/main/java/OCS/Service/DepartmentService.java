package OCS.Service;

import org.springframework.stereotype.Service;

import OCS.DTO.DepartmentDTO;
import OCS.DTO.RespondDTO.DepartmentInfo;
import OCS.Repository.DepartmentRepository;
import OCS.entity.DepartmentEntity;


@Service //@Service tells Spring to create and manage this class as a Bean, then inject it into the Controller.
public class DepartmentService {


    private final DepartmentRepository repository;


    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

//Create the Department 
    
//-----------------------------------------------------------------------------------
    
    public DepartmentInfo createDepartment(DepartmentDTO dto) {


        // DTO → Entity
        DepartmentEntity department = new DepartmentEntity();

        department.setDepartmentName (
                dto.getDepartmentName()
        );

        department.setDepartmentLocation(
                dto.getDepartmentLocation()
        );


        // Save to database
        DepartmentEntity saved =
                repository.save(department);


        // Entity → Response DTO
        DepartmentInfo response = new DepartmentInfo();

        response.setDepartmentName(
                saved.getDepartmentName()
        );

        response.setDepartmentLocation(
                saved.getDepartmentLocation()
        );


        return response;
    }
    
    
    
  //Get the Department By Id 
    
  //-----------------------------------------------------------------------------------
    public DepartmentInfo getDepartmentById(long id) {
    	 DepartmentEntity department = repository.findById(id)
    	            .orElseThrow(() -> new RuntimeException("Department not found"));

    	    DepartmentInfo response = new DepartmentInfo();

    	    response.setDepartmentId(department.getDepartmentId());
    	    response.setDepartmentName(department.getDepartmentName());
    	    response.setDepartmentLocation(department.getDepartmentLocation());

    	    return response; 
    	
    	
    }
    
    
    
  //Delete Department By Id
    
  //-----------------------------------------------------------------------------------
    public String  delDepartment(long id) {
    	DepartmentEntity department = repository.findById(id)
    			.orElseThrow(() -> new RuntimeException("Department not found"));
    	repository.deleteById(id);
    	return "Successfully Deleted";
    	
    }
    
    
    
//Update Department by Id
   
//--------------------------------------------------------------------------------------
    public String updDepartment(DepartmentDTO dto,long id) {
    	 DepartmentEntity department = repository.findById(id)
    	            .orElseThrow(() -> new RuntimeException("Department not found"));
    	department.setDepartmentLocation(dto.getDepartmentLocation());
    	department.setDepartmentName(dto.getDepartmentName());
    	
    	repository.save(department);
    	
//    	DepartmentEntity saved = repository.save(department);
    	
//    	DepartmentInfo response = new DepartmentInfo();
//
//	    response.setDepartmentId(saved.getDepartmentId());
//	    response.setDepartmentName(saved.getDepartmentName());
//	    response.setDepartmentLocation(saved.getDepartmentLocation());
    	
    	return "Upadate Successful";
    
    }
}
