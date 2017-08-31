package com.sharingplatform.datagovernance.application;

import com.sharingplatform.datagovernance.domain.DataType;
import com.sharingplatform.datagovernance.domain.SystemLocation;
import com.sharingplatform.datagovernance.domain.SystemName;
import com.sharingplatform.framework.domain.ServiceCommand;

import java.util.List;

/**
 * Created by AMC on 2017/8/11.
 */
public class DataUsageApplicationCommand extends ServiceCommand {

    private List<SystemName> systemNames;
    private List<DataType> dataTypes;
    private String dataObtained;
    private Boolean canTrack;
    private String consentTerm;
    private Boolean customerConsentObtained;
    private Boolean anonymous;
    private Boolean aggregated;
    private List<SystemLocation> systemLocations;
    private String useOfData;
    //Involving personal data?
    private Boolean ipd;
    //Involving company data?
    private Boolean icd;
    //Will the requested data be anonymized or aggregated prior to receipt?
    private Boolean aaptr;
    //Will the requested data be anonymized or aggregated after receipt?
    private Boolean aaar;
    public Boolean rfyud;
    public Boolean atoc;
    public String atocDsec;
    private Long lastApplicationId;
    private String descOfInfo;
    private String howDataUse;
    //share with any other party
    private Boolean noShare;
    private Boolean yesForAffiliate;
    private String sharedAffiliate;
    private Boolean yesForCustom;
    private String sharedCustom;
    //data transmitter
    private Boolean transmitByEmail;
    private Boolean transmitByPM;
    private String pmTransmitter;
    private Boolean transmitBySW;
    private Boolean ingested;
    private Boolean transmitByOther;
    private String otherTransmitter;
    //security control
    private Boolean securityWithEncryption;
    private Boolean securityWithSecureTransport;
    private Boolean securityWithOther;
    private String otherSecurity;

    private String howLongRetained;
    private String additionalInfo;

    public List<SystemName> getSystemNames() {
        return systemNames;
    }

    public void setSystemNames(List<SystemName> systemNames) {
        this.systemNames = systemNames;
    }

    public List<DataType> getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(List<DataType> dataTypes) {
        this.dataTypes = dataTypes;
    }

    public String getDataObtained() {
        return dataObtained;
    }

    public void setDataObtained(String dataObtained) {
        this.dataObtained = dataObtained;
    }

    public Boolean getCanTrack() {
        return canTrack;
    }

    public void setCanTrack(Boolean canTrack) {
        this.canTrack = canTrack;
    }

    public String getConsentTerm() {
        return consentTerm;
    }

    public void setConsentTerm(String consentTerm) {
        this.consentTerm = consentTerm;
    }

    public Boolean getCustomerConsentObtained() {
        return customerConsentObtained;
    }

