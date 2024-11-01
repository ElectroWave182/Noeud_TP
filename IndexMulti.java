package tp5;

import java.util.HashSet;

import tp5.Chose.Couleur;
import tp5.Chose.Forme;
import tp5.Chose.Taille;

public class IndexMulti
{

	static HashSet<Chose> petits;
	static HashSet<Chose> jaunes;
	static HashSet<Chose> grands;
	static HashSet<Chose> carres;
	
	public IndexMulti(HashSet<Chose> p, HashSet<Chose> j, HashSet<Chose> g, HashSet<Chose> c)
	{
		petits = p;
		jaunes = j;
		grands = g;
		carres = c;
	}
	
	public void indexer(Chose chose)
	{
		if(chose.tail == Taille.Petit)
		{
			petits.add(chose);
		}
		if(chose.tail == Taille.Grand)
		{
			grands.add(chose);
		}
		if(chose.form == Forme.Carre)
		{
			carres.add(chose);
		}
		if(chose.coul == Couleur.Jaune)
		{
			jaunes.add(chose);
		}
	}

	public static void main(String[] args)
	{
		
		IndexMulti index = new IndexMulti(new HashSet<Chose>(), new HashSet<Chose>(), new HashSet<Chose>(), new HashSet<Chose>());
		index.indexer(new Chose("point", Taille.Petit, Forme.Rond, Couleur.Noir));
		index.indexer(new Chose("petit pois", Taille.Petit, Forme.Rond, Couleur.Vert));
		index.indexer(new Chose("soleil", Taille.Grand, Forme.Rond, Couleur.Jaune));
		index.indexer(new Chose("pre", Taille.Grand, Forme.Carre, Couleur.Vert));
		index.indexer(new Chose("post-it", Taille.Petit, Forme.Carre, Couleur.Jaune));
		index.indexer(new Chose("pneu", Taille.Grand, Forme.Rond, Couleur.Noir));
		
		petits.retainAll(jaunes);
		System.out.println(petits);	
		
		grands.removeAll(carres);
		System.out.print(grands);
		
	}
	
}
