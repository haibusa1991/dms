//package com.dms.beiam.apiadapter;
//
//import com.dms.beiam.apiadapter.mappers.AuthControllerMapper;
//import com.dms.beiam.apiadapter.mappers.ModelMapper;
//import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityInput;
//import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityResult;
//import com.dms.beiam.apiadapter.operations.v1.register.RegisterIdentity;
//import com.dms.beiam.restapi.base.adapters.AuthenticationAdapter;
//import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityInput;
//import com.dms.beiam.restapi.operations.v1.register.RegisterIdentityResult;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class RestApiAuthenticationAdapter implements AuthenticationAdapter {
//
//    private final RegisterIdentity registerIdentity;
//    private final AuthControllerMapper mapper;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public RegisterIdentityResult registerIdentity(RegisterIdentityInput input) {
//        BeiamRegisterIdentityInput coreInput = mapper.toCoreInput(input);
//        BeiamRegisterIdentityResult process = registerIdentity.process(coreInput);
//        return mapper.toRestApiResult(process);
//    }
//}
