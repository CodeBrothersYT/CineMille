package com.cinemille.core;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toDto(Movie movie);
    Movie toEntity(MovieDTO movieDTO);
    void patchFromDTO(MovieDTO movieDTO, @MappingTarget Movie movie);
}
