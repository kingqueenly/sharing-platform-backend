package com.sharingplatform.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class AttachmentList {
    private List<Attachment> attachments;

    public AttachmentList() {
    }

    public AttachmentList(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void resetTo(List<Attachment> attachments) {
        clearAttachments();
        setAttachments(attachments);
    }

    private void clearAttachments() {
        if (attachments != null && attachments.size() > 0) {
            for (Attachment attachment : attachments) {
                attachment.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            attachments.clear();
        }
    }
}
