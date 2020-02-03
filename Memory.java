
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
    int versuche = 0;
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

    public int randomPos() {
        return (int) (Math.random() * 4) + 1;
    }
    
    public void showValues() {
    for(int i = 0; i < values.length; i++) {
        for(int x = 0; x < values[i].length; x++) {
            
            
        }
    }
    
    }
    
    public void play() {
        loadStatus();
        while(true) {
            if(countHidden() > 0) {
                statusAusgeben();
                versuche++;
                io.println("Bitte Location 1 eingeben. (z.B. 1,1)");
                
                String eingabe = io.readString();
                String[] eingabe_array = eingabe.split(",");
                
                if(status[Integer.parseInt(eingabe_array[0])][Integer.parseInt(eingabe_array[1])] == 0) {
                    status[Integer.parseInt(eingabe_array[0])][Integer.parseInt(eingabe_array[1])] = 1;
                    
                    statusAusgeben();
                    
                    io.println("Bitte Location 2 eingeben. (z.B. 1,1)");
                                    
                    String eingabe2 = io.readString();
                    String[] eingabe2_array = eingabe2.split(",");
                    
                    if(status[Integer.parseInt(eingabe2_array[0])][Integer.parseInt(eingabe2_array[1])] == 0) {
                        if(values[Integer.parseInt(eingabe_array[0])][Integer.parseInt(eingabe_array[1])] == values[Integer.parseInt(eingabe2_array[0])][Integer.parseInt(eingabe2_array[1])]) {
                            status[Integer.parseInt(eingabe2_array[0])][Integer.parseInt(eingabe2_array[1])] = 2;
                            status[Integer.parseInt(eingabe_array[0])][Integer.parseInt(eingabe_array[1])] = 2;
                            io.println("2 Karten wurden aufgedeckt.");
                        } else {
                            status[Integer.parseInt(eingabe_array[0])][Integer.parseInt(eingabe_array[1])] = 0;
                            io.println("Wooooouups!");
                        }
                        
                        
                    } else {
                        io.println("Die Karte ist bereits aufgedeckt.");
                        status[Integer.parseInt(eingabe_array[0])][Integer.parseInt(eingabe_array[1])] = 0;

                    }
                    
                        
                } else {
                    io.println("Die Karte ist bereits aufgedeckt.");
                }
                
            } else {
                break;
            }
        
        }
    }
    
    
    public void statusAusgeben()
    {
        
        for(int i = 0; i < status.length; i++)
        {
            for(int j = 0; j < status[i].length; j++)
            {
                int wert = status[i][j];
                if (wert == 0) {
                    io.print("*  ");
                }
                else if(wert == 1) {
                    io.print(values[i][j] + "  ");
                } else {
                    io.print("   "); 
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
    
     public void loadStatus()
    {
        status = new int[][]
        {
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };
    }
    
    public int countHidden()
    {   
        int count = 0;
        for (int i = 0; i < status.length; i++)
        {
            for (int j = 0; j < status[i].length; j++)
            {
                if (status[i][j] == 0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
