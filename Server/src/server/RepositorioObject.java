package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Funcionario;
import beans.Item;
import beans.Mesa;
import beans.Pedido;

public class RepositorioObject implements Serializable{
	private Object listas[] = new Object[4];
	
	private static RepositorioObject instance;

	private RepositorioObject() {
		listas[0] = new ArrayList<Funcionario>();
		listas[1] = new ArrayList<Item>();
		listas[2] = new ArrayList<Mesa>();
		listas[3] = new ArrayList<Pedido>();
 	}
	
	/**
	 * @return the listas
	 */
	public Object[] getListas() {
		return listas;
	}

	/**
	 * @param listas the listas to set
	 */
	public void setListas(Object[] listas) {
		
		if (((ArrayList<Funcionario>) listas[0]).size() > 0) {
			this.listas = listas;
			salvarArquivo();
		}
	}

	/**
	 * @return the instance
	 */
	public static RepositorioObject getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}
	
	public static RepositorioObject lerArquivo(){
		RepositorioObject instancia = null;
		File in = new File("listas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            
            Object o = ois.readObject();
            instancia = (RepositorioObject) o;
            
        } catch (Exception e) {
            instancia = new RepositorioObject();
        } finally {
            if (ois != null) {
            	try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
                
            }
        }
        return instancia;
        
	}
	
	public void salvarArquivo(){
		File out = new File("listas.dat");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            
			oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try { 
                	oos.close(); 
                } catch (IOException e) {
                	e.printStackTrace();
                }
            }
        }
	}

}
