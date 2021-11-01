package tags;

public class MetaViewport {
    private String width;
    private String initialScale;

    public MetaViewport(String width, String initialScale) {
        this.width = width;
        this.initialScale = initialScale;
    }

    @Override
    public String toString() {
        String string = "<meta name=\"viewport\" content=\"";

        if(width != null && initialScale != null){
            string += width + ", " + initialScale;
        }
        else if(width != null){
            string += width;
        }
        else if(initialScale != null){
            string += initialScale;
        }

        string += "\">\n";
        return string;
    }
}
