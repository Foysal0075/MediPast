package com.codex.medipast;

public class MedicalHistory {

    String prescriptionImageData;
    String visitedDoctorName;
    String medicalDetails;
    String prescriptionDate;

    public MedicalHistory(String prescriptionImageData, String visitedDoctorName, String medicalDetails, String prescriptionDate) {
        this.prescriptionImageData = prescriptionImageData;
        this.visitedDoctorName = visitedDoctorName;
        this.medicalDetails = medicalDetails;
        this.prescriptionDate = prescriptionDate;
        }

    public String getPrescriptionImageData() {
        return prescriptionImageData;
    }

    public String getVisitedDoctorName() {
        return visitedDoctorName;
    }

    public String getMedicalDetails() {
        return medicalDetails;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }


}
