package tags;

public class Link {
    private String href;
    private String rel;
    private String type;

    public Link(String href, String rel, String type) {
        this.href = href;
        this.rel = rel;
        this.type = type;
    }

    @Override
    public String toString() {
        String string = "<link href=\"" + href + "\" rel=\"" + rel + "\" ";
        if(type != null){
            string += "type=\"" + type + "\" ";
        }
        string += ">\n";
        return string;
    }
}
