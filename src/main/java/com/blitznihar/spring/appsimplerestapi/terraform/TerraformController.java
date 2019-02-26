package com.blitznihar.spring.appsimplerestapi.terraform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TerraformController {

	@Autowired
	private TerraformService terraformService;

    @GetMapping("/terraform")
    public Terraform terraform(@RequestParam(value="stack", defaultValue="DevOps") String stack) {
    	return terraformService.getTerraform(stack);
    }
    @PostMapping("/terraform")
    public ResponseEntity<Void> addterraform(@RequestBody Terraform terraform) {
    	return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(terraformService.insertTerraform(terraform)).toUri()).build();
    }
    @PutMapping("/terraform/{id}")
    public ResponseEntity<String> updateterraform(@PathVariable String Id, @RequestBody Terraform terraform) {
    	return ResponseEntity.accepted().body(terraformService.updateTerraform(terraform));
    }
   
}
