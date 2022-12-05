/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;

/**
 *
 * @author Ricardo
 */
public class Festa {
    
   private int idFesta;
   private String dt_Festa;
   private String valor_Festa;

    /**
     * @return the idFesta
     */
    public int getidFesta() {
        return idFesta;
    }

    /**
     * @param idFesta the idFesta to set
     */
    public void setidFesta(int idFesta) {
        this.idFesta = idFesta;
    }

    /**
     * @return the dt_Festa
     */
    public String getdt_Festa() {
        return dt_Festa;
    }

    /**
     * @param dt_Festa the dt_Festa to set
     */
    public void setdt_Festa(String dt_Festa) {
        this.dt_Festa = dt_Festa;
    }

    /**
     * @return the valor_Festa
     */
    public String getvalor_Festa() {
        return valor_Festa;
    }

    /**
     * @param valor_Festa the valor_Festa to set
     */
    public void setvalor_Festa(String valor_Festa) {
        this.valor_Festa = valor_Festa;
    }
   
   
    
 
}
