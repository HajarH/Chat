/*
 * Nom de classe : MetFichier
 *
 * Description   : Devait permettre de serializer un fichier ou ne image 
 * Version       : finale
 *
 * Date          : 05/02/2020
 * 
 */

/*
package model;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class MetFichier implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nameF;
    private int size;
    private ArrayList<String> text;
    
    public MetFichier(String nm, int size, ArrayList<String> txt) {
    	this.nameF = nm;
    	this.size = size;
    	this.text = txt;
    }
    
    public MetFichier() {
    	
    }
    
    public void setFileName(String file) {
    	this.nameF = file;
    }
    // getters et setters
    private void writeObject(ObjectOutputStream oos) throws IOException {
    	        oos.defaultWriteObject();
    	        oos.writeObject(this.nameF);
    }
    	 
    private void readObject(ObjectInput ois) throws ClassNotFoundException, IOException {
        String nameF = (String)ois.readObject();
        MetFichier a = new MetFichier();
        a.setFileName(nameF);
    }
}
*/
