package com.kickball.stadium.controller.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kickball.stadium.domain.Stadium;
import com.kickball.stadium.controller.dto.request.StadiumSaveRequest;

@Mapper
public interface StadiumMapper {

	StadiumMapper INSTANCE = Mappers.getMapper(StadiumMapper.class);

	Stadium toSaveEntity(StadiumSaveRequest request);
}
