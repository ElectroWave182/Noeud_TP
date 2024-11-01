package analyse_freq;

import java.util.HashMap;
import java.util.Map;

public class AnalyseFrequentielle
{
	
	Map<Character, Integer> dico;
	
	public AnalyseFrequentielle()
	{
		dico = new HashMap<>();
		for(char c = 'a'; c <= 'z'; c ++)
		{
			dico.put(c, 0);
		}
	}

	static String texteFR = "la cryptographie est une des disciplines de la cryptologie s'attachant a"
			+ "proteger des messages, assurant confidentialite, authenticite et integrite, en s'aidant souvent"
			+ "de secrets ou cles. elle se distingue de la steganographie qui fait passer inapercu un message"
			+ "dans un autre message alors que la cryptographie rend un message inintelligible a autre que"
			+ "qui de droit. elle est utilisee depuis l'antiquite, mais certaines de ses methodes les plus"
			+ "importantes comme la cryptographie asymetrique, datent de la fin du vingtieme siecle.";

	static String texteEN = "cryptography prior to the modern age was effectively synonymous with encryption,"
			+ "the conversion of information from a readable state to apparent nonsense. the originator of an"
			+ "encrypted message shared the decoding technique needed to recover the original information"
			+ "only with intended recipients, thereby precluding unwanted persons from doing the same."
			+ "the cryptography literature often uses alice for the sender, bob for the intended recipient, and eve"
			+ "for the adversary.";

	static String texteCS = "kryptografie neboli sifrovani je nauka o metodach utajovani smyslu zprav prevodem"
			+ "do podoby, ktera je citelná jen se specialni znalosti. slovo kryptografie pochazi z rectiny kryptos"
			+ "je skryty a graphein znamena psat. Nekdy je pojem obecneji pouzivan pro vedu o cemkoli spojenem se "
			+ "siframi jako alternativa k pojmu kryptologie. kryptologie zahrnuje kryptografii a kryptoanalyzu, "
			+ "neboli lusteni zasifrovanych zprav.";

	public char[] analyser(String texte)
	{
		char lettre;
		for(int i = 0; i < texte.length(); i ++)
		{
			lettre = texte.charAt(i);
			if(dico.containsKey(lettre))
			{
				dico.put(lettre, dico.get(lettre) + 1);
			}
		}
		
		int valeur;
		int[] tri = {0, 0, 0, 0, 0, 0};
		char[] freq = new char[6];
		
		for(char c = 'a'; c <= 'z'; c ++)
		{
			valeur = dico.get(c);
			
			for(int i = 0; i < 6; i ++)
			{
				if(valeur <= tri[i] && i > 0)
				{
					for(int j = 0; j < i - 1; j ++)
					{
						tri[j] = tri[j + 1];
						freq[j] = freq[j + 1];
					}
					
					tri[i - 1] = valeur;
					freq[i - 1] = c;
					break;
				}
				else if(i == 5)
				{
					for(int j = 0; j < 5; j ++)
					{
						tri[j] = tri[j + 1];
						freq[j] = freq[j + 1];
					}
					
					tri[5] = valeur;
					freq[5] = c;
				}
			}
		}
		
		// inverser la liste freq
	}
	
	public static void main(String[] args)
	{

		System.out.println("Les 6 lettres les plus fréquentes");
		System.out.println("en français : " + analyser(texteFR));
		System.out.println("en anglais : " + analyser(texteEN));
		System.out.println("en tchèque : " + analyser(texteCS));
		
	   	
		
	}
	
}