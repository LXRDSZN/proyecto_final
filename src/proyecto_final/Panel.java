/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto_final;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivang
 */
public class Panel extends javax.swing.JFrame {


    private int puntajeEspanol = 0;
    private int puntajeMatematicas = 0;
    private int puntajeIngles = 0;
    private int puntajeHumanidades = 0;
    private int puntajeEcosistemas = 0;
    private DefaultListModel<String> modeloLista;

    
private Timer timerEspanol, timerMatematicas, timerIngles, timerHumanidades, timerEcosistemas;
private int horasEspanol = 0, minutosEspanol = 0, segundosEspanol = 0;
private int horasMatematicas = 0, minutosMatematicas = 0, segundosMatematicas = 0;
private int horasIngles = 0, minutosIngles = 0, segundosIngles = 0;
private int horasHumanidades = 0, minutosHumanidades = 0, segundosHumanidades = 0;
private int horasEcosistemas = 0, minutosEcosistemas = 0, segundosEcosistemas = 0;




    


    

    /**
     * Creates new form Panel
     */
    public Panel() {
        inicializarTimers();
        initComponents();
        // Asegúrate de inicializar el modeloLista en el constructor
        modeloLista = new DefaultListModel<>();
        jList1.setModel(modeloLista);  // Asignar el modelo al JList

    }
    
    
    private void inicializarTimers() {
    // Timer para Español
    timerEspanol = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundosEspanol++;
            if (segundosEspanol == 60) {
                segundosEspanol = 0;
                minutosEspanol++;
            }
            if (minutosEspanol == 60) {
                minutosEspanol = 0;
                horasEspanol++;
            }
            cronometro.setText(String.format("%02d:%02d:%02d", horasEspanol, minutosEspanol, segundosEspanol));
        }
    });

    // Timer para Matemáticas
    timerMatematicas = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundosMatematicas++;
            if (segundosMatematicas == 60) {
                segundosMatematicas = 0;
                minutosMatematicas++;
            }
            if (minutosMatematicas == 60) {
                minutosMatematicas = 0;
                horasMatematicas++;
            }
            cronometro2.setText(String.format("%02d:%02d:%02d", horasMatematicas, minutosMatematicas, segundosMatematicas));
        }
    });

    // Timer para Inglés
    timerIngles = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundosIngles++;
            if (segundosIngles == 60) {
                segundosIngles = 0;
                minutosIngles++;
            }
            if (minutosIngles == 60) {
                minutosIngles = 0;
                horasIngles++;
            }
            cronometro3.setText(String.format("%02d:%02d:%02d", horasIngles, minutosIngles, segundosIngles));
        }
    });

    // Timer para Humanidades
    timerHumanidades = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundosHumanidades++;
            if (segundosHumanidades == 60) {
                segundosHumanidades = 0;
                minutosHumanidades++;
            }
            if (minutosHumanidades == 60) {
                minutosHumanidades = 0;
                horasHumanidades++;
            }
            cronometro4.setText(String.format("%02d:%02d:%02d", horasHumanidades, minutosHumanidades, segundosHumanidades));
        }
    });

    // Timer para Ecosistemas
    timerEcosistemas = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundosEcosistemas++;
            if (segundosEcosistemas == 60) {
                segundosEcosistemas = 0;
                minutosEcosistemas++;
            }
            if (minutosEcosistemas == 60) {
                minutosEcosistemas = 0;
                horasEcosistemas++;
            }
            cronometro5.setText(String.format("%02d:%02d:%02d", horasEcosistemas, minutosEcosistemas, segundosEcosistemas));
        }
    });
}

    
    
    
    private void actualizarPuntajeEnTabla(String materia, double puntaje) {
    DefaultTableModel model = (DefaultTableModel) TablaCalif.getModel();
    int filas = model.getRowCount();

    // Recorremos las filas para encontrar la materia correspondiente
    for (int i = 0; i < filas; i++) {
        String materiaActual = model.getValueAt(i, 0).toString(); // Obtener la materia de la primera columna
        if (materiaActual.equals(materia)) {
            // Actualizamos la calificación en la segunda columna
            model.setValueAt(puntaje, i, 1);
            break;
        }
    }
}
    
    
    
    private double calcularPromedio() {
    DefaultTableModel model = (DefaultTableModel) TablaCalif.getModel();
    int filas = model.getRowCount();
    double suma = 0;
    int cantidadMaterias = 0;

    // Recorremos las filas de la tabla
    for (int i = 0; i < filas; i++) {
        // Obtener la calificación de la columna 1 (la columna de calificación)
        Object calificacionObj = model.getValueAt(i, 1);

        // Verificar que la calificación sea un número y no un valor nulo o vacío
        if (calificacionObj != null && !calificacionObj.toString().isEmpty()) {
            try {
                double calificacion = Double.parseDouble(calificacionObj.toString());
                suma += calificacion; // Sumar la calificación
                cantidadMaterias++; // Aumentar el contador de materias
            } catch (NumberFormatException e) {
                // Si no es un número, simplemente lo ignoramos
                System.out.println("Valor no numérico en la fila " + i + ": " + calificacionObj);
            }
        }
    }

    // Calcular el promedio
    if (cantidadMaterias > 0) {
        return suma / cantidadMaterias;
    } else {
        return 0; // Si no hay materias con calificación, el promedio es 0
    }
}
    
    
    private void mostrarPromedio() {
    double promedio = calcularPromedio();
    LabelPromedio.setText(String.format("%.2f", promedio));
     // Ahora actualizamos el slider según el promedio
        int valorSlider = (int) Math.round(promedio);  // Redondeamos el promedio a un valor entero
        jSlider1.setValue(valorSlider);  // Establecemos el valor del slider
}


    
    

    
    private void verificarRespuesta(JCheckBox opcion, JLabel etiquetaRespuesta,  boolean esCorrecta) {
        if (opcion.isSelected()) { // Verifica si el CheckBox está seleccionado
            if (esCorrecta) {
                etiquetaRespuesta.setForeground(Color.GREEN); // Cambia a verde
                puntajeEspanol++;
                puntajeMatematicas++;
                puntajeIngles++;
                puntajeHumanidades++;
                puntajeEcosistemas++;
            } else {
                etiquetaRespuesta.setForeground(Color.RED); // Cambia a rojo
            }
        }
     }
    
    
    private void verificarRespuestaAbierta(JTextField campoRespuesta, JLabel etiquetaRespuesta, String respuestaCorrecta) {
        String respuestaUsuario = campoRespuesta.getText().trim(); // Obtiene la respuesta del usuario y elimina espacios en blanco al inicio y final
    
        if (respuestaUsuario.equalsIgnoreCase(respuestaCorrecta)) { // Compara ignorando mayúsculas y minúsculas
            etiquetaRespuesta.setForeground(Color.GREEN); // Cambia el texto a verde
            puntajeEspanol++;
            puntajeMatematicas++;
            puntajeIngles++;
            puntajeHumanidades++;
            puntajeEcosistemas++;
    } else {
        etiquetaRespuesta.setForeground(Color.RED); // Cambia el texto a rojo
    }
}

    
private void manejarMateriaSeleccionada(JComboBox<String> comboMaterias) {
    // Obtener la materia seleccionada
    String materiaSeleccionada = (String) comboMaterias.getSelectedItem();

    // Verificar si hay una selección
    if (materiaSeleccionada != null) {
        switch (materiaSeleccionada) {
            case "Español":
                realizarAccionEspanol();
                break;
            case "Matematicas":
                realizarAccionMatematicas();
                break;
            case "Ingles":
                realizarAccionIngles();
                break;
            case "Humanidades":
                realizarAccionHumanidades();
                break;
            case "Ecosistemas":
                realizarAccionEcosistemas();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Materia no reconocida.");
                break;
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una materia.");
    }
}

// Métodos para realizar acciones específicas
private void realizarAccionEspanol() {
    new Espanol().setVisible(true);
    this.dispose();
    // Aquí agrega lo que debe ocurrir para Español
}

private void realizarAccionMatematicas() {
    new Matematicas().setVisible(true);
    this.dispose();
    // Aquí agrega lo que debe ocurrir para Matemáticas
}

private void realizarAccionIngles() {
    new Ingles().setVisible(true);
    this.dispose();
    // Aquí agrega lo que debe ocurrir para Inglés
}

private void realizarAccionHumanidades() {
    new Humanidades().setVisible(true);
    this.dispose();

    // Aquí agrega lo que debe ocurrir para Humanidades
}

private void realizarAccionEcosistemas() {
    new Ecosistemas().setVisible(true);
    this.dispose();
    // Aquí agrega lo que debe ocurrir para Ecosistemas
}

    
private void detenerTimers() {
    timerEspanol.stop();
    timerMatematicas.stop();
    timerIngles.stop();
    timerHumanidades.stop();
    timerEcosistemas.stop();
}
        

private int obtenerSegundosTotales() {
    // Dependiendo de la materia seleccionada, calcular el tiempo total en segundos
    if (tabla_panel.getSelectedIndex() == 0) {
        return horasEspanol * 3600 + minutosEspanol * 60 + segundosEspanol;
    } else if (tabla_panel.getSelectedIndex() == 1) {
        return horasMatematicas * 3600 + minutosMatematicas * 60 + segundosMatematicas;
    } else if (tabla_panel.getSelectedIndex() == 2) {
        return horasIngles * 3600 + minutosIngles * 60 + segundosIngles;
    } else if (tabla_panel.getSelectedIndex() == 3) {
        return horasHumanidades * 3600 + minutosHumanidades * 60 + segundosHumanidades;
    } else if (tabla_panel.getSelectedIndex() == 4) {
        return horasEcosistemas * 3600 + minutosEcosistemas * 60 + segundosEcosistemas;
    }
    return 0;  // En caso de que no haya una pestaña seleccionada
}


private void manejarEnviar(JLabel labelTiempo) {
    // Detener el Timer correspondiente al cronómetro actual
    int segundosTotales = obtenerSegundosTotales();

    // Verificar si ha pasado más de 1 minuto (60 segundos)
    if (segundosTotales > 60) {
        labelTiempo.setText("Fuera de tiempo");
        labelTiempo.setForeground(Color.RED);  // Cambiar a rojo
    } else {
        labelTiempo.setText("A tiempo");
        labelTiempo.setForeground(Color.GREEN);  // Cambiar a verde
    }

    // Detener el Timer
    detenerTimers();
}
        
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        espanol1 = new javax.swing.ButtonGroup();
        espanol7 = new javax.swing.ButtonGroup();
        espanol8 = new javax.swing.ButtonGroup();
        ingles1 = new javax.swing.ButtonGroup();
        EcoR5 = new javax.swing.ButtonGroup();
        EcoR7 = new javax.swing.ButtonGroup();
        EcoR8 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabla_panel = new javax.swing.JTabbedPane();
        Panel_examen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCalif = new javax.swing.JTable();
        CalcularPromBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LabelPromedio = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Español = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        espanolP1 = new javax.swing.JLabel();
        espanolP2 = new javax.swing.JLabel();
        espanolP4 = new javax.swing.JLabel();
        espanolP3 = new javax.swing.JLabel();
        espanolP5 = new javax.swing.JLabel();
        espanolP7 = new javax.swing.JLabel();
        espanolP6 = new javax.swing.JLabel();
        espanolP8 = new javax.swing.JLabel();
        espanolP9 = new javax.swing.JLabel();
        espanolP10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        mesa = new javax.swing.JCheckBox();
        azul = new javax.swing.JCheckBox();
        hermoso = new javax.swing.JCheckBox();
        resEspanolp2 = new javax.swing.JTextField();
        resEspanolp4 = new javax.swing.JTextField();
        resEspanolp3 = new javax.swing.JTextField();
        resEspanolp5 = new javax.swing.JTextField();
        transitivo = new javax.swing.JCheckBox();
        intransitivo = new javax.swing.JCheckBox();
        reflexivo = new javax.swing.JCheckBox();
        metafora = new javax.swing.JCheckBox();
        simil = new javax.swing.JCheckBox();
        personificacion = new javax.swing.JCheckBox();
        resEspanolp6 = new javax.swing.JTextField();
        resEspanolp9 = new javax.swing.JTextField();
        resEspanolp10 = new javax.swing.JTextField();
        cronometro = new javax.swing.JLabel();
        EnviarButtonEspanol = new javax.swing.JButton();
        LabelPuntaje = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LabelTiempo = new javax.swing.JLabel();
        Matematicas = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        matP1 = new javax.swing.JLabel();
        matP2 = new javax.swing.JLabel();
        matP4 = new javax.swing.JLabel();
        matP3 = new javax.swing.JLabel();
        matP5 = new javax.swing.JLabel();
        matP7 = new javax.swing.JLabel();
        matP6 = new javax.swing.JLabel();
        matP8 = new javax.swing.JLabel();
        matP9 = new javax.swing.JLabel();
        matP10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        matRes2 = new javax.swing.JTextField();
        matRes4 = new javax.swing.JTextField();
        matRes3 = new javax.swing.JTextField();
        matRes5 = new javax.swing.JTextField();
        matRes6 = new javax.swing.JTextField();
        matRes9 = new javax.swing.JTextField();
        matRes10 = new javax.swing.JTextField();
        matRes1 = new javax.swing.JTextField();
        matRes8 = new javax.swing.JTextField();
        matRes7 = new javax.swing.JTextField();
        cronometro2 = new javax.swing.JLabel();
        MatenviarBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        PuntajeMatLbl = new javax.swing.JLabel();
        LabelTiempo1 = new javax.swing.JLabel();
        Ingles = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel9 = new javax.swing.JPanel();
        inglesP1 = new javax.swing.JLabel();
        inglesP2 = new javax.swing.JLabel();
        inglesP3 = new javax.swing.JLabel();
        inglesP7 = new javax.swing.JLabel();
        inglesP6 = new javax.swing.JLabel();
        inglesP8 = new javax.swing.JLabel();
        inglesP9 = new javax.swing.JLabel();
        inglesP10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        childs = new javax.swing.JCheckBox();
        children = new javax.swing.JCheckBox();
        child = new javax.swing.JCheckBox();
        inglesRes2 = new javax.swing.JTextField();
        inglesRes4 = new javax.swing.JTextField();
        inglesRes3 = new javax.swing.JTextField();
        inglesRes5 = new javax.swing.JTextField();
        inglesRes6 = new javax.swing.JTextField();
        inglesRes10 = new javax.swing.JTextField();
        inglesRes7 = new javax.swing.JTextField();
        inglesRes8 = new javax.swing.JTextField();
        inglesRes9 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        inglesP5 = new javax.swing.JLabel();
        inglesP4 = new javax.swing.JLabel();
        cronometro3 = new javax.swing.JLabel();
        inglesEnviarBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PuntajeInglesLabel = new javax.swing.JLabel();
        LabelTiempo2 = new javax.swing.JLabel();
        Humanidades = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jPanel12 = new javax.swing.JPanel();
        humanidadesP1 = new javax.swing.JLabel();
        humanidadesP2 = new javax.swing.JLabel();
        humanidadesP4 = new javax.swing.JLabel();
        humanidadesP3 = new javax.swing.JLabel();
        humanidadesP5 = new javax.swing.JLabel();
        humanidadesP7 = new javax.swing.JLabel();
        humanidadesP6 = new javax.swing.JLabel();
        humanidadesP8 = new javax.swing.JLabel();
        humanidadesP9 = new javax.swing.JLabel();
        humanidadesP10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        humanidadesR2 = new javax.swing.JTextField();
        humanidadesR3 = new javax.swing.JTextField();
        humanidadesR7 = new javax.swing.JTextField();
        humanidadesR9 = new javax.swing.JTextField();
        humanidadesR8 = new javax.swing.JTextField();
        humanidadesR10 = new javax.swing.JTextField();
        humanidadesR5 = new javax.swing.JTextField();
        humanidadesR1 = new javax.swing.JTextField();
        humanidadesR4 = new javax.swing.JTextField();
        humanidadesR6 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        cronometro4 = new javax.swing.JLabel();
        humanidadesEnviarBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        humanidadesPuntajeLbl = new javax.swing.JLabel();
        LabelTiempo3 = new javax.swing.JLabel();
        Ecosistemas = new javax.swing.JPanel();
        jSplitPane5 = new javax.swing.JSplitPane();
        jPanel15 = new javax.swing.JPanel();
        EcoP1 = new javax.swing.JLabel();
        EcoP2 = new javax.swing.JLabel();
        EcoP4 = new javax.swing.JLabel();
        EcoP3 = new javax.swing.JLabel();
        EcoP5 = new javax.swing.JLabel();
        EcoP7 = new javax.swing.JLabel();
        EcoP6 = new javax.swing.JLabel();
        EcoP8 = new javax.swing.JLabel();
        EcoP9 = new javax.swing.JLabel();
        EcoP10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        EcoR2 = new javax.swing.JTextField();
        EcoR4 = new javax.swing.JTextField();
        EcoR3 = new javax.swing.JTextField();
        EcoR6 = new javax.swing.JTextField();
        EcoR9 = new javax.swing.JTextField();
        EcoR10 = new javax.swing.JTextField();
        conejo = new javax.swing.JCheckBox();
        leon = new javax.swing.JCheckBox();
        hormiga = new javax.swing.JCheckBox();
        desierto = new javax.swing.JCheckBox();
        bosqueTropical = new javax.swing.JCheckBox();
        tundra = new javax.swing.JCheckBox();
        EcoR1 = new javax.swing.JTextField();
        competencia = new javax.swing.JCheckBox();
        simbiosis = new javax.swing.JCheckBox();
        depredadorPresa = new javax.swing.JCheckBox();
        cronometro5 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        LabelTiempo4 = new javax.swing.JLabel();
        ecosistemasPuntajeLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Selección De Materias");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -5, -1, 40));

        tabla_panel.setBackground(new java.awt.Color(255, 255, 255));
        tabla_panel.setForeground(new java.awt.Color(51, 51, 51));
        tabla_panel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabla_panelStateChanged(evt);
            }
        });

        Panel_examen.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_final/Images/CECYTE_MORELOS-356517594.png"))); // NOI18N
        jLabel2.setLabelFor(tabla_panel);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Infromacion Del Creador ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Introducción de las Materias");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Matematicas", "Ingles", "Humanidades", "Ecosistemas" }));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Ver Calificacion");

        TablaCalif.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Español", null},
                {"Matematicas", null},
                {"Ingles", null},
                {"Humanidades", null},
                {"Ecosistemas", null}
            },
            new String [] {
                "Materias", "Calificacion"
            }
        ));
        TablaCalif.setEnabled(false);
        jScrollPane1.setViewportView(TablaCalif);

        CalcularPromBtn.setBackground(new java.awt.Color(51, 51, 51));
        CalcularPromBtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        CalcularPromBtn.setForeground(new java.awt.Color(255, 255, 255));
        CalcularPromBtn.setText("Calcular");
        CalcularPromBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularPromBtnActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Calificaciòn : ");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Algún comentario");

        LabelPromedio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelPromedio.setText("0");

        jSlider1.setBackground(new java.awt.Color(102, 102, 102));
        jSlider1.setForeground(new java.awt.Color(0, 0, 0));
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(10);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setValue(1);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Calcular la calificaciòn ");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Enviar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_examenLayout = new javax.swing.GroupLayout(Panel_examen);
        Panel_examen.setLayout(Panel_examenLayout);
        Panel_examenLayout.setHorizontalGroup(
            Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_examenLayout.createSequentialGroup()
                .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_examenLayout.createSequentialGroup()
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)))
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalcularPromBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(LabelPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Panel_examenLayout.createSequentialGroup()
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_examenLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_examenLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addGroup(Panel_examenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_examenLayout.createSequentialGroup()
                    .addGap(282, 282, 282)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(354, Short.MAX_VALUE)))
        );
        Panel_examenLayout.setVerticalGroup(
            Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_examenLayout.createSequentialGroup()
                .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_examenLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_examenLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(Panel_examenLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalcularPromBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(31, 31, 31)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(Panel_examenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_examenLayout.createSequentialGroup()
                    .addContainerGap(292, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(192, 192, 192)))
        );

        tabla_panel.addTab("Panel", Panel_examen);

        Español.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(353, 456));

        espanolP1.setForeground(new java.awt.Color(51, 51, 51));
        espanolP1.setText("1: ¿Cuál es un sustantivo?");

        espanolP2.setForeground(new java.awt.Color(51, 51, 51));
        espanolP2.setText("2: ¿Qué tipo de palabra es \"rápidamente\"?");

        espanolP4.setForeground(new java.awt.Color(51, 51, 51));
        espanolP4.setText("4: ¿Qué es un sinónimo de \"feliz\"?");

        espanolP3.setForeground(new java.awt.Color(51, 51, 51));
        espanolP3.setText("3: ¿Cuál es una palabra grave?");

        espanolP5.setForeground(new java.awt.Color(51, 51, 51));
        espanolP5.setText("5: ¿Qué tipo de oración es \"¡Qué bonito día!\"?");

        espanolP7.setForeground(new java.awt.Color(51, 51, 51));
        espanolP7.setText("7: ¿Qué tipo de verbo es \"correr\"?");

        espanolP6.setForeground(new java.awt.Color(51, 51, 51));
        espanolP6.setText("6: ¿Qué significa la palabra \"homónimos\"?");

        espanolP8.setForeground(new java.awt.Color(51, 51, 51));
        espanolP8.setText("8: ¿Qué  literaria compara dos elementos usando \"como\"?");

        espanolP9.setForeground(new java.awt.Color(51, 51, 51));
        espanolP9.setText("9: ¿Qué tipo de tilde tiene la palabra \"canción\"?");

        espanolP10.setForeground(new java.awt.Color(51, 51, 51));
        espanolP10.setText("10:¿Qué es una fábula?");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(espanolP10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(espanolP8)
                    .addComponent(espanolP9)
                    .addComponent(espanolP1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(espanolP1)
                .addGap(28, 28, 28)
                .addComponent(espanolP2)
                .addGap(28, 28, 28)
                .addComponent(espanolP3)
                .addGap(28, 28, 28)
                .addComponent(espanolP4)
                .addGap(28, 28, 28)
                .addComponent(espanolP5)
                .addGap(28, 28, 28)
                .addComponent(espanolP6)
                .addGap(29, 29, 29)
                .addComponent(espanolP7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(espanolP8)
                .addGap(29, 29, 29)
                .addComponent(espanolP9)
                .addGap(18, 18, 18)
                .addComponent(espanolP10)
                .addGap(30, 30, 30))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mesa.setBackground(new java.awt.Color(255, 255, 255));
        espanol1.add(mesa);
        mesa.setForeground(new java.awt.Color(51, 51, 51));
        mesa.setText("Mesa ");
        mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesaActionPerformed(evt);
            }
        });

        espanol1.add(azul);
        azul.setText("Azul");
        azul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                azulActionPerformed(evt);
            }
        });

        espanol1.add(hermoso);
        hermoso.setText("Hermoso");

        resEspanolp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp2ActionPerformed(evt);
            }
        });

        resEspanolp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp4ActionPerformed(evt);
            }
        });

        resEspanolp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp3ActionPerformed(evt);
            }
        });

        resEspanolp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp5ActionPerformed(evt);
            }
        });

        espanol7.add(transitivo);
        transitivo.setText("Transitivo");

        espanol7.add(intransitivo);
        intransitivo.setText("Intransitivo");
        intransitivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intransitivoActionPerformed(evt);
            }
        });

        espanol7.add(reflexivo);
        reflexivo.setText("Reflexivo");

        espanol8.add(metafora);
        metafora.setText("Metáfora");

        espanol8.add(simil);
        simil.setText(" Símil");

        espanol8.add(personificacion);
        personificacion.setText("Personificación");

        resEspanolp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp6ActionPerformed(evt);
            }
        });

        resEspanolp9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp9ActionPerformed(evt);
            }
        });

        resEspanolp10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resEspanolp10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resEspanolp2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(azul, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(hermoso, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(personificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(intransitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simil, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(metafora, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reflexivo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addComponent(resEspanolp3)
                    .addComponent(resEspanolp4)
                    .addComponent(resEspanolp6)
                    .addComponent(resEspanolp5)
                    .addComponent(resEspanolp9)
                    .addComponent(resEspanolp10)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesa)
                    .addComponent(azul)
                    .addComponent(hermoso))
                .addGap(18, 18, 18)
                .addComponent(resEspanolp2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resEspanolp3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(resEspanolp4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resEspanolp5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resEspanolp6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transitivo)
                    .addComponent(intransitivo)
                    .addComponent(reflexivo))
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personificacion)
                    .addComponent(simil)
                    .addComponent(metafora))
                .addGap(18, 18, 18)
                .addComponent(resEspanolp9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resEspanolp10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel6);

        cronometro.setText("00:00:00");

        EnviarButtonEspanol.setBackground(new java.awt.Color(51, 51, 51));
        EnviarButtonEspanol.setForeground(new java.awt.Color(255, 255, 255));
        EnviarButtonEspanol.setText("Enviar");
        EnviarButtonEspanol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarButtonEspanolActionPerformed(evt);
            }
        });

        LabelPuntaje.setText("0");

        jLabel7.setText("Puntaje: ");

        LabelTiempo.setText("-------");

        javax.swing.GroupLayout EspañolLayout = new javax.swing.GroupLayout(Español);
        Español.setLayout(EspañolLayout);
        EspañolLayout.setHorizontalGroup(
            EspañolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EspañolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EspañolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                    .addGroup(EspañolLayout.createSequentialGroup()
                        .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(LabelPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(EnviarButtonEspanol, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        EspañolLayout.setVerticalGroup(
            EspañolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EspañolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EspañolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnviarButtonEspanol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cronometro)
                    .addComponent(LabelPuntaje)
                    .addComponent(jLabel7)
                    .addComponent(LabelTiempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabla_panel.addTab("Español", Español);

        Matematicas.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(353, 456));

        matP1.setForeground(new java.awt.Color(51, 51, 51));
        matP1.setText("1: ¿Cuál es el resultado de  8 + 7?");

        matP2.setForeground(new java.awt.Color(51, 51, 51));
        matP2.setText("2: ¿Cuánto es  9 × 6 ?");

        matP4.setForeground(new java.awt.Color(51, 51, 51));
        matP4.setText("4: ¿Cuánto es  15 − 9 ?");

        matP3.setForeground(new java.awt.Color(51, 51, 51));
        matP3.setText("3: ¿Cuál es la raíz cuadrada de 49?");

        matP5.setForeground(new java.awt.Color(51, 51, 51));
        matP5.setText("5: ¿Cuánto es  3  ** 2 ?");

        matP7.setForeground(new java.awt.Color(51, 51, 51));
        matP7.setText("7: Un triangulo tiene dos lados iguales, ¿cómo se llama?");

        matP6.setForeground(new java.awt.Color(51, 51, 51));
        matP6.setText("6: ¿Cuál es el valor de  8 / 2 ?");

        matP8.setForeground(new java.awt.Color(51, 51, 51));
        matP8.setText("8: ¿Cuánto es  25 % de 100?");

        matP9.setForeground(new java.awt.Color(51, 51, 51));
        matP9.setText("9: Si  𝑥 + 3 = 7 , ¿cuánto vale  𝑥 ?");

        matP10.setForeground(new java.awt.Color(51, 51, 51));
        matP10.setText("10: ¿Cuánto es  10**0 ?");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matP7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matP10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP8)
                            .addComponent(matP1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP9, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matP3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(matP1)
                .addGap(18, 18, 18)
                .addComponent(matP2)
                .addGap(28, 28, 28)
                .addComponent(matP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(matP4)
                .addGap(32, 32, 32)
                .addComponent(matP5)
                .addGap(27, 27, 27)
                .addComponent(matP6)
                .addGap(18, 18, 18)
                .addComponent(matP7)
                .addGap(18, 18, 18)
                .addComponent(matP8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(matP9)
                .addGap(28, 28, 28)
                .addComponent(matP10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jSplitPane2.setLeftComponent(jPanel4);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSplitPane2.setRightComponent(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        matRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes2ActionPerformed(evt);
            }
        });

        matRes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes4ActionPerformed(evt);
            }
        });

        matRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes3ActionPerformed(evt);
            }
        });

        matRes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes5ActionPerformed(evt);
            }
        });

        matRes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes6ActionPerformed(evt);
            }
        });

        matRes9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes9ActionPerformed(evt);
            }
        });

        matRes10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes10ActionPerformed(evt);
            }
        });

        matRes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes1ActionPerformed(evt);
            }
        });

        matRes8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes8ActionPerformed(evt);
            }
        });

        matRes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matRes7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matRes2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(matRes3)
                    .addComponent(matRes4)
                    .addComponent(matRes6)
                    .addComponent(matRes5)
                    .addComponent(matRes9)
                    .addComponent(matRes10)
                    .addComponent(matRes1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(matRes8)
                    .addComponent(matRes7)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matRes1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(matRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matRes4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(matRes5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matRes6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(matRes7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matRes8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(matRes9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(matRes10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(jPanel8);

        cronometro2.setText("00:00:00");

        MatenviarBtn.setBackground(new java.awt.Color(51, 51, 51));
        MatenviarBtn.setForeground(new java.awt.Color(255, 255, 255));
        MatenviarBtn.setText("Enviar");
        MatenviarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatenviarBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Puntaje:");

        PuntajeMatLbl.setText("0");

        LabelTiempo1.setText("----------------");

        javax.swing.GroupLayout MatematicasLayout = new javax.swing.GroupLayout(Matematicas);
        Matematicas.setLayout(MatematicasLayout);
        MatematicasLayout.setHorizontalGroup(
            MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatematicasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cronometro2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(LabelTiempo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PuntajeMatLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(MatenviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MatematicasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        MatematicasLayout.setVerticalGroup(
            MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MatematicasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cronometro2)
                        .addComponent(LabelTiempo1))
                    .addGroup(MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MatenviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(PuntajeMatLbl)))
                .addContainerGap(467, Short.MAX_VALUE))
            .addGroup(MatematicasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MatematicasLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        tabla_panel.addTab("Matemáticas", Matematicas);

        Ingles.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setForeground(new java.awt.Color(51, 51, 51));
        jPanel9.setPreferredSize(new java.awt.Dimension(353, 456));

        inglesP1.setForeground(new java.awt.Color(51, 51, 51));
        inglesP1.setText("1: What is the plural form of \"child\"?");

        inglesP2.setForeground(new java.awt.Color(51, 51, 51));
        inglesP2.setText("2: What does \"hello\" mean in Spanish? ");

        inglesP3.setForeground(new java.awt.Color(51, 51, 51));
        inglesP3.setText("3: What is the correct translation of \"I am happy\"? ");

        inglesP7.setForeground(new java.awt.Color(51, 51, 51));
        inglesP7.setText("7: How do you say \"rojo\" in English? ");

        inglesP6.setForeground(new java.awt.Color(51, 51, 51));
        inglesP6.setText("6: What does \"big\" mean? ");

        inglesP8.setForeground(new java.awt.Color(51, 51, 51));
        inglesP8.setText("8: What is the opposite of \"happy\"? ");

        inglesP9.setForeground(new java.awt.Color(51, 51, 51));
        inglesP9.setText("9: How do you say \"ventana\" in English? ");

        inglesP10.setForeground(new java.awt.Color(51, 51, 51));
        inglesP10.setText("10: Which is a correct synonym for \"beautiful\"? ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inglesP8)
                    .addComponent(inglesP9, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inglesP1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inglesP10)
                    .addComponent(inglesP7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inglesP6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inglesP3)
                    .addComponent(inglesP2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(inglesP1)
                .addGap(29, 29, 29)
                .addComponent(inglesP2)
                .addGap(18, 18, 18)
                .addComponent(inglesP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(inglesP6)
                .addGap(29, 29, 29)
                .addComponent(inglesP7)
                .addGap(28, 28, 28)
                .addComponent(inglesP8)
                .addGap(29, 29, 29)
                .addComponent(inglesP9)
                .addGap(28, 28, 28)
                .addComponent(inglesP10)
                .addGap(20, 20, 20))
        );

        jSplitPane3.setLeftComponent(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        childs.setBackground(new java.awt.Color(255, 255, 255));
        ingles1.add(childs);
        childs.setForeground(new java.awt.Color(51, 51, 51));
        childs.setText("Childs ");
        childs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childsActionPerformed(evt);
            }
        });

        ingles1.add(children);
        children.setText("Children ");
        children.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childrenActionPerformed(evt);
            }
        });

        ingles1.add(child);
        child.setText("Child");

        inglesRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes2ActionPerformed(evt);
            }
        });

        inglesRes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes4ActionPerformed(evt);
            }
        });

        inglesRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes3ActionPerformed(evt);
            }
        });

        inglesRes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes5ActionPerformed(evt);
            }
        });

        inglesRes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes6ActionPerformed(evt);
            }
        });

        inglesRes10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes10ActionPerformed(evt);
            }
        });

        inglesRes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes7ActionPerformed(evt);
            }
        });

        inglesRes8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes8ActionPerformed(evt);
            }
        });

        inglesRes9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesRes9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(childs, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(children, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(child, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inglesRes10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inglesRes9)
                    .addComponent(inglesRes8)
                    .addComponent(inglesRes7)
                    .addComponent(inglesRes6)
                    .addComponent(inglesRes5)
                    .addComponent(inglesRes4)
                    .addComponent(inglesRes3))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inglesRes2)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(childs)
                    .addComponent(children)
                    .addComponent(child))
                .addGap(18, 18, 18)
                .addComponent(inglesRes2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(inglesRes3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inglesRes4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inglesRes5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inglesRes6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inglesRes7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(inglesRes8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inglesRes9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inglesRes10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField22)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane3.setRightComponent(jPanel10);

        inglesP5.setForeground(new java.awt.Color(51, 51, 51));
        inglesP5.setText("5: Which is the past tense of \"go\"? ");

        inglesP4.setForeground(new java.awt.Color(51, 51, 51));
        inglesP4.setText("4: How do you say \"gato\" in English? ");

        cronometro3.setText("00:00:00");

        inglesEnviarBtn.setBackground(new java.awt.Color(51, 51, 51));
        inglesEnviarBtn.setForeground(new java.awt.Color(255, 255, 255));
        inglesEnviarBtn.setText("Enviar");
        inglesEnviarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inglesEnviarBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Puntaje:");

        PuntajeInglesLabel.setText("0");

        LabelTiempo2.setText("---------------");

        javax.swing.GroupLayout InglesLayout = new javax.swing.GroupLayout(Ingles);
        Ingles.setLayout(InglesLayout);
        InglesLayout.setHorizontalGroup(
            InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InglesLayout.createSequentialGroup()
                .addGroup(InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InglesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inglesP5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inglesP4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 603, Short.MAX_VALUE))
                    .addGroup(InglesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cronometro3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(LabelTiempo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PuntajeInglesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(inglesEnviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InglesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        InglesLayout.setVerticalGroup(
            InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InglesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cronometro3)
                    .addComponent(inglesEnviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(PuntajeInglesLabel)
                    .addComponent(LabelTiempo2))
                .addGap(135, 135, 135)
                .addComponent(inglesP4)
                .addGap(26, 26, 26)
                .addComponent(inglesP5)
                .addContainerGap(276, Short.MAX_VALUE))
            .addGroup(InglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InglesLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        tabla_panel.addTab("Inglés", Ingles);

        Humanidades.setBackground(new java.awt.Color(255, 255, 255));
        Humanidades.setForeground(new java.awt.Color(51, 51, 51));

        jSplitPane4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setForeground(new java.awt.Color(51, 51, 51));
        jPanel12.setPreferredSize(new java.awt.Dimension(353, 456));

        humanidadesP1.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP1.setText("1: ¿Qué filósofo escribió La República? ");

        humanidadesP2.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP2.setText("2: ¿Quién pintó la Mona Lisa? ");

        humanidadesP4.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP4.setText("4: ¿Qué país es conocido como \"la cuna de la democracia\"? ");

        humanidadesP3.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP3.setText("3: ¿En qué siglo cayó el Imperio Romano de Occidente? ");

        humanidadesP5.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP5.setText("5: ¿Quién escribió El Quijote? ");

        humanidadesP7.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP7.setText("7: ¿Qué evento marcó el inicio de la Edad Media? ");

        humanidadesP6.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP6.setText("6: ¿Qué civilización construyó las pirámides de Giza? ");

        humanidadesP8.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP8.setText("8: ¿Qué ciudad fue destruida por la erupción del Vesubio? ");

        humanidadesP9.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP9.setText("8: ¿Quién fue el primer emperador romano? ");

        humanidadesP10.setForeground(new java.awt.Color(51, 51, 51));
        humanidadesP10.setText("10: ¿instrumento de tortura de la Inquisición? ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(humanidadesP8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(humanidadesP10, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(humanidadesP9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(humanidadesP1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(humanidadesP1)
                .addGap(29, 29, 29)
                .addComponent(humanidadesP2)
                .addGap(27, 27, 27)
                .addComponent(humanidadesP3)
                .addGap(18, 18, 18)
                .addComponent(humanidadesP4)
                .addGap(18, 18, 18)
                .addComponent(humanidadesP5)
                .addGap(33, 33, 33)
                .addComponent(humanidadesP6)
                .addGap(27, 27, 27)
                .addComponent(humanidadesP7)
                .addGap(18, 18, 18)
                .addComponent(humanidadesP8, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(humanidadesP9)
                .addGap(26, 26, 26)
                .addComponent(humanidadesP10)
                .addGap(22, 22, 22))
        );

        jSplitPane4.setLeftComponent(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        humanidadesR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR2ActionPerformed(evt);
            }
        });

        humanidadesR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR3ActionPerformed(evt);
            }
        });

        humanidadesR7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR7ActionPerformed(evt);
            }
        });

        humanidadesR9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR9ActionPerformed(evt);
            }
        });

        humanidadesR8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR8ActionPerformed(evt);
            }
        });

        humanidadesR10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR10ActionPerformed(evt);
            }
        });

        humanidadesR5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR5ActionPerformed(evt);
            }
        });

        humanidadesR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR1ActionPerformed(evt);
            }
        });

        humanidadesR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR4ActionPerformed(evt);
            }
        });

        humanidadesR6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesR6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(humanidadesR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(humanidadesR2)
                    .addComponent(humanidadesR3)
                    .addComponent(humanidadesR4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(humanidadesR5)
                    .addComponent(humanidadesR6)
                    .addComponent(humanidadesR7)
                    .addComponent(humanidadesR8)
                    .addComponent(humanidadesR9)
                    .addComponent(humanidadesR10))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(humanidadesR1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(humanidadesR2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humanidadesR3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humanidadesR4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humanidadesR5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humanidadesR6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humanidadesR7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humanidadesR8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(humanidadesR9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(humanidadesR10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jSplitPane4.setRightComponent(jPanel13);

        jLabel59.setText("Aca ira un cronometro");

        cronometro4.setText("00:00:00");

        humanidadesEnviarBtn.setBackground(new java.awt.Color(51, 51, 51));
        humanidadesEnviarBtn.setForeground(new java.awt.Color(255, 255, 255));
        humanidadesEnviarBtn.setText("Enviar");
        humanidadesEnviarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanidadesEnviarBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Puntaje:");

        humanidadesPuntajeLbl.setText("0");

        LabelTiempo3.setText("------------------");

        javax.swing.GroupLayout HumanidadesLayout = new javax.swing.GroupLayout(Humanidades);
        Humanidades.setLayout(HumanidadesLayout);
        HumanidadesLayout.setHorizontalGroup(
            HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HumanidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 871, Short.MAX_VALUE)
                    .addGroup(HumanidadesLayout.createSequentialGroup()
                        .addComponent(cronometro4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(LabelTiempo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(humanidadesPuntajeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(humanidadesEnviarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HumanidadesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel59)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        HumanidadesLayout.setVerticalGroup(
            HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HumanidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cronometro4)
                    .addGroup(HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(humanidadesEnviarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addComponent(humanidadesPuntajeLbl)
                        .addComponent(LabelTiempo3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(HumanidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HumanidadesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel59)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabla_panel.addTab("Humanidades", Humanidades);

        Ecosistemas.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setForeground(new java.awt.Color(51, 51, 51));
        jPanel15.setPreferredSize(new java.awt.Dimension(353, 456));

        EcoP1.setForeground(new java.awt.Color(51, 51, 51));
        EcoP1.setText("1: ¿Permite a las plantas producir su alimento? ");

        EcoP2.setForeground(new java.awt.Color(51, 51, 51));
        EcoP2.setText("2: Ecosistema caracterizado por lluvias y gran biodiversidad");

        EcoP4.setForeground(new java.awt.Color(51, 51, 51));
        EcoP4.setText("4: ¿Cómo se llama el lugar donde vive un organismo? ");

        EcoP3.setForeground(new java.awt.Color(51, 51, 51));
        EcoP3.setText("3: ¿Qué gas producen las plantas durante la fotosíntesis? ");

        EcoP5.setForeground(new java.awt.Color(51, 51, 51));
        EcoP5.setText("5: ¿Qué animal es un depredador? ");

        EcoP7.setForeground(new java.awt.Color(51, 51, 51));
        EcoP7.setText("7: ¿Qué ecosistema tiene inviernos largos y veranos cortos? ");

        EcoP6.setForeground(new java.awt.Color(51, 51, 51));
        EcoP6.setText("6: ¿Qué tipo de agua hay en los ríos? ");

        EcoP8.setForeground(new java.awt.Color(51, 51, 51));
        EcoP8.setText("8: ¿Qué relación existe entre un pez y un tiburón? ");

        EcoP9.setForeground(new java.awt.Color(51, 51, 51));
        EcoP9.setText("9: ¿Qué factor es abiótico? ");

        EcoP10.setForeground(new java.awt.Color(51, 51, 51));
        EcoP10.setText("10: Ecosistema  quetiene suelo arenosos y escasez de agua ");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(EcoP7, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EcoP5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EcoP6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EcoP8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EcoP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EcoP3)
                                    .addComponent(EcoP9, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EcoP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EcoP4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(EcoP10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(EcoP1)
                .addGap(18, 18, 18)
                .addComponent(EcoP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(EcoP3)
                .addGap(27, 27, 27)
                .addComponent(EcoP4)
                .addGap(18, 18, 18)
                .addComponent(EcoP5)
                .addGap(28, 28, 28)
                .addComponent(EcoP6)
                .addGap(18, 18, 18)
                .addComponent(EcoP7)
                .addGap(28, 28, 28)
                .addComponent(EcoP8)
                .addGap(18, 18, 18)
                .addComponent(EcoP9)
                .addGap(26, 26, 26)
                .addComponent(EcoP10)
                .addGap(35, 35, 35))
        );

        jSplitPane5.setLeftComponent(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        EcoR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR2ActionPerformed(evt);
            }
        });

        EcoR4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR4ActionPerformed(evt);
            }
        });

        EcoR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR3ActionPerformed(evt);
            }
        });

        EcoR6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR6ActionPerformed(evt);
            }
        });

        EcoR9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR9ActionPerformed(evt);
            }
        });

        EcoR10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR10ActionPerformed(evt);
            }
        });

        EcoR5.add(conejo);
        conejo.setText("Conejo");

        EcoR5.add(leon);
        leon.setText("Leon");

        EcoR5.add(hormiga);
        hormiga.setText("hormiga");

        EcoR7.add(desierto);
        desierto.setText("Desierto");
        desierto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desiertoActionPerformed(evt);
            }
        });

        EcoR7.add(bosqueTropical);
        bosqueTropical.setText("Bosque tropical");

        EcoR7.add(tundra);
        tundra.setText("Tundra ");

        EcoR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcoR1ActionPerformed(evt);
            }
        });

        EcoR8.add(competencia);
        competencia.setText("Competencia");
        competencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                competenciaActionPerformed(evt);
            }
        });

        EcoR8.add(simbiosis);
        simbiosis.setText("Simbiosis");

        EcoR8.add(depredadorPresa);
        depredadorPresa.setText("Depredador-presa");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EcoR2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addComponent(EcoR3)
                    .addComponent(EcoR4)
                    .addComponent(EcoR6)
                    .addComponent(EcoR9)
                    .addComponent(EcoR10)
                    .addComponent(EcoR1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(conejo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(leon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(hormiga, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(competencia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desierto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bosqueTropical, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(simbiosis, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tundra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(depredadorPresa))
                        .addGap(27, 27, 27))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(EcoR1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EcoR2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EcoR3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EcoR4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conejo)
                    .addComponent(leon)
                    .addComponent(hormiga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EcoR6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desierto)
                    .addComponent(bosqueTropical)
                    .addComponent(tundra))
                .addGap(24, 24, 24)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(competencia)
                    .addComponent(simbiosis)
                    .addComponent(depredadorPresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EcoR9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EcoR10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane5.setRightComponent(jPanel16);

        cronometro5.setText("00:00:00");

        jButton10.setBackground(new java.awt.Color(51, 51, 51));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Enviar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel10.setText("Puntaje");

        LabelTiempo4.setText("---------------");

        ecosistemasPuntajeLbl.setText("0");

        javax.swing.GroupLayout EcosistemasLayout = new javax.swing.GroupLayout(Ecosistemas);
        Ecosistemas.setLayout(EcosistemasLayout);
        EcosistemasLayout.setHorizontalGroup(
            EcosistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EcosistemasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cronometro5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(LabelTiempo4)
                .addGap(168, 168, 168)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addComponent(ecosistemasPuntajeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(EcosistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EcosistemasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSplitPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        EcosistemasLayout.setVerticalGroup(
            EcosistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EcosistemasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EcosistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cronometro5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(LabelTiempo4)
                    .addComponent(ecosistemasPuntajeLbl))
                .addContainerGap(468, Short.MAX_VALUE))
            .addGroup(EcosistemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EcosistemasLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jSplitPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        tabla_panel.addTab("Ecosistemas", Ecosistemas);

        jPanel2.add(tabla_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 880, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Creadores().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        manejarMateriaSeleccionada(jComboBox1);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CalcularPromBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularPromBtnActionPerformed
        // TODO add your handling code here:
        mostrarPromedio();
        
    }//GEN-LAST:event_CalcularPromBtnActionPerformed

    private void EnviarButtonEspanolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarButtonEspanolActionPerformed
        // TODO add your handling code here:
        
                // pregunta 1
          verificarRespuesta(mesa, espanolP1, true); // true si es la correcta
          verificarRespuesta(azul, espanolP1, false); // true si es la correcta
          verificarRespuesta(hermoso, espanolP1, false);
          
          verificarRespuestaAbierta(resEspanolp2,espanolP2,"ADVERBIO");
          verificarRespuestaAbierta(resEspanolp3,espanolP3,"ARBOL");
          verificarRespuestaAbierta(resEspanolp4,espanolP4,"CONTENTO");
          verificarRespuestaAbierta(resEspanolp5,espanolP5,"EXCLAMATIVA");
          verificarRespuestaAbierta(resEspanolp6,espanolP6,"PALABRAS QUE SUENAN IGUAL PERO TIENEN DIFERENTE SIGNIFICADO");
          
          // pregunta 7
          verificarRespuesta(transitivo, espanolP7, false);
          verificarRespuesta(intransitivo, espanolP7, true);
          verificarRespuesta(reflexivo, espanolP7, false);
          
          // pregunta 8
          
          verificarRespuesta(metafora, espanolP8, false);
          verificarRespuesta(simil, espanolP8, true);
          verificarRespuesta(personificacion, espanolP8, false);
          
          
          verificarRespuestaAbierta(resEspanolp9,espanolP9,"ACENTO ORTOGRAFICO");
          verificarRespuestaAbierta(resEspanolp10,espanolP10,"RELATO BREVE CON MORALEJA");
          
          LabelPuntaje.setText(String.valueOf(puntajeEspanol)); 
          
          actualizarPuntajeEnTabla("Español", puntajeEspanol);
          
          puntajeEspanol = 0;
          puntajeMatematicas = 0;
          puntajeIngles = 0;
          puntajeHumanidades = 0;
          
          detenerTimers();
          manejarEnviar(LabelTiempo);
          

        
    }//GEN-LAST:event_EnviarButtonEspanolActionPerformed

    private void resEspanolp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp2ActionPerformed

    private void azulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_azulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_azulActionPerformed

    private void mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesaActionPerformed

    private void resEspanolp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp4ActionPerformed

    private void resEspanolp10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp10ActionPerformed

    private void resEspanolp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp3ActionPerformed

    private void resEspanolp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp5ActionPerformed

    private void intransitivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intransitivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intransitivoActionPerformed

    private void resEspanolp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp6ActionPerformed

    private void resEspanolp9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resEspanolp9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resEspanolp9ActionPerformed

    private void EcoR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR2ActionPerformed

    private void EcoR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR4ActionPerformed

    private void EcoR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR3ActionPerformed

    private void EcoR6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR6ActionPerformed

    private void EcoR9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR9ActionPerformed

    private void EcoR10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR10ActionPerformed

    private void matRes7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes7ActionPerformed

    private void matRes8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes8ActionPerformed

    private void matRes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes1ActionPerformed

    private void matRes10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes10ActionPerformed

    private void matRes9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes9ActionPerformed

    private void matRes6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes6ActionPerformed

    private void matRes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes5ActionPerformed

    private void matRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes3ActionPerformed

    private void matRes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes4ActionPerformed

    private void matRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matRes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matRes2ActionPerformed

    private void desiertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desiertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desiertoActionPerformed

    private void EcoR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcoR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EcoR1ActionPerformed

    private void competenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_competenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_competenciaActionPerformed

    private void MatenviarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatenviarBtnActionPerformed
        // TODO add your handling code here:
        
        verificarRespuestaAbierta(matRes1,matP1,"16");
        verificarRespuestaAbierta(matRes2,matP2,"54");
        verificarRespuestaAbierta(matRes3,matP3,"7");
        verificarRespuestaAbierta(matRes4,matP4,"6");
        verificarRespuestaAbierta(matRes5,matP5,"9");
        verificarRespuestaAbierta(matRes6,matP6,"4");
        verificarRespuestaAbierta(matRes7,matP7,"ISOCELES");
        verificarRespuestaAbierta(matRes8,matP8,"25");
        verificarRespuestaAbierta(matRes9,matP9,"4");
        verificarRespuestaAbierta(matRes10,matP10,"1");
        
        PuntajeMatLbl.setText(String.valueOf(puntajeMatematicas));  
        actualizarPuntajeEnTabla("Matematicas", puntajeMatematicas);
        
          puntajeEspanol = 0;
          puntajeMatematicas = 0;
          puntajeIngles = 0;
          puntajeHumanidades = 0;
        
          detenerTimers();
          manejarEnviar(LabelTiempo1);
        
        
        
    }//GEN-LAST:event_MatenviarBtnActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void inglesRes8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes8ActionPerformed

    private void inglesRes7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes7ActionPerformed

    private void inglesRes10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes10ActionPerformed

    private void inglesRes6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes6ActionPerformed

    private void inglesRes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes5ActionPerformed

    private void inglesRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes3ActionPerformed

    private void inglesRes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes4ActionPerformed

    private void inglesRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes2ActionPerformed

    private void childrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childrenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_childrenActionPerformed

    private void childsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_childsActionPerformed

    private void inglesRes9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesRes9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inglesRes9ActionPerformed

    private void inglesEnviarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inglesEnviarBtnActionPerformed
        // TODO add your handling code here:
          verificarRespuesta(childs, inglesP1, false); // true si es la correcta
          verificarRespuesta(children, inglesP1, true); // true si es la correcta
          verificarRespuesta(child, inglesP1, false);
          
          verificarRespuestaAbierta(inglesRes2,inglesP2,"HOLA");
          verificarRespuestaAbierta(inglesRes3,inglesP3,"ESTOY FELIZ");
          // Pregunta 1
          verificarRespuestaAbierta(inglesRes4, inglesP4, "CAT"); // Respuesta correcta: "Cat"

// Pregunta 2
          verificarRespuestaAbierta(inglesRes5, inglesP5, "WENT"); // Respuesta correcta: "Went"

// Pregunta 3
verificarRespuestaAbierta(inglesRes6, inglesP6, "GRANDE"); // Respuesta correcta: "Grande"

// Pregunta 4
verificarRespuestaAbierta(inglesRes7, inglesP7, "RED"); // Respuesta correcta: "Red"

// Pregunta 5
verificarRespuestaAbierta(inglesRes8, inglesP8, "SAD"); // Respuesta correcta: "Sad"

// Pregunta 6
verificarRespuestaAbierta(inglesRes9, inglesP9, "WINDOW"); // Respuesta correcta: "Window"

// Pregunta 7
verificarRespuestaAbierta(inglesRes10, inglesP10, "PRETTY"); // Respuesta correcta: "Pretty"



          PuntajeInglesLabel.setText(String.valueOf(puntajeIngles)); 
          
          actualizarPuntajeEnTabla("Ingles", puntajeIngles);




          puntajeEspanol = 0;
          puntajeMatematicas = 0;
          puntajeIngles = 0;
          puntajeHumanidades = 0;

          detenerTimers();
          manejarEnviar(LabelTiempo2);

          

        
    }//GEN-LAST:event_inglesEnviarBtnActionPerformed

    private void tabla_panelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabla_panelStateChanged
        // TODO add your handling code here:
        
    int indiceSeleccionado = tabla_panel.getSelectedIndex();
    String tituloSeleccionado = tabla_panel.getTitleAt(indiceSeleccionado);

    // Resetear cronómetros y timers al cambiar de pestaña
    if ("Español".equals(tituloSeleccionado)) {
        resetCronometro("Español");
        timerEspanol.start();
    } else {
        timerEspanol.stop();
    }

    if ("Matemáticas".equals(tituloSeleccionado)) {
        resetCronometro("Matemáticas");
        timerMatematicas.start();
    } else {
        timerMatematicas.stop();
    }

    if ("Inglés".equals(tituloSeleccionado)) {
        resetCronometro("Inglés");
        timerIngles.start();
    } else {
        timerIngles.stop();
    }

    if ("Humanidades".equals(tituloSeleccionado)) {
        resetCronometro("Humanidades");
        timerHumanidades.start();
    } else {
        timerHumanidades.stop();
    }

    if ("Ecosistemas".equals(tituloSeleccionado)) {
        resetCronometro("Ecosistemas");
        timerEcosistemas.start();
    } else {
        timerEcosistemas.stop();
    }
}

private void resetCronometro(String materia) {
    switch (materia) {
        case "Español":
            horasEspanol = 0;
            minutosEspanol = 0;
            segundosEspanol = 0;
            cronometro.setText("00:00:00");
            break;
        case "Matemáticas":
            horasMatematicas = 0;
            minutosMatematicas = 0;
            segundosMatematicas = 0;
            cronometro2.setText("00:00:00");
            break;
        case "Inglés":
            horasIngles = 0;
            minutosIngles = 0;
            segundosIngles = 0;
            cronometro3.setText("00:00:00");
            break;
        case "Humanidades":
            horasHumanidades = 0;
            minutosHumanidades = 0;
            segundosHumanidades = 0;
            cronometro4.setText("00:00:00");
            break;
        case "Ecosistemas":
            horasEcosistemas = 0;
            minutosEcosistemas = 0;
            segundosEcosistemas = 0;
            cronometro5.setText("00:00:00");
            break;
    }

        
    }//GEN-LAST:event_tabla_panelStateChanged

    private void humanidadesEnviarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesEnviarBtnActionPerformed
        // TODO add your handling code here:
        
        // Pregunta 1
verificarRespuestaAbierta(humanidadesR1, humanidadesP1, "PLATÓN"); // Respuesta correcta: "Platón"

// Pregunta 2
verificarRespuestaAbierta(humanidadesR2, humanidadesP2, "LEONARDO DA VINCI"); // Respuesta correcta: "Leonardo da Vinci"

// Pregunta 3
verificarRespuestaAbierta(humanidadesR3, humanidadesP3, "SIGLO V"); // Respuesta correcta: "Siglo V"

// Pregunta 4
verificarRespuestaAbierta(humanidadesR4, humanidadesP4, "GRECIA"); // Respuesta correcta: "Grecia"

// Pregunta 5
verificarRespuestaAbierta(humanidadesR5, humanidadesP5, "MIGUEL DE CERVANTES"); // Respuesta correcta: "Miguel de Cervantes"

// Pregunta 6
verificarRespuestaAbierta(humanidadesR6, humanidadesP6, "EGIPCIA"); // Respuesta correcta: "Egipcia"

// Pregunta 7
verificarRespuestaAbierta(humanidadesR7, humanidadesP7, "LA CAÍDA DEL IMPERIO ROMANO DE OCCIDENTE"); // Respuesta correcta: "La caída del Imperio Romano de Occidente"

// Pregunta 8
verificarRespuestaAbierta(humanidadesR8, humanidadesP8, "POMPEYA"); // Respuesta correcta: "Pompeya"

// Pregunta 9
verificarRespuestaAbierta(humanidadesR9, humanidadesP9, "AUGUSTO"); // Respuesta correcta: "Augusto"

// Pregunta 10
verificarRespuestaAbierta(humanidadesR10, humanidadesP10, "LA RUEDA"); // Respuesta correcta: "La rueda"



        humanidadesPuntajeLbl.setText(String.valueOf(puntajeHumanidades));  
        actualizarPuntajeEnTabla("Humanidades", puntajeHumanidades);



          puntajeEspanol = 0;
          puntajeMatematicas = 0;
          puntajeIngles = 0;
          puntajeHumanidades = 0;
          
          
          detenerTimers();
          manejarEnviar(LabelTiempo3);
        
    }//GEN-LAST:event_humanidadesEnviarBtnActionPerformed

    private void humanidadesR6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR6ActionPerformed

    private void humanidadesR4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR4ActionPerformed

    private void humanidadesR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR1ActionPerformed

    private void humanidadesR5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR5ActionPerformed

    private void humanidadesR10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR10ActionPerformed

    private void humanidadesR8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR8ActionPerformed

    private void humanidadesR9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR9ActionPerformed

    private void humanidadesR7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR7ActionPerformed

    private void humanidadesR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR3ActionPerformed

    private void humanidadesR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanidadesR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_humanidadesR2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        
        verificarRespuestaAbierta(EcoR1, EcoP1, "FOTOSINTESIS");
        verificarRespuestaAbierta(EcoR2, EcoP2, "SELVA TROPICAL");
        verificarRespuestaAbierta(EcoR3, EcoP3, "OXIGENO");
        verificarRespuestaAbierta(EcoR4, EcoP4, "HABITAT");
        
        verificarRespuesta(leon, EcoP5, true);
        verificarRespuesta(conejo, EcoP5, false);
        verificarRespuesta(hormiga, EcoP5, false);
        
        
        verificarRespuesta(tundra, EcoP7, true);
        verificarRespuesta(bosqueTropical, EcoP7, false);
        verificarRespuesta(desierto, EcoP7, false);
        
        
        verificarRespuesta(depredadorPresa, EcoP8, true);
        verificarRespuesta(simbiosis, EcoP8, false);
        verificarRespuesta(competencia, EcoP8, false);
        
        verificarRespuestaAbierta(EcoR6, EcoP6, "DULCE");
        verificarRespuestaAbierta(EcoR9, EcoP9, "AGUA");
        verificarRespuestaAbierta(EcoR10, EcoP10, "DESIERTO");
       
        
        
        ecosistemasPuntajeLbl.setText(String.valueOf(puntajeEcosistemas));  
        actualizarPuntajeEnTabla("Ecosistemas", puntajeEcosistemas);



          puntajeEspanol = 0;
          puntajeMatematicas = 0;
          puntajeIngles = 0;
          puntajeHumanidades = 0;
          puntajeEcosistemas = 0;
          
          
          detenerTimers();
          manejarEnviar(LabelTiempo4);
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Obtener el texto del JTextArea
    String texto = jTextArea1.getText().trim();  // Obtener el texto y quitar espacios extra

    // Verificar si el texto no está vacío
    if (!texto.isEmpty()) {
        // Agregar el texto al modelo de la lista (DefaultListModel)
        modeloLista.addElement(texto);

        // Limpiar el JTextArea después de agregar el texto
        jTextArea1.setText("");
    } else {
        // Mostrar un mensaje si el campo está vacío
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor ingrese un texto.");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalcularPromBtn;
    private javax.swing.JLabel EcoP1;
    private javax.swing.JLabel EcoP10;
    private javax.swing.JLabel EcoP2;
    private javax.swing.JLabel EcoP3;
    private javax.swing.JLabel EcoP4;
    private javax.swing.JLabel EcoP5;
    private javax.swing.JLabel EcoP6;
    private javax.swing.JLabel EcoP7;
    private javax.swing.JLabel EcoP8;
    private javax.swing.JLabel EcoP9;
    private javax.swing.JTextField EcoR1;
    private javax.swing.JTextField EcoR10;
    private javax.swing.JTextField EcoR2;
    private javax.swing.JTextField EcoR3;
    private javax.swing.JTextField EcoR4;
    private javax.swing.ButtonGroup EcoR5;
    private javax.swing.JTextField EcoR6;
    private javax.swing.ButtonGroup EcoR7;
    private javax.swing.ButtonGroup EcoR8;
    private javax.swing.JTextField EcoR9;
    private javax.swing.JPanel Ecosistemas;
    private javax.swing.JButton EnviarButtonEspanol;
    private javax.swing.JPanel Español;
    private javax.swing.JPanel Humanidades;
    private javax.swing.JPanel Ingles;
    private javax.swing.JLabel LabelPromedio;
    private javax.swing.JLabel LabelPuntaje;
    private javax.swing.JLabel LabelTiempo;
    private javax.swing.JLabel LabelTiempo1;
    private javax.swing.JLabel LabelTiempo2;
    private javax.swing.JLabel LabelTiempo3;
    private javax.swing.JLabel LabelTiempo4;
    private javax.swing.JPanel Matematicas;
    private javax.swing.JButton MatenviarBtn;
    private javax.swing.JPanel Panel_examen;
    private javax.swing.JLabel PuntajeInglesLabel;
    private javax.swing.JLabel PuntajeMatLbl;
    private javax.swing.JTable TablaCalif;
    private javax.swing.JCheckBox azul;
    private javax.swing.JCheckBox bosqueTropical;
    private javax.swing.JCheckBox child;
    private javax.swing.JCheckBox children;
    private javax.swing.JCheckBox childs;
    private javax.swing.JCheckBox competencia;
    private javax.swing.JCheckBox conejo;
    private javax.swing.JLabel cronometro;
    private javax.swing.JLabel cronometro2;
    private javax.swing.JLabel cronometro3;
    private javax.swing.JLabel cronometro4;
    private javax.swing.JLabel cronometro5;
    private javax.swing.JCheckBox depredadorPresa;
    private javax.swing.JCheckBox desierto;
    private javax.swing.JLabel ecosistemasPuntajeLbl;
    private javax.swing.ButtonGroup espanol1;
    private javax.swing.ButtonGroup espanol7;
    private javax.swing.ButtonGroup espanol8;
    private javax.swing.JLabel espanolP1;
    private javax.swing.JLabel espanolP10;
    private javax.swing.JLabel espanolP2;
    private javax.swing.JLabel espanolP3;
    private javax.swing.JLabel espanolP4;
    private javax.swing.JLabel espanolP5;
    private javax.swing.JLabel espanolP6;
    private javax.swing.JLabel espanolP7;
    private javax.swing.JLabel espanolP8;
    private javax.swing.JLabel espanolP9;
    private javax.swing.JCheckBox hermoso;
    private javax.swing.JCheckBox hormiga;
    private javax.swing.JButton humanidadesEnviarBtn;
    private javax.swing.JLabel humanidadesP1;
    private javax.swing.JLabel humanidadesP10;
    private javax.swing.JLabel humanidadesP2;
    private javax.swing.JLabel humanidadesP3;
    private javax.swing.JLabel humanidadesP4;
    private javax.swing.JLabel humanidadesP5;
    private javax.swing.JLabel humanidadesP6;
    private javax.swing.JLabel humanidadesP7;
    private javax.swing.JLabel humanidadesP8;
    private javax.swing.JLabel humanidadesP9;
    private javax.swing.JLabel humanidadesPuntajeLbl;
    private javax.swing.JTextField humanidadesR1;
    private javax.swing.JTextField humanidadesR10;
    private javax.swing.JTextField humanidadesR2;
    private javax.swing.JTextField humanidadesR3;
    private javax.swing.JTextField humanidadesR4;
    private javax.swing.JTextField humanidadesR5;
    private javax.swing.JTextField humanidadesR6;
    private javax.swing.JTextField humanidadesR7;
    private javax.swing.JTextField humanidadesR8;
    private javax.swing.JTextField humanidadesR9;
    private javax.swing.ButtonGroup ingles1;
    private javax.swing.JButton inglesEnviarBtn;
    private javax.swing.JLabel inglesP1;
    private javax.swing.JLabel inglesP10;
    private javax.swing.JLabel inglesP2;
    private javax.swing.JLabel inglesP3;
    private javax.swing.JLabel inglesP4;
    private javax.swing.JLabel inglesP5;
    private javax.swing.JLabel inglesP6;
    private javax.swing.JLabel inglesP7;
    private javax.swing.JLabel inglesP8;
    private javax.swing.JLabel inglesP9;
    private javax.swing.JTextField inglesRes10;
    private javax.swing.JTextField inglesRes2;
    private javax.swing.JTextField inglesRes3;
    private javax.swing.JTextField inglesRes4;
    private javax.swing.JTextField inglesRes5;
    private javax.swing.JTextField inglesRes6;
    private javax.swing.JTextField inglesRes7;
    private javax.swing.JTextField inglesRes8;
    private javax.swing.JTextField inglesRes9;
    private javax.swing.JCheckBox intransitivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JCheckBox leon;
    private javax.swing.JLabel matP1;
    private javax.swing.JLabel matP10;
    private javax.swing.JLabel matP2;
    private javax.swing.JLabel matP3;
    private javax.swing.JLabel matP4;
    private javax.swing.JLabel matP5;
    private javax.swing.JLabel matP6;
    private javax.swing.JLabel matP7;
    private javax.swing.JLabel matP8;
    private javax.swing.JLabel matP9;
    private javax.swing.JTextField matRes1;
    private javax.swing.JTextField matRes10;
    private javax.swing.JTextField matRes2;
    private javax.swing.JTextField matRes3;
    private javax.swing.JTextField matRes4;
    private javax.swing.JTextField matRes5;
    private javax.swing.JTextField matRes6;
    private javax.swing.JTextField matRes7;
    private javax.swing.JTextField matRes8;
    private javax.swing.JTextField matRes9;
    private javax.swing.JCheckBox mesa;
    private javax.swing.JCheckBox metafora;
    private javax.swing.JCheckBox personificacion;
    private javax.swing.JCheckBox reflexivo;
    private javax.swing.JTextField resEspanolp10;
    private javax.swing.JTextField resEspanolp2;
    private javax.swing.JTextField resEspanolp3;
    private javax.swing.JTextField resEspanolp4;
    private javax.swing.JTextField resEspanolp5;
    private javax.swing.JTextField resEspanolp6;
    private javax.swing.JTextField resEspanolp9;
    private javax.swing.JCheckBox simbiosis;
    private javax.swing.JCheckBox simil;
    private javax.swing.JTabbedPane tabla_panel;
    private javax.swing.JCheckBox transitivo;
    private javax.swing.JCheckBox tundra;
    // End of variables declaration//GEN-END:variables


}
