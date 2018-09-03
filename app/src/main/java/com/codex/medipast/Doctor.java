package com.codex.medipast;

public class Doctor {

    private String doctorName;
    private String doctorDetails;
    private String appointmentDate;
    private String doctorPhone;
    private String doctorEmail;

    public Doctor(String doctorName, String doctorDetails, String appointmentDate, String doctorPhone, String doctorEmail) {
        this.doctorName = doctorName;
        this.doctorDetails = doctorDetails;
        this.appointmentDate = appointmentDate;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctordetails() {
        return doctorDetails;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "doctorName='" + doctorName + '\'' +
                ", doctorDetails='" + doctorDetails + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                '}';
    }
}
