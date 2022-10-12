package com.api.parkingcontrol.dto;

import com.api.parkingcontrol.controller.ParkingSpotController;
import com.api.parkingcontrol.model.ParkingSpotModel;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class ParkingSpotAssembler implements RepresentationModelAssembler<ParkingSpotModel,ParkingSpotDto> {
    @Override
    public ParkingSpotDto toModel(ParkingSpotModel entityModel) {
        ParkingSpotDto spotDto = new ParkingSpotDto();
        BeanUtils.copyProperties(entityModel, spotDto);
        spotDto.add(linkTo(methodOn(ParkingSpotController.class).getOneParkingSpot(entityModel.getId())).withRel("Spot-by-id"));
        return spotDto;
    }
}
