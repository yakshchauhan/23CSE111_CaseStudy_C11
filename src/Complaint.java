package oopsproject;

public class Complaint {

    private int ticketId;
    private String issue;
    private String status;

    public Complaint() {
        this.status = "Pending";
    }

    public Complaint(int ticketId, String issue) {
        this.ticketId = ticketId;
        this.issue = issue;
        this.status = "Pending";
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getIssue() {
        return issue;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return "Ticket : " + ticketId + " | Issue : " + issue + " | Status : " + status;
    }
}
