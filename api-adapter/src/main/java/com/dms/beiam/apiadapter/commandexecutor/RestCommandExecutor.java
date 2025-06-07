package com.dms.beiam.apiadapter.commandexecutor;

import com.dms.beiam.apiadapter.base.adapter.AdapterMapper;
import com.dms.beiam.apiadapter.commandexecutor.base.CommandExecutor;
import com.dms.beiam.apiadapter.commandexecutor.base.Command;
import com.dms.beiam.apiadapter.commandexecutor.base.CommandInput;
import com.dms.beiam.apiadapter.commandexecutor.base.CommandResult;
import com.dms.beiam.restapi.base.RestApiInput;
import com.dms.beiam.restapi.base.RestApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestCommandExecutor implements CommandExecutor {

    @Override
    public <API_INPUT extends RestApiInput,
            COMMAND_INPUT extends CommandInput,
            COMMAND_RESULT extends CommandResult,
            API_RESULT extends RestApiResult> API_RESULT execute(API_INPUT input,
                                                                 AdapterMapper<API_INPUT, COMMAND_INPUT, COMMAND_RESULT, API_RESULT> mapper,
                                                                 Command<COMMAND_RESULT, COMMAND_INPUT> command) {

        COMMAND_INPUT commandInput = mapper.toCommandInput(input);
        return mapper.toApiResult(command.execute(commandInput));
    }
}
