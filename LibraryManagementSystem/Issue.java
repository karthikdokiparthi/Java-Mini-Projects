package LibraryManagementSystem;

import java.time.LocalDate;

public class Issue {
    private int memberId;
    private String bookId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Issue(){

    }
    public Issue(int memberId, String bookId, LocalDate issueDate, LocalDate returnDate) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Issued Book: " + bookId + " to Member: " + memberId +
                " | Issue Date: " + issueDate +
                " | Return Date: " + returnDate;
    }
}
