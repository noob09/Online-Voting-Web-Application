/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClass;

/**
 *
 * @author praveen_sangalad
 */
public class VoteDetails {
    private int registrationNum;
    private String partyVoted;
    private int candidateId;
    private int year;
    private String electionType;

    public int getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(int registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getPartyVoted() {
        return partyVoted;
    }

    public void setPartyVoted(String partyVoted) {
        this.partyVoted = partyVoted;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getElectionType() {
        return electionType;
    }

    public void setElectionType(String electionType) {
        this.electionType = electionType;
    }
    
    
    
}
