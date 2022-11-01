package url;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serial;
import java.io.Serializable;

@JsonIgnoreProperties("id")
public class UrlNode implements Serializable {

    private int id;
    private int usagesCount;
   private String url;

    public UrlNode() {
    }

    public UrlNode(int id, int count, String url) {
        this.id = id;
        this.usagesCount = count;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsagesCount() {
        return usagesCount;
    }

    public void setUsagesCount(int usagesCount) {
        this.usagesCount = usagesCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
