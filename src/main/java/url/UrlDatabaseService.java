package url;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

/**
 * this class will handle all the operation on url
 */
public class UrlDatabaseService {
    int urlPrimaryKey;

    Map<String, UrlNode> urlDetailsMap = new HashMap<>();

    /*
    this method will add the provided url to hashmap and return the short id
     */
    public int storeUrl(String url) {
        //this method will generate the uniques id for URL resource
       int id= generateNextId();
        UrlNode node = new UrlNode();
        node.setUrl(url);
        node.setUsagesCount(0);
        node.setId(id);
        urlDetailsMap.put(url, node);
        return id;
    }

    /**
     * this method will return the url id after incrementing the usages count
     * @param url
     * @return
     */
    public int getUrlId(String url) {
        if(urlDetailsMap.containsKey(url)) {
            UrlNode urlNode = urlDetailsMap.get(url);
            urlNode.setUsagesCount(urlNode.getUsagesCount() + 1);
            return urlNode.getId();
        }
        return -1;
    }

    /**
     * return the usages count for provided url
     * @param url
     * @return
     */
    public int getUrlUsagesCount(String url) {
        if(urlDetailsMap.containsKey(url)) {
            UrlNode urlNode = urlDetailsMap.get(url);
            return urlNode.getUsagesCount();
        }
        return 0;
    }

    /**
     * it will return all available url resoruces in our in-memory database
     * @return
     */
    public String getList() {
     Collection<UrlNode> collection= urlDetailsMap.values();

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(collection);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private int generateNextId(){
        return ++urlPrimaryKey;
    }
}
