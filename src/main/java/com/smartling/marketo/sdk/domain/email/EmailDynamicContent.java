package com.smartling.marketo.sdk.domain.email;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmailDynamicContent
{
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public int getSegmentation()
    {
        return segmentation;
    }

    public void setSegmentation(int segmentation)
    {
        this.segmentation = segmentation;
    }

    public List<EmailDynamicContentSegment> getContent()
    {
        return content;
    }

    public void setContent(List<EmailDynamicContentSegment> content)
    {
        this.content = content;
    }

    private int id;
    private Date createdAt;
    private Date updatedAt;
    private int segmentation;
    private List<EmailDynamicContentSegment> content;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmailDynamicContent that = (EmailDynamicContent) o;
        return id == that.id &&
                segmentation == that.segmentation &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, createdAt, updatedAt, segmentation, content);
    }
}
