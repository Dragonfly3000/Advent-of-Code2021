import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Aventofcode {

	public static void main(String[] args) {
		 FileReader fr = null;
		    BufferedReader br = null;
		    String[] binario = new String[]{"","","","","","","","","","","",""};
		    String[] datos = new String[5];
		    int pos = 7;
		    try {
		       // Apertura del fichero y creacion de BufferedReader para poder
		       // hacer una lectura comoda (disponer del metodo readLine()).
		       File archivo = new File ("C:\\Users\\Jeslid\\eclipse-workspace\\Aventofcode\\src\\input.txt");
		       fr = new FileReader (archivo);
		       br = new BufferedReader(fr);
		
		       // Lectura del fichero
		       String linea;
		       int j = 0;
		       while((linea=br.readLine())!=null) {
		    	   datos[j] = linea;
		    	   j++;
		          for(int i = 0; i < 12; i++) {	        	
		        	  binario[i] += linea.charAt(i)+"";
		          }	         
		       }
		       //buscamos el bot con mas fecuencia ya sea mayor o menor
		       String binSalida = "";
		       for(int i = 0; i < 12; i++) {
		        	 //System.out.println(binario[i]);
		        	 binSalida += contar_(binario[i], 0); //mayor prioridad	(K segundo paramtro)        	 
		       }
		       //System.out.println(binSalida);
		       
		       //seleccionamos el bit con mas frecuencia en pos;
		       char c = binSalida.charAt(pos);
		       for(int i = 0; i < datos.length; i++) {
		    	   if(datos[i].charAt(pos) == c){
		    		   System.out.println(datos[i]);	//este sera el resultado del nuevo archivo para leer.	    		   
		    	   }
		       }
		       
		       //PRIMERA PARTE 3865 * 613 111100011001
		    }
		    catch(Exception e){
		       e.printStackTrace();
		    }finally{
		       // En el finally cerramos el fichero, para asegurarnos
		       // que se cierra tanto si todo va bien como si salta 
		       // una excepcion.
		       try{                    
		          if( null != fr ){   
		             fr.close();     
		          }                  
		       }catch (Exception e2){ 
		          e2.printStackTrace();
		       }
		    }
			        
		}
		
		public static String contar_(String cad, int k) {
			int cero = 0, uno = 0;
			
			for(int i = 0; i < cad.length(); i++) {
				if(cad.charAt(i) == '1') {
					uno++;
				}
				else
					cero++;
			}
			
			if(k == 1) {
				if(uno > cero)
					return "1";
				else
					return "0";
			}else {
				if(uno > cero)
					return "0";
				else
					return "1";
			}		
		}
}
