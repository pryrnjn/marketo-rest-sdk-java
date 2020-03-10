package com.smartling.marketo.sdk.domain.email;

import java.util.Objects;

public class EmailDynamicContentSegment
{
    private String id;
    private int segmentId;
    private String segmentName;
    private String content;
    private String type;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getSegmentId()
    {
        return segmentId;
    }

    public void setSegmentId(int segmentId)
    {
        this.segmentId = segmentId;
    }

    public String getSegmentName()
    {
        return segmentName;
    }

    public void setSegmentName(String segmentName)
    {
        this.segmentName = segmentName;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmailDynamicContentSegment that = (EmailDynamicContentSegment) o;
        return segmentId == that.segmentId &&
                Objects.equals(id, that.id) &&
                Objects.equals(segmentName, that.segmentName) &&
                Objects.equals(content, that.content) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, segmentId, segmentName, content, type);
    }
}
