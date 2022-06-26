package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.customobject.response.CustomObjectCreateAndUpdateResult;
import com.smartling.marketo.sdk.domain.programmembers.ProgramMemberDataFields;
import com.smartling.marketo.sdk.rest.command.customobject.RequestCreateAndUpdateCustomObject;
import com.smartling.marketo.sdk.rest.command.programmemberdata.RequestUpdateProgramMemberData;

import java.util.List;

public class MarketoCustomObjectClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoCustomObjectClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }

    public List<CustomObjectCreateAndUpdateResult> requestCreateAndUpdateUpdateCustomObject(
            RequestCreateAndUpdateCustomObject requestCreateAndUpdateCustomObject) throws MarketoApiException {
        return httpCommandExecutor.execute(requestCreateAndUpdateCustomObject);
    }


}