    public void setCustomerConsentObtained(Boolean customerConsentObtained) {
        this.customerConsentObtained = customerConsentObtained;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Boolean getAggregated() {
        return aggregated;
    }

    public void setAggregated(Boolean aggregated) {
        this.aggregated = aggregated;
    }

    public List<SystemLocation> getSystemLocations() {
        return systemLocations;
    }

    public void setSystemLocations(List<SystemLocation> systemLocations) {
        this.systemLocations = systemLocations;
    }

    public String getUseOfData() {
        return useOfData;
    }

    public void setUseOfData(String useOfData) {
        this.useOfData = useOfData;
    }

    public Boolean getIpd() {
        return ipd;
    }

    public void setIpd(Boolean ipd) {
        this.ipd = ipd;
    }

    public Boolean getIcd() {
        return icd;
    }

    public void setIcd(Boolean icd) {
        this.icd = icd;
    }

    public Boolean getAaptr() {
        return aaptr;
    }

    public void setAaptr(Boolean aaptr) {
        this.aaptr = aaptr;
    }

    public Boolean getAaar() {
        return aaar;
    }

    public void setAaar(Boolean aaar) {
        this.aaar = aaar;
    }

    public String getDescOfInfo() {
        return descOfInfo;
    }

    public void setDescOfInfo(String descOfInfo) {
        this.descOfInfo = descOfInfo;
    }

    public String getHowDataUse() {
        return howDataUse;
    }

    public void setHowDataUse(String howDataUse) {
        this.howDataUse = howDataUse;
    }

    public Boolean getNoShare() {
        return noShare;
    }

    public void setNoShare(Boolean noShare) {
        this.noShare = noShare;
    }

    public Boolean getYesForAffiliate() {
        return yesForAffiliate;
    }

    public void setYesForAffiliate(Boolean yesForAffiliate) {
        this.yesForAffiliate = yesForAffiliate;
    }

    public String getSharedAffiliate() {
        return sharedAffiliate;
    }

    public void setSharedAffiliate(String sharedAffiliate) {
        this.sharedAffiliate = sharedAffiliate;
    }

    public Boolean getYesForCustom() {
        return yesForCustom;
    }

    public void setYesForCustom(Boolean yesForCustom) {
        this.yesForCustom = yesForCustom;
    }

    public String getSharedCustom() {
        return sharedCustom;
    }

    public void setSharedCustom(String sharedCustom) {
        this.sharedCustom = sharedCustom;
    }

    public Boolean getTransmitByEmail() {
        return transmitByEmail;
    }

    public void setTransmitByEmail(Boolean transmitByEmail) {
        this.transmitByEmail = transmitByEmail;
    }

    public Boolean getTransmitByPM() {
        return transmitByPM;
    }

    public void setTransmitByPM(Boolean transmitByPM) {
        this.transmitByPM = transmitByPM;
    }

    public String getPmTransmitter() {
        return pmTransmitter;
    }

    public void setPmTransmitter(String pmTransmitter) {
        this.pmTransmitter = pmTransmitter;
    }

    public Boolean getTransmitBySW() {
        return transmitBySW;
    }

    public void setTransmitBySW(Boolean transmitBySW) {
        this.transmitBySW = transmitBySW;
    }

    public Boolean getIngested() {
        return ingested;
    }

    public void setIngested(Boolean ingested) {
        this.ingested = ingested;
    }

    public Boolean getTransmitByOther() {
        return transmitByOther;
    }

    public void setTransmitByOther(Boolean transmitByOther) {
        this.transmitByOther = transmitByOther;
    }

    public String getOtherTransmitter() {
        return otherTransmitter;
    }

    public void setOtherTransmitter(String otherTransmitter) {
        this.otherTransmitter = otherTransmitter;
    }

    public Boolean getSecurityWithEncryption() {
        return securityWithEncryption;
    }

    public void setSecurityWithEncryption(Boolean securityWithEncryption) {
        this.securityWithEncryption = securityWithEncryption;
    }

    public Boolean getSecurityWithSecureTransport() {
        return securityWithSecureTransport;
    }

    public void setSecurityWithSecureTransport(Boolean securityWithSecureTransport) {
        this.securityWithSecureTransport = securityWithSecureTransport;
    }

    public Boolean getSecurityWithOther() {
        return securityWithOther;
    }

    public void setSecurityWithOther(Boolean securityWithOther) {
        this.securityWithOther = securityWithOther;
    }

    public String getOtherSecurity() {
        return otherSecurity;
    }

    public void setOtherSecurity(String otherSecurity) {
        this.otherSecurity = otherSecurity;
    }

    public String getHowLongRetained() {
        return howLongRetained;
    }

    public void setHowLongRetained(String howLongRetained) {
        this.howLongRetained = howLongRetained;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Boolean getRfyud() {
        return rfyud;
    }

    public void setRfyud(Boolean rfyud) {
        this.rfyud = rfyud;
    }

    public Boolean getAtoc() {
        return atoc;
    }

    public void setAtoc(Boolean atoc) {
        this.atoc = atoc;
    }

    public String getAtocDsec() {
        return atocDsec;
    }

    public void setAtocDsec(String atocDsec) {
        this.atocDsec = atocDsec;
    }

    public Long getLastApplicationId() {
        return lastApplicationId;
    }

    public void setLastApplicationId(Long lastApplicationId) {
        this.lastApplicationId = lastApplicationId;
    }
}
