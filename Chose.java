package tp5;

public class Chose
{
	
	String nom;
	Taille tail;
	Forme form;
	Couleur coul;
	
	public Chose(String n, Taille t, Forme f, Couleur c)
	{
		this.nom = n;
		this.tail = t;
		this.form = f;
		this.coul = c;
	}
	
	public enum Taille
	{
		Petit, Grand;
	}
	
	public enum Forme
	{
		Carre, Rond;
	}
	
	public enum Couleur
	{
		Jaune, Vert, Noir;
	}
	
	public String toString()
	{
		return this.nom;
	}
	
}
