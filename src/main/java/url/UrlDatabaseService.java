package url;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class UrlDatabaseService {
    int urlPrimaryKey;

    Map<String, UrlNode> urlDetailsMap = new HashMap<>();

    public int storeUrl(String url) {
       int id= generateNextId();
        UrlNode node = new UrlNode();
        node.setUrl(url);
        node.setUsagesCount(0);
        node.setId(id);
        urlDetailsMap.put(url, node);
        return id;
    }

    public int getUrlId(String url) {
        if(urlDetailsMap.containsKey(url)) {
            UrlNode urlNode = urlDetailsMap.get(url);
            urlNode.setUsagesCount(urlNode.getUsagesCount() + 1);
            return urlNode.getId();
        }
        return -1;
    }

    public int getUrlUsagesCount(String url) {
        if(urlDetailsMap.containsKey(url)) {
            UrlNode urlNode = urlDetailsMap.get(url);
            return urlNode.getUsagesCount();
        }
        return 0;
    }

    public String getList() {
     Collection<UrlNode> collection= urlDetailsMap.values();

     List<UrlNode> response= new ArrayList<>();
     for(UrlNode urlNode: collection){
         UrlNode temp= new UrlNode();
         temp.setUrl(urlNode.getUrl());
         temp.setUsagesCount(urlNode.getUsagesCount());
         response.add(temp);
     }

        ObjectMapper mapper = new ObjectMapper();
       // mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            return mapper.writeValueAsString(response);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private int generateNextId(){
        return ++urlPrimaryKey;
    }
}
