package jison.ApparelSpringApp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApparelController {
	
	private final ApparelRepository repository;
	private final ApparelModelAssembler assembler;
	
	ApparelController(ApparelRepository repository, ApparelModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	@GetMapping("/apparel")
	CollectionModel<EntityModel<Apparel>> all() {
		List<EntityModel<Apparel>> apparels = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
		return CollectionModel.of(apparels, linkTo(methodOn(ApparelController.class).all()).withSelfRel());
	}

	@PostMapping("/apparel")
	ResponseEntity<?> newApparel(@RequestBody Apparel newApparel) {
		EntityModel<Apparel> entityModel = assembler.toModel(repository.save(newApparel));
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}
	
	@GetMapping("/apparel/{id}")
	EntityModel<Apparel> one(@PathVariable Long id) {
		Apparel apparel = repository.findById(id).orElseThrow(() -> new ApparelNotFoundException(id));
		return assembler.toModel(apparel);
	}
	
	@PutMapping("/apparel/{id}")
	ResponseEntity<?> replaceApparel(@RequestBody Apparel apparel, @PathVariable Long id) {
		return null;
	}
	
	@DeleteMapping("/apparel/{id}")
	ResponseEntity<?> delete(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
