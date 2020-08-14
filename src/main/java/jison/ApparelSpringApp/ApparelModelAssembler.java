package jison.ApparelSpringApp;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class ApparelModelAssembler implements RepresentationModelAssembler<Apparel, EntityModel<Apparel>> {
	
	@Override
	public EntityModel<Apparel> toModel(Apparel apparel) {
		return EntityModel.of(apparel, linkTo(methodOn(ApparelController.class).one(apparel.getId())).withSelfRel(),
				linkTo(methodOn(ApparelController.class).all()).withRel("apparel"));
	}
}
