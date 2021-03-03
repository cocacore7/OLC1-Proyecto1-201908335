package Analizadores;

public class error {
    public String tipoError;
    public String valorError;
    public int fila;
    public int columna;
    
    public error(String tipoError, String valorError, int fila, int columna){
        this.tipoError = tipoError;
        this.valorError = valorError;
        this.fila = fila;
        this.columna = columna;
    }
    
    public String getTipoError(){
        return tipoError;
    }
    
    public void setTipoError(String tipoError){
        this.tipoError = tipoError;
    }
    
    public String getValorError(){
        return valorError;
    }
    
    public void setValorError(String valorError){
        this.valorError = valorError;
    }
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}
