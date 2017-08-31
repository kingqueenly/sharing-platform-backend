package com.sharingplatform.datagovernance.query;

import com.sharingplatform.framework.domain.QueryParameter;

/**
 * Created by AMC on 2017/8/18.
 */
public class FlowInstanceQueryParameter extends QueryParameter {

    private String applicant;

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

}
