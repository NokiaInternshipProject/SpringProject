package ali.firat.elvin.tr.portal.intern.web.bean;

/**
 * Created with IntelliJ IDEA.
 * User: sakkuzu
 * Date: 21.08.2014
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */

public class ResultMessage {
    String source;
    String code;
    String header;
    String text;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "RADIUS MESSAGE" + "," +
                "source = " + source + "," +
                "code = " + code + "," +
                "header = " + header + "," +
                "text = " + text;
    }
}
