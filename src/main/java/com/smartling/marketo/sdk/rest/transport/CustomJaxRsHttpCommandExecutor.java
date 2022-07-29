package com.smartling.marketo.sdk.rest.transport;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.programmembers.response.ProgramMemberDataResult;
import com.smartling.marketo.sdk.rest.Command;
import com.smartling.marketo.sdk.rest.transport.logging.JsonClientLoggingFilter;

import java.util.List;

public class CustomJaxRsHttpCommandExecutor extends JaxRsHttpCommandExecutor{
    public CustomJaxRsHttpCommandExecutor(String identityUrl, String restUrl, String clientId, String clientSecret, TokenProvider tokenProvider, JsonClientLoggingFilter loggingFilter) {
        super(identityUrl, restUrl, clientId, clientSecret, tokenProvider, loggingFilter);
    }

    @Override
    public <T> T execute(final Command<T> command) throws MarketoApiException {
        T results=  super.execute(command);
        List<ProgramMemberDataResult> result=(List<ProgramMemberDataResult>)results;
        if(!result.isEmpty() && result.get(0).getStatus().equals("skipped"))
            throw new MarketoApiException("1013","MemberShip Not Found");
        return results;
    }
}
