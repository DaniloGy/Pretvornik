package tags;

import com.google.gson.annotations.SerializedName;

public class Attributes {
    private String id;
    private Style style;
    @SerializedName(value = "class1", alternate = "class")
    private String attClass;

    public Attributes(String id, Style style, String attClass) {
        this.id = id;
        this.style = style;
        this.attClass = attClass;
    }

    @Override
    public String toString() {
        String string = "";
        if(id != null){
            string += "id=\"" + id + "\" ";
        }
        if (attClass != null){
            string += "class=\"" + attClass + "\" ";
        }
        if(style != null){
            string += style.toString();
        }
        return string;
    }
}
