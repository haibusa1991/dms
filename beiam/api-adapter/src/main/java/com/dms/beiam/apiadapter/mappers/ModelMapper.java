package com.dms.beiam.apiadapter.mappers;

import com.dms.beiam.apiadapter.model.BeiamError;
import com.dms.beiam.restapi.models.RestApiError;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    @Mapping(target = "message", source = "message", qualifiedByName = "toListConversion")
    RestApiError toRestApiError(BeiamError beiamError);

    @Named("toListConversion")
    default List<String> toListConversion(String message) {
        return List.of(message);
    }
}
