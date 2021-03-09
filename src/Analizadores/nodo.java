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
    
    public void getAFND(){
        if(hder!=null){
            if (valor.equals("*")){
                Interface.cant = Interface.cant + 2;
            } else if (valor.equals("+")){
                Interface.cant = Interface.cant + 2;
            } else if (valor.equals("?")){
                Interface.cant = Interface.cant + 2;
            }else if (valor.equals("\\|")){
                Interface.cant = Interface.cant + 3;
            }
            hder.getAFND();
        }
        if(hizq !=null){
            if (valor.equals("*")){
                Interface.cant = Interface.cant + 2;
            } else if (valor.equals("+")){
                Interface.cant = Interface.cant + 2;
            } else if (valor.equals("?")){
                Interface.cant = Interface.cant + 2;
            }else if (valor.equals("\\|")){
                Interface.cant = Interface.cant + 3;
            }
            hizq.getAFND();
            if (valor.equals("*")){
                Interface.inicio = Interface.inicio-1;
                Interface.fin = Interface.fin + 1;
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.inicio+1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin)+"->nodo"+String.valueOf(Interface.fin-1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.fin)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin-1)+"->nodo"+String.valueOf(Interface.inicio+1)+"[ label = ε];\n";
            } else if (valor.equals("+")){
                Interface.inicio = Interface.inicio-1;
                Interface.fin = Interface.fin + 1;
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.inicio+1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin)+"->nodo"+String.valueOf(Interface.fin-1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin-1)+"->nodo"+String.valueOf(Interface.inicio+1)+"[ label = ε];\n";
            } else if (valor.equals("?")){
                Interface.inicio = Interface.inicio-1;
                Interface.fin = Interface.fin + 1;
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.inicio+1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin)+"->nodo"+String.valueOf(Interface.fin-1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.fin)+"[ label = ε];\n";
            }else if (valor.equals("\\|")){
                Interface.inicio = Interface.inicio-1;
                Interface.fin = Interface.fin + 3;
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.inicio+1)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.fin-2)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin-3)+"->nodo"+String.valueOf(Interface.fin)+"[ label = ε];\n";
                Interface.mov+="nodo"+String.valueOf(Interface.fin-1)+"->nodo"+String.valueOf(Interface.fin)+"[ label = ε];\n";
            }
        }
        if(hizq==null && hder==null){
            Interface.inicio = Interface.cant;
            Interface.fin = Interface.cant + 1;
            Interface.mov+="nodo"+String.valueOf(Interface.inicio)+"->nodo"+String.valueOf(Interface.fin)+"[ label = \""+valor+"\"];\n";
            Interface.cant++;
        }
    }
    
    
    public void getCantAFND(){
        if(hder!=null){
            hder.getCantAFND();
        }
        if(hizq !=null){
            hizq.getCantAFND();
            if (valor.equals("*")){
                Interface.cant = Interface.cant + 2;
            } else if (valor.equals("+")){
                Interface.cant = Interface.cant + 2;
            } else if (valor.equals("?")){
                Interface.cant = Interface.cant + 2;
            }else if (valor.equals("\\|")){
                Interface.cant = Interface.cant + 3;
            }
        }
        if(hizq==null && hder==null){
            Interface.cant++;
        }
    }
    
    
}
