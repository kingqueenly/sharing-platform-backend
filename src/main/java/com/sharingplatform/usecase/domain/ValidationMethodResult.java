package com.benz.usecase.domain;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class ValidationMethodResult {
    @Column(name = "validation_method_result_text" ,columnDefinition = "varchar2(4000)")
    private String text;
    private List<ValidationMethodResultFile> files;

    public ValidationMethodResult() {
    }

    public ValidationMethodResult(String text, List<ValidationMethodResultFile> files) {
        this.text = text;
        this.files = files;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ValidationMethodResultFile> getFiles() {
        return files;
    }

    public void setFiles(List<ValidationMethodResultFile> files) {
        this.files = files;
    }

    public void resetTo(ValidationMethodResult validationMethodResult) {
        clearFiles();
        setText(validationMethodResult.getText());
        setFiles(validationMethodResult.getFiles());
    }

    private void clearFiles() {
        if (files != null && files.size() > 0) {
            for (ValidationMethodResultFile validationMethodResultFile : files) {
                validationMethodResultFile.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            files.clear();
        }
    }
}
