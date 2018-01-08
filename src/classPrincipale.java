
import java.util.InputMismatchException;
import java.util.Scanner;


public class classPrincipale {
    public static void main(String... arg)
    {
        int nombre_de_nœuds, source;
        Scanner scanner = null;
        try 
        {
           System.out.println("Entrez le nombre de sommets du graphe");
           scanner = new Scanner(System.in);
           nombre_de_nœuds = scanner.nextInt();
 
           int matrice_d_djacence[][] = new int[nombre_de_nœuds + 1][nombre_de_nœuds + 1];
           System.out.println("Entrez la matrice d'adjacence");
           for (int i = 1; i <= nombre_de_nœuds; i++)
           {
               for (int j = 1; j <= nombre_de_nœuds; j++)
               {	
                   matrice_d_djacence[i][j] = scanner.nextInt();
                   //System.out.println(matrice_d_djacence);
               }
           }
 
           for (int i = 1; i <= nombre_de_nœuds; i++)
           {
               for (int j = 1; j <= nombre_de_nœuds; j++)
               {	
                   if(matrice_d_djacence[i][j] == 1 && matrice_d_djacence[j][i] == 0)
                   {
                       matrice_d_djacence[j][i] = 1;
                   }
               }
           }
 
           System.out.println("Entrez la source du graphe");
           source = scanner.nextInt();
 
           Graphe_Biparti GrapheBiparti = new Graphe_Biparti(nombre_de_nœuds);
           if (GrapheBiparti.Bipartite(matrice_d_djacence, source)) 
           {
               System.out.println("Le graphique donné est un graphe biparti");
           } else
           {
               System.out.println("Le graphique donné n'est pas un graphe biparti");
           }
       } catch (InputMismatchException inputMismatch) 
       {
           System.out.println("format erroné");
       }
       scanner.close();
    }
}
    

