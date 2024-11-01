import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Noeud<E>
{
	
	public Noeud<E> filsG, filsD;
	public E elt;

	public Noeud(E e)
	{
		elt = e;
	}

	public Noeud(E e, Noeud<E> g, Noeud<E> d)
	{
		filsD = d;
		filsG = g;
		elt = e;
	}

	public int taille()
	{
		int t = 1;
		
		if (filsD != null)
		{
			t += filsD.taille();
		}
		if (filsG != null)
		{
			t += filsG.taille();
		}
		
		return t;
	}

	public int hauteur()
	{
		int hg = 0;
		int hd = 0;
		
		if (filsD != null)
		{
			hg = filsD.hauteur();
		}
		if (filsG!=null)
		{
			hd = filsG.hauteur();
		}
		
		return 1 + Math.max(hg,hd);
	}
	
	public String toString()
	{
		String chaine = "";
	
		if (filsG != null)
		{
			chaine += filsG;
		}
		chaine += elt;
		if (filsD != null)
		{
			chaine += filsD;
		}
		
		return chaine;
	}
	
	public Vector<E> parcoursProfondeur()
	{
		Noeud<E> pere;
		Vector<E> liste = new Vector<>();
		Stack<Noeud<E>> pile = new Stack<>();
		
		liste.add(elt);
		
		if (filsD != null)
		{
			pile.push(filsD);
		}
		if (filsG != null)
		{
			pile.push(filsG);
		}
		
		while (true)
		{
			pere = pile.peek();
			pile.pop();
			liste.add(pere.elt);
			
			if (pere.filsD != null)
			{
				pile.push(pere.filsD);
			}
			if (pere.filsG != null)
			{
				pile.push(pere.filsG);
			}
			
			if (pile.isEmpty())
			{
				break;
			}
		}
		
		return liste;
	}
	
	public Vector<E> parcoursLargeur()
	{
		Noeud<E> pere;
		Vector<E> liste = new Vector<>();
		ConcurrentLinkedQueue<Noeud<E>> file = new ConcurrentLinkedQueue<>();
		
		liste.add(elt);
		
		if (filsG != null)
		{
			file.add(filsG);
		}
		if (filsD != null)
		{
			file.add(filsD);
		}
		
		while (true)
		{
			pere = file.peek();
			file.poll();
			liste.add(pere.elt);
			
			if (pere.filsG != null)
			{
				file.add(pere.filsG);
			}
			if (pere.filsD != null)
			{
				file.add(pere.filsD);
			}
			
			
			if (file.isEmpty())
			{
				break;
			}
		}
		
		return liste;
	}
	
	public static void main(String[] args)
	{
		
		Noeud<Character> arbreBinaire = new Noeud<Character>('A',
			new Noeud<Character>('F',
				new Noeud<Character>('C', 
					new Noeud<Character>('R'),
					new Noeud<Character>('P')
					),
				new Noeud<Character>('J')
			),
			new Noeud<Character>('B',
				new Noeud<Character>('M', 
					new Noeud<Character>('S'),
					null
				),
				null
			)
		);
		
		System.out.println(arbreBinaire);
		System.out.println(arbreBinaire.parcoursProfondeur());
		System.out.println(arbreBinaire.parcoursLargeur());
		
	}
	
}
