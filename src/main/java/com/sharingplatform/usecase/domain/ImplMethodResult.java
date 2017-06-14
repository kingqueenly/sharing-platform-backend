package com.sharingplatform.usecase.domain;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class ImplMethodResult {
    @Column(name = "impl_Method_Result_text" ,columnDefinition = "varchar2(4000)")
    private String text;
    private List<ImplMethodResultFile> files;

    public ImplMethodResult() {
    }

    public ImplMethodResult(String text, List<ImplMethodResultFile> files) {
        this.text = text;
        this.files = files;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ImplMethodResultFile> getFiles() {
        return files;
    }

    public void setFiles(List<ImplMethodResultFile> files) {
        this.files = files;
    }

    public void resetTo(ImplMethodResult implMethodResult) {
        clearFiles();
        setText(implMethodResult.getText());
        setFiles(implMethodResult.getFiles());
    }

    private void clearFiles() {
        if (files != null && files.size() > 0) {
            for (ImplMethodResultFile implMethodResultFile : files) {
                implMethodResultFile.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            files.clear();
        }
    }

}
