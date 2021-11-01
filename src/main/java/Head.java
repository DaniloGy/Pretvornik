import java.util.List;

public class Head {
    private String title;
    private Meta meta;
    private List<Link> link;

    public Head(String title, Meta meta, List<Link> link) {
        this.title = title;
        this.meta = meta;
        this.link = link;
    }

    @Override
    public String toString() {
        String string = "\t<head>\n";
        string += meta.toString();
        if (link != null){
            for (Link l : link)
            {
                string += "\t\t" + l.toString();
            }
        }

        string += "\t\t<title>" + title + "</title>\n";
        string += "\t</head>\n";
        return string ;
    }
}
