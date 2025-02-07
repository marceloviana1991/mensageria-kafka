package marceloviana1991;

public class Email {
    private final String emailId, email, body;

    public Email(String emailId, String email, String body) {
        this.emailId = emailId;
        this.email = email;
        this.body = body;
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

    @Override
    public String toString() {
        return "Email{" +
                "emailId='" + emailId + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
