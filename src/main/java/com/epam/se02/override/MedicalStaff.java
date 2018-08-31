package com.epam.se02.override;

class MedicalStaff {

    public static void staticMedical(){
        System.out.println("staticMedicalStaff");
    }

    public void prescriptionMedicine(){
        System.out.println("prescriptionMedicine");
    }

    public void info() {
        System.out.println("MedicalStaff");
    }
}

class Doctor extends MedicalStaff {

    public static void staticMedical(){
        System.out.println("staticDoctor");
    }

    public void createMedicine(){
        System.out.println("createMedicine");
    }

    public void info() {
        System.out.println("Doctor");
    }
}

class Launcher {

    public static void main(String[] args) {
        MedicalStaff med = new Doctor();
        med.info();
        med.prescriptionMedicine();
        //med.createMedicine();
        med.staticMedical();

        Doctor doctor = new Doctor();
        doctor.info();
        doctor.prescriptionMedicine();
        doctor.createMedicine();
        doctor.staticMedical();

    }
}
