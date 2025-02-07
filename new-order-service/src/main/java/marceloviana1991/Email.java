package marceloviana1991;

public class Email {
    private final String emailId;
    private final String email;
    private final String body;
    private final String userId;

    public Email(String emailId, String email, String body, String userId) {
        this.emailId = emailId;
        this.email = email;
        this.body = body;
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId='" + emailId + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
