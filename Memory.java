
/**
 * Beschreiben Sie hier die Klasse Memory.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Memory
{
    int[][] values = new int[6][6];
    int[][] status = new int[6][6];

    IO io = new IO();
    
    /**
     * Konstruktor für Objekte der Klasse Memory
     */
    public Memory()
    {
        values = new int[][]{
            {3,4,1,5,5,2},
            {6,2,7,8,6,7},
            {1,8,9,3,9,5},
            {5,3,2,4,1,7},
            {8,9,7,9,6,2},
            {3,4,1,6,8,4}
        };
    }

    public void statusAusgeben()
    {
        status[4][2] = 1;
        status[3][5] = 1;
        
        for(int i = 0; i < status.length; i++)
        {
            for(int j = 0; j < status[i].length; j++)
            {
                int wert = status[i][j];
                if (wert == 0) {
                    io.print("*  ");
                }
                else {
                    io.print(values[i][j] + "  ");
                }
            }
            io.println("");
        }
    }
    
     public void werteAusgeben()
     {
        for(int i = 0; i < values.length; i++)
        {
            for(int j = 0; j < values[i].length; j++)
            {
                io.print(values[i][j] + "  ");
            }
            io.println("");
        }
    }
}
