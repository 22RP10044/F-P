package mission;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Mission {
    private int id;
    private String person_Name;
    private String functionOfPerson;
    private String purposeOfMission;
    private String destination;
    private String meansOfTransportation;
    private java.util.Date dateOfDeparture;
    private java.util.Date returnDate;
    private int duration;
    private String accountNumber;
    private double missionAllowance;
    private String nameOfSupervisor;

    // Getters and Setters for each field
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPersonName() {
        return person_Name;
    }
    public void setPersonName(String personName) {
        this.person_Name = person_Name;
    }
    public String getFunctionOfPerson() {
        return functionOfPerson;
    }
    public void setFunctionOfPerson(String functionOfPerson) {
        this.functionOfPerson = functionOfPerson;
    }
    public String getPurposeOfMission() {
        return purposeOfMission;
    }
    public void setPurposeOfMission(String purposeOfMission) {
        this.purposeOfMission = purposeOfMission;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getMeansOfTransportation() {
        return meansOfTransportation;
    }
    public void setMeansOfTransportation(String meansOfTransportation) {
        this.meansOfTransportation = meansOfTransportation;
    }
    public java.util.Date getDateOfDeparture() {
        return dateOfDeparture;
    }
    public void setDateOfDeparture(java.util.Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
    public java.util.Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(java.util.Date returnDate) {
        this.returnDate = returnDate;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getMissionAllowance() {
        return missionAllowance;
    }
    public void setMissionAllowance(double missionAllowance) {
        this.missionAllowance = missionAllowance;
    }
    public String getNameOfSupervisor() {
        return nameOfSupervisor;
    }
    public void setNameOfSupervisor(String nameOfSupervisor) {
        this.nameOfSupervisor = nameOfSupervisor;
    }
}
