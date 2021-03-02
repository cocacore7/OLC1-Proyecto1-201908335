package Analizadores;

public class nodo {
    public nodo hizq;
    public nodo hder;
    public String valor;
    public int id;
    
    public nodo(nodo hizq, nodo hder, String valor, int id){
        this.hizq=hizq;
        this.hder=hder;
        this.valor=valor;
        this.id=id;
    }
    
    public String getCodigoInterno(){
        String etiqueta="";
        if(hizq==null && hder==null){
            etiqueta = "nodo"+id+"[label=\""+valor+"\"];\n";
        }
        else {
            etiqueta = "nodo" + id + " [ label =\"" + valor + "\"];\n";
        }
        if(hizq !=null){
            etiqueta+=hizq.getCodigoInterno()+"nodo"+id+"->nodo"+hizq.id+";\n";
        }
        if(hder!=null){
            etiqueta+=hder.getCodigoInterno()+"nodo"+id+"->nodo"+hder.id+";\n";
        }
        return etiqueta;
    }
    
}
