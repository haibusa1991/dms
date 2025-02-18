package com.dms.beiam.apiadapter.mappers;

import com.dms.beiam.apiadapter.model.BeiamError;
import com.dms.beiam.restapi.models.RestApiError;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    RestApiError toRestApiError(BeiamError beiamError);
}
