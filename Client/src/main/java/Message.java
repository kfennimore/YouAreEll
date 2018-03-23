public class Message {

    private String sequence;
    private String timestamp;
    private String fromid;
    private String toid;
    private String message;

    public Message(String sequence, String timeStamp, String fromId, String toId, String message) {
        this.sequence = sequence;
        this.timestamp = timestamp;
        this.fromid = fromid;
        this.toid = toid;
        this.message = message;
    }

    public Message(String fromId, String toId, String message) {
        this.fromid = fromid;
        this.toid = toid;
        this.message = message;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timeStamp) {
        this.timestamp = timeStamp;
    }

    public String getFromId() {
        return fromid;
    }

    public void setFromId(String fromId) {
        this.fromid = fromid;
    }

    public String getToId() {
        return toid;
    }

    public void setToId(String toId) {
        this.toid = toid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {

        return "Message{" +
                "sequence: '" + sequence + '\'' +
                ", timeStamp:'" + timestamp + '\'' +
                ", fromId:'" + fromid + '\'' +
                ", toId:'" + toid + '\'' +
                ", message:'" + message + '\'' +
                '}';
    }

}
