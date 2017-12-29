
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Graphe_Biparti
{
    private int NombreDeSommets;
    private Queue<Integer> queue;
 
    public static final int NO_COLOR = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;
 
    public Graphe_Biparti(int NombreDeSommets)
    {
        this.NombreDeSommets = NombreDeSommets;
        queue = new LinkedList<Integer>();
    }
 
    public boolean Bipartite(int matriceAdjacence[][], int source)
    {
        int[] colored = new int[NombreDeSommets +  1];
        for (int sommet = 1; sommet <= NombreDeSommets; sommet++)
        {
            colored[sommet] = NO_COLOR;
        }
        colored[source] = RED;
        queue.add(source);
 
        int element, sommetAdjacent;
        while (!queue.isEmpty())
        {
            element = queue.remove();
            sommetAdjacent = 1;
            while (sommetAdjacent <= NombreDeSommets)
            { 
                if (matriceAdjacence[element][sommetAdjacent] == 1 && colored[element]== colored[sommetAdjacent])
                {
                    return false;
                }
                if (matriceAdjacence[element][sommetAdjacent] == 1 && colored[sommetAdjacent]== NO_COLOR)
                {
                    colored[sommetAdjacent] = (colored[element] == RED ) ? BLUE :RED;
                    queue.add(sommetAdjacent);
                }
                sommetAdjacent++;
            }
        }
        return true;
    }
 
}