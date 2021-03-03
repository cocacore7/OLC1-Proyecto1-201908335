package Analizadores;

import proyecto1c1.Interface;

public class nodo {
    public nodo hizq;
    public nodo hder;
    public String valor;
    public String hoja;
    public String anulable;
    public String ant;
    public String sig;
    public int id;
    
    public nodo(nodo hizq, nodo hder, String valor, String hoja, String anulable, String ant, String sig, int id){
        this.hizq=hizq;
        this.hder=hder;
        this.valor=valor;
        this.hoja=hoja;
        this.anulable=anulable;
        this.ant=ant;
        this.sig=sig;
        this.id=id;
    }
    
    public String getCodigoInterno(){
        String etiqueta;
        if(hizq==null && hder==null){
            etiqueta = "nodo"+id+"[shape=record, label=\""+ant+"|{"+anulable+"|"+valor+"|id: "+hoja+"}|"+sig+"\"];\n";
            Interface.Hojas.add(valor);
        }
        else {
            etiqueta = "nodo" + id + "[shape=record, label=\""+ant+"|{"+anulable+"|"+valor+"|id: "+hoja+"}|"+sig+"\"];\n";
        }
        if(hizq !=null){
            etiqueta+=hizq.getCodigoInterno()+"nodo"+id+"->nodo"+hizq.id+";\n";
        }
        if(hder!=null){
            etiqueta+=hder.getCodigoInterno()+"nodo"+id+"->nodo"+hder.id+";\n";
        }
        return etiqueta;
    }
    
    public void getTablaSiguiente(){
        if(hizq !=null){
            hizq.getTablaSiguiente();
            if (valor.equals("*") || valor.equals("+")){
                String[] cadena = hizq.ant.split(",");
                String[] cadena2 = hizq.sig.split(",");
                for (String pos: cadena){
                    if (Integer.valueOf(pos)<=Interface.Siguientes.size()){TS(cadena2,Integer.valueOf(pos));}
                }
            }
            else if (valor.equals(".")){
                String[] cadena = hizq.sig.split(",");
                String[] cadena2 = hder.ant.split(",");
                for (String pos: cadena){
                    if (Integer.valueOf(pos)<=Interface.Siguientes.size()){TS(cadena2,Integer.valueOf(pos));}
                }
            }
        }
        if(hder!=null){
            hder.getTablaSiguiente();
        }
    }
    
    public static void TS(String[] cadena, int pos){
        String regreso = Interface.Siguientes.get(pos-1);
        boolean bandera = false;
        for(String valor: cadena){
            if (Interface.Siguientes.get(pos-1).equals(".")){
                if (bandera){
                    regreso+=","+valor;
                }
                else{
                    regreso=valor;
                    bandera = true;
                }
            }else{regreso+=","+valor;}
            
        }
        Interface.Siguientes.set(pos-1, regreso);
    }
    
}
