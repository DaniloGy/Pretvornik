import com.google.gson.annotations.SerializedName;

public class Style {
    private String width;
    private String height;
    @SerializedName(value = "txt-align", alternate = "text-align")
    private String textAlign;

    public Style(String width, String height, String textAlign) {
        this.width = width;
        this.height = height;
        this.textAlign = textAlign;
    }

    @Override
    public String toString() {
        String string = "style=\"";
        if(width != null){
            string += "width:" + width + ";";
        }
        if(height != null){
            string += "height:" + height + ";";
        }
        if(width != null){
            string += "text-align:" + textAlign + ";";
        }
        String string2;
        string2 = string.substring(0, string.length() - 1);
        string2 += "\"";
        return string2;
    }
}
