package com.benz.usecase.domain;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class AnalysisMethodResult {
    @Column(name = "analysis_method_result_text" ,columnDefinition = "varchar2(4000)")
    private String text;
    private List<AnalysisMethodResultFile> files;

    public AnalysisMethodResult() {
    }

    public AnalysisMethodResult(String text, List<AnalysisMethodResultFile> files) {
        this.text = text;
        this.files = files;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AnalysisMethodResultFile> getFiles() {
        return files;
    }

    public void setFiles(List<AnalysisMethodResultFile> files) {
        this.files = files;
    }

    public void resetTo(AnalysisMethodResult analysisMethodResult) {
        clearFiles();
        setText(analysisMethodResult.getText());
        setFiles(analysisMethodResult.getFiles());
    }

    private void clearFiles() {
        if (files != null && files.size() > 0) {
            for (AnalysisMethodResultFile analysisMethodResultFile : files) {
                analysisMethodResultFile.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            files.clear();
        }
    }
}
