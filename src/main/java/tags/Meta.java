package tags;

public class Meta {
    private String charset;
    private String author;
    private String keywords;
    private String description;
    private MetaViewport viewport;

    public Meta(String charset, String author, String keywords, MetaViewport viewport) {
        this.charset = charset;
        this.author = author;
        this.keywords = keywords;
        this.viewport = viewport;
    }

    @Override
    public String toString() {
        String string = "";

        if(charset != null){
            string += "\t\t<meta charset=\"" + charset + "\">\n";
        }
        if(viewport != null){
            string += "\t\t" + viewport.toString();
        }
        if(author != null){
            string += "\t\t<meta name=\"author\" content=\"" + author + "\">\n";
        }
        if(keywords != null){
            string += "\t\t<meta name=\"keywords\" content=\"" + keywords + "\">\n";
        }
        if(description != null){
            string += "\t\t<meta name=\"description\" content=\"" + description + "\">\n";
        }

        return string;
    }
}
