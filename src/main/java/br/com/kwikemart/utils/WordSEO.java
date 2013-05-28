package br.com.kwikemart.utils;

import static java.text.Normalizer.normalize;
import static org.apache.commons.validator.GenericValidator.isBlankOrNull;

import java.text.Normalizer;

import br.com.caelum.vraptor.ioc.Component;
import br.com.ebit.portal.jcs.JCSWrapper;

@Component
public class WordSEO {

    private static JCSWrapper<String, String> cache;
    
    public WordSEO() {
        cache = new JCSWrapper<String, String>("WordSEO");
    }
    
    public String get(String word){
        
        String wordCache = cache.get(word);
        
        if(isBlankOrNull(wordCache)) {
            word = Normalizer.normalize(word, Normalizer.Form.NFD);  
			word = word.replaceAll("[^A-Za-z0-9 -]+", "");
            word = word.replaceAll("\\ ","-");
            word = eliminateAccents(word);
        } else {
            word = wordCache;
        }
        
        return word.toLowerCase();
    }
    
    public static String eliminateAccents(String word) {
        return normalize(word, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
