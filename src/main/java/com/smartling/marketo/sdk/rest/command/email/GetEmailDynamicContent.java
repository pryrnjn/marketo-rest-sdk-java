package com.smartling.marketo.sdk.rest.command.email;

import com.smartling.marketo.sdk.domain.Asset.Status;
import com.smartling.marketo.sdk.domain.email.EmailDynamicContent;
import com.smartling.marketo.sdk.rest.command.BaseGetCommand;

import java.util.Collections;
import java.util.Map;

public class GetEmailDynamicContent extends BaseGetCommand<EmailDynamicContent>
{
    private final int emailId;
    private final String contentId;
    private final Status status;

    public GetEmailDynamicContent(int emailId, String contentId, Status status)
    {
        super(EmailDynamicContent.class);

        this.emailId = emailId;
        this.contentId = contentId;
        this.status = status;
    }

    @Override
    public String getPath() {
        return "/asset/v1/email/" + emailId + "/dynamicContent/" + contentId + ".json";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("status", status);
    }
}
