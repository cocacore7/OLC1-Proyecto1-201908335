package proyecto1c1;

import Analizadores.*;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Interface extends javax.swing.JFrame {
    public static ArrayList<nodo> Arboles;
    public static ArrayList<conjunto> Conjuntos;
    public static ArrayList<Entradas> Entradas;
    public static ArrayList<AFD> AFDS;
    public static ArrayList<error> Errores;
    public static ArrayList<String> NombresA;
    public static ArrayList<String> Hojas;
    public static ArrayList<String> Siguientes;
    public static ArrayList<String> Estados;
    public static ArrayList<String> Terminales;
    public static ArrayList<String> EstadosL;
    public static ArrayList<String> Inicios;
    public static String Mueves[][];
    public static int arch = 0;
    
    public static String ruta = "./src/ArchivoNuevo.olc";
    public FileDialog fdGuardar;
    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGAutomatas = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Archivo De Entrada");

        jLabel2.setText("Salida");

        btnGAutomatas.setText("Generar Automatas");
        btnGAutomatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGAutomatasActionPerformed(evt);
            }
        });

        btnAnalizar.setText("Analizar Entrada");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo Archivo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane1.setViewportView(txtEntrada);

        txtSalida.setColumns(20);
        txtSalida.setRows(5);
        jScrollPane2.setViewportView(txtSalida);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setText("Guardar Como");
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnAbrir.setText("Abrir Archivo");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(btnGAutomatas)
                            .addComponent(btnNuevo)
                            .addComponent(jLabel1)
                            .addComponent(btnGuardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnalizar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAbrir, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarC, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnAbrir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGAutomatas)
                    .addComponent(btnAnalizar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        if(!Entradas.isEmpty()){
            conjunto conj = null;
            for (int x = 0;x<AFDS.size();x++){
                for (int y=0;y<AFDS.get(x).Terminales.size();y++){
                    for(int z= 0;z<Conjuntos.size();z++){
                        if(Conjuntos.get(z).nombre.equals(AFDS.get(x).Terminales.get(y))){
                            conj = null;
                            break;
                        }else{
                            ArrayList<String> aux = new ArrayList<>();
                            aux.add(AFDS.get(x).Terminales.get(y));
                            conj = new conjunto(AFDS.get(x).Terminales.get(y),"",aux);
                        }
                    }
                    if(conj!=null){Conjuntos.add(conj);}
                }
            }
            FileWriter fichero = null;
            PrintWriter pw;
            try {
                arch++;
                fichero = new FileWriter("./src/Salidas_201908335/Archivo" + String.valueOf(arch) + ".json");
                pw = new PrintWriter(fichero);
                pw.println("[");
                for (int x = 0; x<Entradas.size();x++){
                    Entradas a = Entradas.get(x);
                    int exp = obtenerPosIDen(a.expresion);
                    AFD afd = AFDS.get(exp);
                    if(validarLetra(afd,a)){
                        txtSalida.setText(txtSalida.getText()+"\n"+Entradas.get(x).expresion+" - "+'"'+Entradas.get(x).valor+'"' +" Aceptada");
                        if (x != (Entradas.size()-1)){
                            pw.println("    {");
                            pw.println("        "+'"'+"Valor"+'"'+":"+'"'+Entradas.get(x).valor+'"'+",");
                            pw.println("        "+'"'+"ExpresionRegular"+'"'+":"+'"'+Entradas.get(x).expresion+'"'+",");
                            pw.println("        "+'"'+"Resultado"+'"'+":"+'"'+"Cadena Valida"+'"'+"");
                            pw.println("    },");
                        }else{
                            pw.println("    {");
                            pw.println("        "+'"'+"Valor"+'"'+":"+'"'+Entradas.get(x).valor+'"'+",");
                            pw.println("        "+'"'+"ExpresionRegular"+'"'+":"+'"'+Entradas.get(x).expresion+'"'+",");
                            pw.println("        "+'"'+"Resultado"+'"'+":"+'"'+"Cadena Valida"+'"'+"");
                            pw.println("    }");
                        }
                    }else{
                        txtSalida.setText(txtSalida.getText()+"\n"+Entradas.get(x).expresion+" - "+'"'+Entradas.get(x).valor+'"' +" Incorrecta");
                        if (x != (Entradas.size()-1)){
                            pw.println("    {");
                            pw.println("        "+'"'+"Valor"+'"'+":"+'"'+Entradas.get(x).valor+'"'+",");
                            pw.println("        "+'"'+"ExpresionRegular"+'"'+":"+'"'+Entradas.get(x).expresion+'"'+",");
                            pw.println("        "+'"'+"Resultado"+'"'+":"+'"'+"Cadena Incorrecta"+'"'+"");
                            pw.println("    },");
                        }else{
                            pw.println("    {");
                            pw.println("        "+'"'+"Valor"+'"'+":"+'"'+Entradas.get(x).valor+'"'+",");
                            pw.println("        "+'"'+"ExpresionRegular"+'"'+":"+'"'+Entradas.get(x).expresion+'"'+",");
                            pw.println("        "+'"'+"Resultado"+'"'+":"+'"'+"Cadena Incorrecta"+'"'+"");
                            pw.println("    }");
                        }
                    }
                }
                
                pw.println("]");
            } catch (IOException e) {
                System.out.println("error, no se realizo el archivo");
            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                } catch (IOException e2) {}
            }
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    public boolean validarLetra(AFD afd, Entradas a){
        int estado = 0;
        boolean bandera = false;
        String EstadoA;
        String[] datos = a.valor.split("");
        for (String letra: datos){
            bandera = false;
            for(int x = 0; x<afd.Mueves[estado].length;x++){
                if(!afd.Mueves[estado][x].equals("---")){
                    String conj = afd.Terminales.get(x);
                    for (int y = 0;y<Conjuntos.size();y++){
                        if(Conjuntos.get(y).nombre.equals(conj)){
                            for(int z= 0;z<Conjuntos.get(y).valores.size();z++){
                                if(letra.equals(Conjuntos.get(y).valores.get(z))){
                                    bandera = true;
                                    EstadoA = afd.Mueves[estado][x];
                                    estado = posEstado(EstadoA,afd);
                                    break;
                                }
                            }
                            if (bandera){break;}
                        }
                    }
                    if (bandera){break;}
                }
            }
            if (!bandera){return false;}
        }
        
        return bandera;
    }
    
    public int posEstado(String s, AFD afd){
        int pos = 0;
        for(int x = 0; x < afd.Estados.size(); x++){
            if(s.equals(afd.Estados.get(x))){
                pos = x;
                break;
            }
        }
        return pos;
    }
    
    public int obtenerPosIDen(String s){
        int exp = 0;
        for (int y = 0;y<NombresA.size();y++){
            if(s.equals(NombresA.get(y))){
                exp = y;
                break;
            }
        }
        return exp;
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        fdGuardar=new FileDialog(fdGuardar, "Guardar como", FileDialog.SAVE);
        fdGuardar.setVisible(true);
        fdGuardar.dispose();
        ruta = fdGuardar.getDirectory()+fdGuardar.getFile()+".olc";
        File archivo = new File(ruta);
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtEntrada.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        File archivo = new File(ruta);
        if(!archivo.exists()){try {
            archivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            FileWriter escribir = new FileWriter(archivo);
            try (BufferedWriter escribirb = new BufferedWriter(escribir)) {
                escribirb.write(txtEntrada.getText());
                escribirb.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        fdGuardar=new FileDialog(fdGuardar, "Guardar como", FileDialog.SAVE);
        fdGuardar.setVisible(true);
        fdGuardar.dispose();
        ruta = fdGuardar.getDirectory()+fdGuardar.getFile()+".olc";
        File archivo = new File(ruta);
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            FileWriter escribir = new FileWriter(archivo);
            try (BufferedWriter escribirb = new BufferedWriter(escribir)) {
                escribirb.write(txtEntrada.getText());
                escribirb.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        txtEntrada.setText("");
        JFileChooser selec = new JFileChooser();
        if(selec.showDialog(null,"Abrir")==JFileChooser.APPROVE_OPTION){
            File archivo = selec.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("olc")){
                    try {
                        String doc = "";
                        String linea;
                        ruta = archivo.getAbsolutePath();
                        FileReader fr = new FileReader(ruta);
                        BufferedReader read = new BufferedReader(fr);
                        while((linea = read.readLine()) != null){
                            doc += linea + "\n";
                        }
                        txtEntrada.setText(doc);
                    } catch (IOException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                }
            }
        }
        
        
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGAutomatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGAutomatasActionPerformed
        Arboles = new ArrayList<>();
        Entradas = new ArrayList<>();
        Conjuntos = new ArrayList<>();
        NombresA = new ArrayList<>();
        AFDS = new ArrayList<>();
        Errores = new ArrayList<>();
        String entra = txtEntrada.getText();
        try {
            parser sintactico;
            sintactico = new parser(new lexico(new StringReader(entra)));
            sintactico.parse();
        } catch (Exception ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Errores.isEmpty()){
            for(int x = 0; x < Conjuntos.size();x++){
                Conjuntos.get(x).valores = obtenerValoresConj(Conjuntos.get(x));
            }
            txtSalida.setText("");
            if (!Arboles.isEmpty()){
                for (int x=0;x<Arboles.size();x++){
                    Hojas = new ArrayList<>();
                    Siguientes = new ArrayList<>();
                    Estados = new ArrayList<>();
                    Terminales = new ArrayList<>();
                    EstadosL = new ArrayList<>();
                    Inicios = new ArrayList<>();
                    graficarArbol(Arboles.get(x),"Arbol"+String.valueOf(x+1)+"-"+NombresA.get(x));
                    graficarAFND(Arboles.get(x),"AFND"+String.valueOf(x+1)+"-"+NombresA.get(x));
                    generarTS(Arboles.get(x),"Siguientes"+String.valueOf(x+1)+"-"+NombresA.get(x));
                    generarTran("Trancisiones"+String.valueOf(x+1)+"-"+NombresA.get(x));
                    generarAFD("AFD"+String.valueOf(x+1)+"-"+NombresA.get(x));
                    AFD a = new AFD(NombresA.get(x), Mueves,EstadosL,Terminales);
                    AFDS.add(a);
                    txtSalida.setText(txtSalida.getText()+"\n"+"Graficos " + NombresA.get(x) + "Creados :D" );
                }
            }else{
                try {
                    generarHTML();
                } catch (IOException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                generarHTML();
            } catch (IOException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnGAutomatasActionPerformed
    
    public ArrayList<String> obtenerValoresConj(conjunto conj){
        ArrayList<String> aux = new ArrayList<>();
        String[] datos = conj.con.split(",");
        if (datos.length>1){
            aux.addAll(Arrays.asList(datos));
        }else{
            byte[] ascii = datos[0].getBytes(StandardCharsets.US_ASCII);
            int in = ascii[0]; int fi = ascii[2];
            if((in>=48 && in <= 57)||(in>=65 && in <= 90)||(in>=97 && in <= 122)){
                if((fi>=48 && fi <= 57)||(fi>=65 && fi <= 90)||(fi>=97 && fi <= 122)){
                    if(in>fi){
                        for(int i = in; i >= fi; i--){
                            if((i>=48 && i <= 57)||(i>=65 && i <= 90)||(i>=97 && i <= 122)){
                                aux.add(String.valueOf((char)i));
                            }
                        }
                    }else{
                        for(int i = in; i <= fi; i++){
                            if((i>=48 && i <= 57)||(i>=65 && i <= 90)||(i>=97 && i <= 122)){
                                aux.add(String.valueOf((char)i));
                            }
                        }
                    }
                }
            }else{
                for(int i = in; i <= fi; i++){
                    if(i<48 || i > 57){
                        if(i<65 || i > 90){
                            if(i<97 || i > 122){
                                aux.add(String.valueOf((char)i));
                            }
                        }
                    }
                }
            }
            
        }
        return aux;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
    public static void graficarArbol(nodo act, String nombre){
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("./src/Arboles_201908335/" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=UD");
            pw.println("node[shape=box]");
            pw.println("concentrate=true");
            pw.println(act.getCodigoInterno());
            pw.println("}");
        } catch (IOException e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
        try {
            String[] cmd = new String[5];
            cmd[0] = "dot";
            cmd[1] = "-Tpng";
            cmd[2] = "./src/Arboles_201908335/" +nombre + ".dot";
            cmd[3] = "-o";
            cmd[4] = "./src/Arboles_201908335/" +nombre + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (IOException ex) {
        } finally {
        }
    }
    
    public static void graficarAFND(nodo act, String nombre){
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("./src/AFND_201908335/" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=LR;");
            pw.println("node [shape = circle];");
            pw.println(act.hizq.getAFND());
            pw.println("}");
        } catch (IOException e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
        try {
            String[] cmd = new String[5];
            cmd[0] = "dot";
            cmd[1] = "-Tpng";
            cmd[2] = "./src/AFND_201908335/" +nombre + ".dot";
            cmd[3] = "-o";
            cmd[4] = "./src/AFND_201908335/" +nombre + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (IOException ex) {
        } finally {
        }
    }
    
    public static void generarTS(nodo act,String nombre){
        for (int x = 0;x < (Hojas.size()-1);x++){
            Siguientes.add(".");
        }        
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("./src/Siguientes_201908335/" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println(" graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
            pw.println("node [shape=plain]");
            pw.println("Foo [label=<");
            pw.println("<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
            pw.println("<tr>");
            pw.println("<td>HOJAS</td>");
            pw.println("<td>SIGUIENTES</td>");
            pw.println("</tr>");
            act.getTablaSiguiente();
            for(int i=0;i<Siguientes.size();i++){
                pw.println("<tr>");
                pw.println("<td>"+String.valueOf(i+1)+") "+Hojas.get(i)+"</td>");
                pw.println("<td>"+Siguientes.get(i)+"</td>");
                pw.println("</tr>");
            }
            pw.println("<tr>");
                pw.println("<td>"+Hojas.get(Hojas.size()-1)+"</td>");
                pw.println("<td>---</td>");
                pw.println("</tr>");
            pw.println("</table>>];");
            pw.println("}");
        } catch (IOException e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
        try {
            String[] cmd = new String[5];
            cmd[0] = "dot";
            cmd[1] = "-Tpng";
            cmd[2] = "./src/Siguientes_201908335/" +nombre + ".dot";
            cmd[3] = "-o";
            cmd[4] = "./src/Siguientes_201908335/" +nombre + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (IOException ex) {
        } finally {
        }
    }
    
    public static void generarTran(String nombre){
        int estado = 1;
        Estados.add("1");
        EstadosL.add("S0");
        for (int x=0;x<Siguientes.size();x++){
            boolean bandera = false;
            for (int y=0;y<Estados.size();y++){
                bandera = !Siguientes.get(x).equals(Estados.get(y));
            }
            if (bandera){Estados.add(Siguientes.get(x)); EstadosL.add("S"+String.valueOf(estado)); estado++;}
        }
        Terminales.add(Hojas.get(0));
        for (int x=0;x<Hojas.size();x++){
            boolean bandera = false;
            for (int y=0;y<Terminales.size();y++){
                if (Hojas.get(x).equals("#")){bandera = false; break;}
                else if (!Hojas.get(x).equals(Terminales.get(y))){bandera = true;} 
                else{bandera = false; break;}
            }
            if (bandera){Terminales.add(Hojas.get(x));}
        }
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("./src/Transiciones_201908335/" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println(" graph [pad=\"0.5\", nodesep=\"0.5\", ranksep=\"2\"];");
            pw.println("node [shape=plain]");
            pw.println("Foo [label=<");
            pw.println("<table border=\"0\" cellborder=\"1\" cellspacing=\"0\">");
            pw.println("<tr>");
            pw.println("<td>ESTADO</td>");
            for(int x=0;x<Terminales.size();x++){
                pw.println("<td>"+Terminales.get(x)+"</td>");
            }
            pw.println("</tr>");
            Mueves = new String[Estados.size()][Terminales.size()];
            for(int i=0;i<(Estados.size());i++){
                for(int j=0;j<Terminales.size();j++){
                    Mueves[i][j] = "---";
                }
            }
            Mueves[0][0] = "S1";
            for(int i=1;i<Estados.size();i++){
                String[] trans = Estados.get(i).split(",");
                for (String valor: trans){
                    if (Hojas.size()!=Integer.valueOf(valor)){
                        int pos = posicion(valor);
                        for(int j=0;j<Terminales.size();j++){
                            if (Hojas.get(Integer.valueOf(valor)-1).equals(Terminales.get(j))){
                                Mueves[i][j] = EstadosL.get(pos);
                                break;
                            }
                        }
                        
                    }
                }
            }
            for(int i=0;i<(Mueves.length);i++){
                pw.println("<tr>");
                pw.println("<td>"+EstadosL.get(i)+"{"+Estados.get(i)+"}</td>");
                for (String Mueve : Mueves[i]) {
                    pw.println("<td>" + Mueve + "</td>");
                }
                pw.println("</tr>");
            }
            pw.println("</table>>];");
            pw.println("}");
        } catch (IOException e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
        try {
            String[] cmd = new String[5];
            cmd[0] = "dot";
            cmd[1] = "-Tpng";
            cmd[2] = "./src/Transiciones_201908335/" +nombre + ".dot";
            cmd[3] = "-o";
            cmd[4] = "./src/Transiciones_201908335/" +nombre + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (IOException ex) {
        } finally {
        }
    }
    
    public static int posicion(String s){
        int pos = 0;
        for(int x = 0;x<Estados.size();x++){
            if (Estados.get(x).equals(Siguientes.get(Integer.valueOf(s)-1))){pos = x; break;}
        }
        return pos;
    }
    
    public static void generarAFD(String nombre){
    FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("./src/AFD_201908335/" + nombre + ".dot");
            pw = new PrintWriter(fichero);
            pw.println("digraph G{");
            pw.println("rankdir=LR;");
            String aceptacion = EstadosL.get(EstadosL.size()-1);
            pw.println("node [shape = doublecircle];"+ aceptacion+";");
            pw.println("node [shape = circle];");
            for (int x=0;x<(EstadosL.size()-1);x++){
                pw.println("nodo"+String.valueOf(x)+"[label=\""+EstadosL.get(x)+"\"];");
            }
            for (int x=0;x<Mueves.length;x++){
                for (int y=0;y<Mueves[x].length;y++){
                    if (!Mueves[x][y].equals("---")){
                        if (Mueves[x][y].equals(aceptacion)){
                            if(x==(EstadosL.size()-1)){
                                pw.println(aceptacion+"->"+aceptacion+"[ label = \""+Terminales.get(y)+"\"];");
                            }else{
                                pw.println("nodo"+String.valueOf(x)+"->"+aceptacion+"[ label = \""+Terminales.get(y)+"\"];");
                            }
                            
                        }else{
                            int pos = obtenerNodo(Mueves[x][y]);
                            pw.println("nodo"+String.valueOf(x)+"->nodo"+String.valueOf(pos)+"[ label = \""+Terminales.get(y)+"\"];");
                        }
                    }
                }
            }
            pw.println("}");
        } catch (IOException e) {
            System.out.println("error, no se realizo el archivo");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (IOException e2) {
            }
        }
        try {
            String[] cmd = new String[5];
            cmd[0] = "dot";
            cmd[1] = "-Tpng";
            cmd[2] = "./src/AFD_201908335/" +nombre + ".dot";
            cmd[3] = "-o";
            cmd[4] = "./src/AFD_201908335/" +nombre + ".png";
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
        } catch (IOException ex) {
        } finally {
        }
    }
    
    public static int obtenerNodo(String s){
        int pos = 0;
        for (int x = 0;x<EstadosL.size();x++){
            if(EstadosL.get(x).equals(s)){pos = x; break;}
        }
        return pos;
    }
    
    public static void generarHTML() throws IOException{
        FileWriter fichero = null;
        PrintWriter pw;
        try {
            fichero = new FileWriter("./src/Errores_201908335/errores.html");
            pw = new PrintWriter(fichero);
            //comenzamos a escribir el html
            pw.println("<html>");
            pw.println("<head><title>REPORTE DE ERRORES</title></head>");
            pw.println("<body>");
            pw.println("<div align=\"center\">");
            pw.println("<h1>Reporte de Errores</h1>");
            pw.println("<br></br>");
            pw.println("<table border=1>");
            pw.println("<tr>");
            pw.println("<td bgcolor=green>TIPO</td>");
            pw.println("<td bgcolor=green>VALOR</td>");
            pw.println("<td bgcolor=green>FILA</td>");
            pw.println("<td bgcolor=green>COLUMNA</td>");
            pw.println("</tr>");
            for(int i=0;i<Errores.size();i++){
                pw.println("<tr>");
                pw.println("<td>"+Errores.get(i).getTipoError()+"</td>");
                pw.println("<td>"+Errores.get(i).getValorError()+"</td>");
                pw.println("<td>"+Errores.get(i).getFila()+"</td>");
                pw.println("<td>"+Errores.get(i).getColumna()+"</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</div");
            pw.println("</body>");
            pw.println("</html>");
        } catch (IOException e) {
        }finally{
            if(null!=fichero){
                    fichero.close();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnGAutomatas;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
