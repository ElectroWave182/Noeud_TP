package traduction;

import java.util.HashMap;
import java.util.Map;

public class Traduction_en_fr
{
	
    public static void main(String[] args)
    {
    	
    	Map<String, String> dico = new HashMap<>();
    	dico.put("a","un");
    	dico.put("and","et");
    	dico.put("algorithm","algorithme");
    	dico.put("can","peut");
    	dico.put("every","chaque");
    	dico.put("give","donne");
    	dico.put("knows","sait");
    	dico.put("only","seulement");
    	dico.put("poor","pauvre");
    	dico.put("programmer","programmeur");
    	dico.put("results","résultats");
    	dico.put("the","le");
    	dico.put("that","cela");
    	dico.put("translation","traduction");
    	dico.put("to","vers");
    	dico.put("word","mot");
    	
    	String phrase = "every programmer knows that a word to word translation algorithm can only give poor results and "
		+ "a better algorithm could improve the results of the translation";

    	String trad = "";
    	String[] mots = phrase.split(" ");
    	
    	for(String m: mots)
    	{
    		if(dico.containsKey(m))
			{
    			trad += dico.get(m) + " ";
			}
    		else
    		{
    			trad += "(" + m + ") ";
    		}
    	}
    	
    	System.out.print(trad);
    }
    
}
